import javax.swing.*;
public class SampleTest extends JFrame
{//inheriting JFrame
JFrame f;
SampleTest()
{
JButton b=new JButton("click");//create button
b.setBounds(130,100,100, 40);
add(b);//adding button on frame
setSize(400,500);
setLayout(null);
setVisible(true);
}
public static void main(String[] args)
{
new SampleTest();
}
}