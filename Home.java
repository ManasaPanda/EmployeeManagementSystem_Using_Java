
package employee.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Home extends JFrame implements ActionListener {
    
        JButton add,view,update,remove;
        
        Home()
        {
            setSize(1120,630);
            setLocation(200,100);
            setLayout(null);
            
            
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
            Image i2=i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);//to scaled a image
            ImageIcon i3=new ImageIcon(i2);//and we can not pass a image directly into jlabel so we need to conver it into imageicon
            JLabel image=new JLabel(i3);//as we can not directly add a imageicon into frame so we need to create a jlabel
            image.setBounds(0, 0, 1120, 630);
            add(image);
            
            JLabel heading = new JLabel("EMPLOYEE MANAGENENT SYSYTEM");
            heading.setBounds(550, 20, 480, 40);
            heading.setFont(new Font("serif",Font.BOLD,25));//raleway,tahoma
            image.add(heading);
            
            add=new JButton("ADD EMPLOYEE");
            add.setBounds(600, 80, 150, 40);
            add.addActionListener(this);
            image.add(add);
            
            view=new JButton("VIEW EMPLOYEES");
            view.setBounds(820, 80, 150, 40);
            view.addActionListener(this);
            image.add(view);
            
            update=new JButton("UPDATE EMPLOYEE");
            update.setBounds(600, 140, 150, 40);
            update.addActionListener(this);
            image.add(update);
            
            remove=new JButton("REMOVE EMPLOYEE");
            remove.setBounds(820, 140, 150, 40);
            remove.addActionListener(this);
            image.add(remove);
            
            
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
            
        }
        
    public static void main(String[] args)
    {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add)
        {
            setVisible(false);
            new Add_Employee();
        }
        else if(e.getSource() == view)
        {
            setVisible(false);
            new ViewEmployee();
        }
        else if(e.getSource() == update)
        {
            setVisible(false);
            new ViewEmployee();   
        }
        else
        {
            setVisible(false);
            new RemoveEmployee();
        
        }
    }
}
