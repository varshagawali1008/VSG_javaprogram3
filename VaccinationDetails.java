import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VaccinationDetails extends JFrame {

    // Constructor to set up the GUI
    public VaccinationDetails() {
        // Set title for the frame
        setTitle("Vaccination Details");

        // Set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Labels for the vaccination details
        JLabel nameLabel = new JLabel("Name:");
        JLabel doseLabel = new JLabel("Dose:");
        JLabel vaccineLabel = new JLabel("Vaccine:");

        // Text fields for name and dose
        JTextField nameField = new JTextField(20);
        JTextField firstDoseField = new JTextField(5);
        JTextField secondDoseField = new JTextField(5);

        // Text area for output and a scroll pane
        JTextArea outputArea = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(outputArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        // Label to show word and character counts
        JLabel wordCharCountLabel = new JLabel("Words: 0 | Characters: 0");

        // Vaccine options
        String[] vaccines = {"Covishield", "Covaxin", "Sputnik V"};
        JComboBox<String> vaccineDropdown = new JComboBox<>(vaccines);

        // Button to submit and display the details
        JButton submitButton = new JButton("Submit");

        // Button to reset the form
        JButton resetButton = new JButton("Reset");

        // Add components to the layout
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Name field
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);
        gbc.gridx = 1;
        add(nameField, gbc);
        
        // Dose fields
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(doseLabel, gbc);
        gbc.gridx = 1;
        add(new JLabel("1st Dose:"), gbc);
        gbc.gridx = 2;
        add(firstDoseField, gbc);
        gbc.gridx = 3;
        add(new JLabel("2nd Dose:"), gbc);
        gbc.gridx = 4;
        add(secondDoseField, gbc);
        
        // Vaccine selection
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(vaccineLabel, gbc);
        gbc.gridx = 1;
        add(vaccineDropdown, gbc);
        
        // Submit and Reset buttons
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(submitButton, gbc);
        gbc.gridx = 1;
        add(resetButton, gbc);
        
        // Text area with scroll pane
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        add(scrollPane, gbc);
        
        // Label to display word and character count
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 5;
        add(wordCharCountLabel, gbc);

        // Action for the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get user input
                String name = nameField.getText();
                String firstDose = firstDoseField.getText();
                String secondDose = secondDoseField.getText();
                String vaccine = (String) vaccineDropdown.getSelectedItem();
                
                // Display vaccination details in the text area
                outputArea.setText("Vaccination Details:\n");
                outputArea.append("Name: " + name + "\n");
                outputArea.append("1st Dose: " + firstDose + "\n");
                outputArea.append("2nd Dose: " + secondDose + "\n");
                outputArea.append("Vaccine: " + vaccine + "\n");

                // Update word and character count
                updateWordCharCount(outputArea.getText(), wordCharCountLabel);
            }
        });

        // Action for the reset button
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                firstDoseField.setText("");
                secondDoseField.setText("");
                outputArea.setText("");
                vaccineDropdown.setSelectedIndex(0);
                wordCharCountLabel.setText("Words: 0 | Characters: 0");
            }
        });

        // Set the frame size and visibility
        setSize(600, 400);
        setLocationRelativeTo(null);  // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Method to count words and characters in the text
    private void updateWordCharCount(String text, JLabel label) {
        String[] words = text.trim().split("\\s+");
        int wordCount = (text.trim().isEmpty()) ? 0 : words.length;
        int charCount = text.length();
        label.setText("Words: " + wordCount + " | Characters: " + charCount);
    }

    // Main method to launch the application
    public static void main(String[] args) {
        new VaccinationDetails();
    }
}
