import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VaccinationDetailForm extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField firstDoseField;
    private JTextField secondDoseField;
    private JComboBox<String> vaccineComboBox;
    private JButton submitButton;

    public VaccinationDetailForm() {
        setTitle("Vaccination Details");
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JLabel firstDoseLabel = new JLabel("1st Dose:");
        JLabel secondDoseLabel = new JLabel("2nd Dose:");
        JLabel vaccineLabel = new JLabel("Vaccine:");

        nameField = new JTextField(20);
        firstDoseField = new JTextField(10);
        secondDoseField = new JTextField(10);
        
        String[] vaccines = { "Covishield", "Covaxin", "Sputnik V" };
        vaccineComboBox = new JComboBox<>(vaccines);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        add(nameLabel);
        add(nameField);
        add(firstDoseLabel);
        add(firstDoseField);
        add(secondDoseLabel);
        add(secondDoseField);
        add(vaccineLabel);
        add(vaccineComboBox);
        add(new JLabel()); // Empty cell
        add(submitButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String firstDose = firstDoseField.getText();
            String secondDose = secondDoseField.getText();
            String vaccine = (String) vaccineComboBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, 
                "Name: " + name + 
                "\n1st Dose: " + firstDose + 
                "\n2nd Dose: " + secondDose + 
                "\nVaccine: " + vaccine);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VaccinationDetailForm::new);
    }
}
