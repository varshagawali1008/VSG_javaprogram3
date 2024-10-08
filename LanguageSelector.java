
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LanguageSelector extends JFrame {
    private JComboBox<String> languageComboBox;
    private JLabel displayLabel;
    private JButton showButton;

    public LanguageSelector() {
        // Set title and default close operation
        setTitle("Language Selector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Initialize components
        String[] languages = { "Java", "Python", "C++", "JavaScript", "Ruby" };
        languageComboBox = new JComboBox<>(languages);
        displayLabel = new JLabel("Selected Language: ");
        showButton = new JButton("Show");

        // Add action listener to button
        showButton.addActionListener(e -> {
            String selectedLanguage = (String) languageComboBox.getSelectedItem();
            displayLabel.setText("Selected Language: " + selectedLanguage);
        });

        // Set layout and add components
        setLayout(new FlowLayout());
        add(languageComboBox);
        add(showButton);
        add(displayLabel);
    }

    // Main method to run the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LanguageSelector selector = new LanguageSelector();
            selector.setVisible(true);
        });
    }
}
