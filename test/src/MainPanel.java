import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPanel extends JPanel {

    private SmallPanel smallPanel;
    public MainPanel() {
        setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
        setBackground(Color.DARK_GRAY);
        smallPanel = new SmallPanel();
        add(smallPanel);
        smallPanel.addMouseListener((MouseAdapter) new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    smallPanel.setBorderColor(Color.CYAN);
                }
                else {
                    smallPanel.setBorderColor(Color.MAGENTA);
                }
            }
        });

    }
}
