
package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Splash extends JFrame implements ActionListener{
   
    Splash()
    {
        getContentPane().setBackground(Color.white);//to set Background color of frame
        setLayout(null);
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(50, 30, 1200, 60);
        heading.setFont(new Font("serif",Font.BOLD,60));//to change font style of heading
        heading.setForeground(Color.red);//to chnage font color of heading
        
        add(heading);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);//to scaled a image
        ImageIcon i3=new ImageIcon(i2);//and we can not pass a image directly into jlabel so we need to conver it into imageicon
        JLabel image=new JLabel(i3);//as we can not directly add a imageicon into frame so we need to create a jlabel
        image.setBounds(30, 100, 1100, 500);
        add(image);
        
        JButton Clickhere=new JButton("CLICK TO CONTINUE");
        Clickhere.setBounds(400, 400, 300, 70);
        Clickhere.setBackground(Color.black);
        Clickhere.setForeground(Color.white);
        Clickhere.addActionListener(this);
        image.add(Clickhere);//to add button with respect to image
        
        setSize(1170,650);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(170,50);
        
        while(true)
        {
            heading.setVisible(false);
            try
            {
                Thread.sleep(500);
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            heading.setVisible(true);
            try
            {
                Thread.sleep(500);
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
   
    public static void main(String[] arg)
    {
        new Splash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new Login();
    }
}
