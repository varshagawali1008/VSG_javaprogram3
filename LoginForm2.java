import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm2 extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton resetButton;
    private int attemptCount = 0;

    public LoginForm2() {
        setTitle("Login Form");
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(resetButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (attemptCount < 3) {
                if (username.equals("user") && password.equals("pass")) {
                    JOptionPane.showMessageDialog(this, "Login successful");
                    attemptCount = 0; // Reset attempts on successful login
                } else {
                    attemptCount++;
                    if (attemptCount < 3) {
                        JOptionPane.showMessageDialog(this, "Username or Password is incorrect");
                    } else {
                        JOptionPane.showMessageDialog(this, "Login Failed");
                    }
                }
            }
        } else if (e.getSource() == resetButton) {
            usernameField.setText("");
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginForm2::new);
    }
}
