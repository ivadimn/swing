import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton okBtn;
    private JList ageList;
    private JComboBox empCombo;
    private JCheckBox citizenCheck;
    private JTextField taxField;
    private JLabel taxLabel;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private ButtonGroup genderGrpup;


    private FormListener formListener;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        okBtn = new JButton("Ok");
        citizenCheck = new JCheckBox();
        taxField = new JTextField(10);
        taxLabel = new JLabel("Tax ID: ");
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        genderGrpup = new ButtonGroup();

    /// setup name label
        nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        nameLabel.setLabelFor(nameField);
    /// setup okbtn
        okBtn.setMnemonic(KeyEvent.VK_O);

    /// setup radiogropu
        genderGrpup.add(maleButton);
        genderGrpup.add(femaleButton);
        maleButton.setActionCommand("Male");
        femaleButton.setActionCommand("Female");
        maleButton.setSelected(true);

    /// setup checkbox
        taxField.setEnabled(false);
        taxLabel.setEnabled(false);
        citizenCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isTicked = citizenCheck.isSelected();
                taxField.setEnabled(isTicked);
                taxLabel.setEnabled(isTicked);
            }
        });

    /// setup listbox
        ageList = new JList();
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "Under 18"));
        ageModel.addElement(new AgeCategory(1, "from 18 to 65"));
        ageModel.addElement(new AgeCategory(2, "over 65"));
        ageList.setModel(ageModel);
        ageList.setPreferredSize(new Dimension(90, 70));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);

    /// setup combobox

        empCombo = new JComboBox();
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("Employed");
        empModel.addElement("Self-employed");
        empModel.addElement("Unemployed");
        empCombo.setModel(empModel);
        empCombo.setSelectedIndex(0);



        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occupationField.getText();
                AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
                String empCat = (String) empCombo.getSelectedItem();
                String taxId = taxField.getText();
                boolean usCitizen = citizenCheck.isSelected();
                String gender = genderGrpup.getSelection().getActionCommand();

                FormEvent ev = new FormEvent(this, name, occupation,
                        ageCat.getId(), empCat, taxId, usCitizen, gender);
                if (formListener != null) {
                    formListener.formEventOccurred(ev);
                }
            }
        });
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        layoutComponents();
    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.NONE;

        /// First line ///
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(nameField, gc);

        /// Second line ///

        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(occupationLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(occupationField, gc);

        /// forth line ///
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Age: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(ageList, gc);

        /// forth line ///
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Employe: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(empCombo, gc);

    /// fifth line ///
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("US Citizen: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(citizenCheck, gc);

        /// six line ///
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(taxLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(taxField, gc);

        /// seven line ///
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.05;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Gender: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(maleButton, gc);

        /// eight line ///
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.05;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(femaleButton, gc);


        /// nine line ///
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);
    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}


