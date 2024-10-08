import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAnalyzer extends JFrame {
    // Declare components
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JLabel charCountLabel;
    private JScrollPane scrollPane;

    public TextAnalyzer() {
        // Set title and default close operation
        setTitle("Text Analyzer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Initialize components
        textArea = new JTextArea(10, 30);
        wordCountLabel = new JLabel("Words: 0");
        charCountLabel = new JLabel("Characters: 0");

        // Add JTextArea to JScrollPane for scrollbars
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Add a key listener to JTextArea to update counts
        textArea.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                updateCounts();
            }
        });

        // Add components to layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        // Create a panel for labels
        JPanel countPanel = new JPanel(new FlowLayout());
        countPanel.add(wordCountLabel);
        countPanel.add(charCountLabel);

        // Add count panel to the bottom
        add(countPanel, BorderLayout.SOUTH);
    }

    // Method to update word and character counts
    private void updateCounts() {
        String text = textArea.getText();
        String[] words = text.trim().split("\\s+");
        int wordCount = text.isEmpty() ? 0 : words.length;
        int charCount = text.length();

        wordCountLabel.setText("Words: " + wordCount);
        charCountLabel.setText("Characters: " + charCount);
    }

    // Main method to run the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextAnalyzer analyzer = new TextAnalyzer();
            analyzer.setVisible(true);
        });
    }
}

