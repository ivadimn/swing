import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageListCellRenderer extends DefaultListCellRenderer {

    private SmallImagePanel panel;
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        if (value instanceof BufferedImage) {
            panel = new SmallImagePanel((BufferedImage) value);
            panel.setFocused(isSelected);
            return panel;
        }
        else {
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    }
}
