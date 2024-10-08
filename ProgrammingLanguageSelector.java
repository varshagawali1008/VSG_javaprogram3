import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgrammingLanguageSelector extends JFrame implements ActionListener {
    private JComboBox<String> languageComboBox;
    private JLabel displayLabel;
    private JButton showButton;

    public ProgrammingLanguageSelector() {
        setTitle("Programming Language Selector");
        setLayout(new FlowLayout());

        String[] languages = { "Java", "Python", "C++", "JavaScript", "Ruby", "Go", "Swift" };
        languageComboBox = new JComboBox<>(languages);
        
        showButton = new JButton("Show");
        showButton.addActionListener(this);
        
        displayLabel = new JLabel("Selected Language: None");

        add(languageComboBox);
        add(showButton);
        add(displayLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showButton) {
            String selectedLanguage = (String) languageComboBox.getSelectedItem();
            displayLabel.setText("Selected Language: " + selectedLanguage);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProgrammingLanguageSelector::new);
    }
}
