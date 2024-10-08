import java.awt.*;
import javax.swing.*;

public class PanelTest extends JFrame {
    private JButton b, b1, b2;
    private JLabel l;

    public PanelTest() {
        // Creating a label to display text
        l = new JLabel("panel label");

        // Creating new buttons
        b = new JButton("button1");
        b1 = new JButton("button2");
        b2 = new JButton("button3");

        // Creating a panel to add buttons and label
        JPanel p = new JPanel();
        
        // Adding buttons and label to panel
        p.add(b);
        p.add(b1);
        p.add(b2);
        p.add(l);

        // Set background color of panel
        p.setBackground(Color.red);

        // Adding panel to frame
        add(p);
        
        // Setting the size of frame
        setSize(300, 300);
        
        // Setting default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Setting frame visibility
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PanelTest());
    }
}
