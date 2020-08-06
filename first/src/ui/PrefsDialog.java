package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrefsDialog extends JDialog {

    private JButton okButton;
    private JButton cancelButton;
    private JSpinner portSpinner;
    private SpinnerNumberModel spinnerModel;
    private JTextField userFiled;
    private JPasswordField passField;
    private JPanel controlsPanel;
    private JPanel buttonsPanel;


    private PrefsListener prefsListener;

    public PrefsDialog(JFrame parent) {
        super(parent, "Preferences", false);

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
        portSpinner = new JSpinner(spinnerModel);

        userFiled = new JTextField(10);
        passField = new JPasswordField(10);
        passField.setEchoChar('*');

        layoutComponents();

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = (Integer) portSpinner.getValue();
                String user = userFiled.getText();
                char[] password = passField.getPassword();
                if (prefsListener != null) {
                    prefsListener.preferencesSet(user, new String(password), value);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(300, 200);
        setLocationRelativeTo(parent);
    }

    private void layoutComponents() {
        controlsPanel = new JPanel();
        buttonsPanel = new JPanel();

        int space = 10;
        Border titleBorder = BorderFactory.createTitledBorder("Database preferences");
        Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);

        controlsPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
        
        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);

        controlsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();


        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 0;

//first row
        gc.insets = rightPadding;
        gc.anchor = GridBagConstraints.EAST;
        controlsPanel.add(new JLabel("User: "), gc);
        gc.gridx++;
        gc.insets = noPadding;
        gc.anchor = GridBagConstraints.WEST;
        controlsPanel.add(userFiled, gc);
//second row
        gc.gridy++;
        gc.gridx = 0;

        gc.insets = rightPadding;
        gc.anchor = GridBagConstraints.EAST;
        controlsPanel.add(new JLabel("Password: "), gc);
        gc.gridx++;
        gc.insets = noPadding;
        gc.anchor = GridBagConstraints.WEST;
        controlsPanel.add(passField, gc);
//third row
        gc.gridy++;
        gc.gridx = 0;

        gc.insets = rightPadding;
        gc.anchor = GridBagConstraints.EAST;
        controlsPanel.add(new JLabel("Port: "), gc);
        gc.gridx++;
        gc.insets = noPadding;
        gc.anchor = GridBagConstraints.WEST;
        controlsPanel.add(portSpinner, gc);

        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(okButton, gc);
        buttonsPanel.add(cancelButton, gc);

        Dimension btnSize = cancelButton.getPreferredSize();
        okButton.setPreferredSize(btnSize);

        setLayout(new BorderLayout());
        add(controlsPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

    }
    public void setDefaults(String user, String password, int port) {
        userFiled.setText(user);
        passField.setText(password);
        portSpinner.setValue(port);
    }

    public void setPrefsListener(PrefsListener prefsListener) {
        this.prefsListener = prefsListener;
    }
}
