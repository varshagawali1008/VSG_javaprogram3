import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    
    // Constructor to setup the GUI components
    public LoginPage() {
        // Set title for the frame
        setTitle("Login Page");
        
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Create components
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        JButton resetButton = new JButton("Reset");

        // Add components to the layout
        gbc.insets = new Insets(10, 10, 10, 10);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(userLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(userField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        add(loginButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(resetButton, gbc);
        
        // Button Actions
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = String.valueOf(passField.getPassword());
                
                if (username.equals("admin") && password.equals("admin123")) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials. Try Again!");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userField.setText("");
                passField.setText("");
            }
        });

        // Set frame size and make it visible
        setSize(300, 200);
        setLocationRelativeTo(null);  // Center the window
        setVisible(true);
    }

    // Main method to run the program
    public static void main(String[] args) {
        new LoginPage();
    }
}
