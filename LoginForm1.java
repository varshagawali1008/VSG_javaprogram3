import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm1 extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton resetButton;
    private JButton loginButton;

    public LoginForm1() {
        setTitle("Login Form");
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(resetButton);
        add(loginButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            usernameField.setText("");
            passwordField.setText("");
        } else if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            // Add logic for login validation here
            JOptionPane.showMessageDialog(this, "Username: " + username + "\nPassword: " + password);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginForm1::new);
    }
}
