package ui;

import common.Utils;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PersonFileFilter extends FileFilter  {
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String ext = Utils.getFileExtension(f.getName());
        if (ext == null) {
            return false;
        }
        if (ext.equals("per")) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Person Files (*.per)";
    }
}
