import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginSystem extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, resetButton;
    private JLabel messageLabel;
    private int attempts = 3;

    public LoginSystem() {
        // Set title and default close operation
        setTitle("Login System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Initialize components
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        messageLabel = new JLabel("Attempts remaining: 3");

        // Add action listener for login button
        loginButton.addActionListener(e -> verifyLogin());

        // Add action listener for reset button
        resetButton.addActionListener(e -> resetFields());

        // Layout setup
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);
        add(resetButton);
        add(messageLabel);

        // Show frame
        setVisible(true);
    }

    // Method to verify login
    private void verifyLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("12345")) {
            JOptionPane.showMessageDialog(this, "Login successful");
        } else {
            attempts--;
            if (attempts > 0) {
                messageLabel.setText("Attempts remaining: " + attempts);
                JOptionPane.showMessageDialog(this, "Username or Password is incorrect");
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed");
                loginButton.setEnabled(false);  // Disable login button after 3 failed attempts
            }
        }
    }

    // Method to reset fields
    private void resetFields() {
        usernameField.setText("");
        passwordField.setText("");
        messageLabel.setText("Attempts remaining: 3");
        attempts = 3;
        loginButton.setEnabled(true);  // Re-enable the login button
    }

    // Main method to run the application
    public static void main(String[] args) {
        new LoginSystem();
    }
}

