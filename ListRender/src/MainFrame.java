import com.sun.tools.javac.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame{
    private JList imageList;

    public MainFrame()  {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 700);
        setTitle("PDF Manager");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(true);
        DefaultListModel<BufferedImage> model = new DefaultListModel<>();
        try {
            model.add(0, ImageIO.read(new File("image-0.jpg")));
            model.add(1, ImageIO.read(new File("image-1.jpg")));
            model.add(2, ImageIO.read(new File("image-2.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageList = new JList(model);
        imageList.setCellRenderer(new ImageListCellRenderer());
        add(new JScrollPane(imageList), BorderLayout.CENTER);
        setVisible(true);

    }
}
