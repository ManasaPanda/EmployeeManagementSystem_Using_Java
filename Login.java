package employee.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener{
    
     JTextField user;
     JPasswordField jpassword;
    
    Login()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel Username=new JLabel("UserName");
        Username.setBounds(40, 20, 100, 30);
       // Username.setForeground(Color.white);
        add(Username);
        
        
        user=new JTextField();
        user.setBounds(150, 20, 150, 30);
        add(user);
       
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        //lblpassword.setForeground(Color.white);
        add(lblpassword);
        
         jpassword = new JPasswordField();
        jpassword.setBounds(150, 70, 150, 30);
        add(jpassword);
        
        JButton Clickhere=new JButton("LOGIN");
        Clickhere.setBounds(150, 150, 150, 30);
        Clickhere.setBackground(Color.black);
        Clickhere.setForeground(Color.white);
        Clickhere.addActionListener(this);
        add(Clickhere);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);//to scaled a image
        ImageIcon i3=new ImageIcon(i2);//and we can not pass a image directly into jlabel so we need to conver it into imageicon
        JLabel image=new JLabel(i3);//as we can not directly add a imageicon into frame so we need to create a jlabel
        image.setBounds(350, 0, 200, 200);
        add(image);
                      
        setSize(600,300);
        setLocation(450,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        try{
            String username=user.getText();
            String password=jpassword.getText();
            
            Conn c=new Conn();
            String query="select * from login where username = '"+username+"'and password = '"+password+"'";
            
            ResultSet rs=c.s.executeQuery(query);/*used for execute query execute query can not directly call we need to 
            call is by using statement and statement is present inside Conn class so we need a conn class objects and it always
            a Resultset type value so we need to catch it by result set object and execute command only applicable for DDL command*/
            if(rs.next())//to check what was their inside table
            {
                setVisible(false);
                new Home();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid username and Password");//used to show a popup message
            }
            
        }
        catch(Exception ex){
        ex.printStackTrace();
        }
        
    }
    
}
