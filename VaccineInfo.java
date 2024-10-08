
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VaccineInfo extends JFrame {
    private JComboBox<String> nameComboBox;
    private JComboBox<String> vaccineComboBox;
    private JCheckBox firstDoseCheckBox;
    private JButton showButton;
    private JLabel resultLabel;

    public VaccineInfo() {
        // Set title and default close operation
        setTitle("Vaccine Info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);

        // Initialize components
        String[] names = { "Alice", "Bob", "Charlie", "David" };
        String[] vaccines = { "Pfizer", "Moderna", "AstraZeneca", "J&J" };
        nameComboBox = new JComboBox<>(names);
        vaccineComboBox = new JComboBox<>(vaccines);
        firstDoseCheckBox = new JCheckBox("1st Dose Taken?");
        showButton = new JButton("Show");
        resultLabel = new JLabel("Selected Info: ");

        // Add action listener to show button
        showButton.addActionListener(e -> displayInfo());

        // Layout setup
        setLayout(new GridLayout(5, 2));
        add(new JLabel("Select Name:"));
        add(nameComboBox);
        add(new JLabel("Select Vaccine:"));
        add(vaccineComboBox);
        add(firstDoseCheckBox);
        add(showButton);
        add(resultLabel);

        // Show frame
        setVisible(true);
    }

    // Method to display selected information
    private void displayInfo() {
        String name = (String) nameComboBox.getSelectedItem();
        String vaccine = (String) vaccineComboBox.getSelectedItem();
        String firstDose = firstDoseCheckBox.isSelected() ? "Yes" : "No";

        resultLabel.setText("Selected Info: " + name + ", Vaccine: " + vaccine + ", 1st Dose: " + firstDose);
    }

    // Main method to run the application
    public static void main(String[] args) {
        new VaccineInfo();
    }
}
