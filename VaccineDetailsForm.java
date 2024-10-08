import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VaccineDetailsForm extends JFrame implements ActionListener {
    private JComboBox<String> nameComboBox;
    private JComboBox<String> vaccineComboBox;
    private JCheckBox firstDoseCheckBox;
    private JLabel resultLabel;
    private JButton showButton;

    public VaccineDetailsForm() {
        setTitle("Vaccine Details");
        setLayout(new GridLayout(5, 2, 10, 10));

        String[] names = { "Alice", "Bob", "Charlie", "David" };
        String[] vaccines = { "Covishield", "Covaxin", "Sputnik V" };
        
        nameComboBox = new JComboBox<>(names);
        vaccineComboBox = new JComboBox<>(vaccines);
        firstDoseCheckBox = new JCheckBox("1st Dose Taken");
        resultLabel = new JLabel("Details will be shown here");
        showButton = new JButton("Show");
        showButton.addActionListener(this);

        add(new JLabel("Name:"));
        add(nameComboBox);
        add(new JLabel("Vaccine:"));
        add(vaccineComboBox);
        add(firstDoseCheckBox);
        add(showButton);
        add(new JLabel("Result:"));
        add(resultLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showButton) {
            String selectedName = (String) nameComboBox.getSelectedItem();
            String selectedVaccine = (String) vaccineComboBox.getSelectedItem();
            String firstDoseStatus = firstDoseCheckBox.isSelected() ? "Yes" : "No";

            String result = "Name: " + selectedName + ", Vaccine: " + selectedVaccine +
                            ", 1st Dose Taken: " + firstDoseStatus;
            resultLabel.setText(result);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VaccineDetailsForm::new);
    }
}
