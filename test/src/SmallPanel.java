import javax.swing.*;
import java.awt.*;

public class SmallPanel extends JPanel {

    public SmallPanel() {
        setPreferredSize(new Dimension(150, 150));
        setBackground(Color.ORANGE);
        setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 5));
    }

    public void setBorderColor(Color color) {
        setBorder(BorderFactory.createLineBorder(color, 5));
    }
}
