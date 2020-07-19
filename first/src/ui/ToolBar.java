import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {

    private JButton helloButton;
    private JButton goodbuyButton;

    private StringListener textListener;

    public ToolBar() {
        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new FlowLayout(FlowLayout.LEFT));
        helloButton = new JButton("Hello");
        goodbuyButton = new JButton("Goodbuy");
        helloButton.addActionListener(this);
        goodbuyButton.addActionListener(this);

        add(helloButton);
        add(goodbuyButton);
    }

    public void setStringListener(StringListener listener) {
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == helloButton) {
            if (textListener != null) {
                textListener.textEmitted("Hello\n");
            }
        }
        else if (clicked == goodbuyButton) {
            if (textListener != null) {
                textListener.textEmitted("Goodbuy\n");
            }
        }
    }
}
