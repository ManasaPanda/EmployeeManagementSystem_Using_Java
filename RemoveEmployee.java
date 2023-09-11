package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class RemoveEmployee extends JFrame implements ActionListener{
    Choice cEmpId;
    
    JButton delet,back;
    
    RemoveEmployee()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel labelempId = new JLabel("EMPLOYEE ID");
        labelempId.setBounds(50,50,100,30);
        add(labelempId);
        
        cEmpId=new Choice();
        cEmpId.setBounds(180,53,150,30);
        add(cEmpId);
        
        try{
            Conn c=new Conn();
            String query="select * from employee";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next())
            {
                cEmpId.add(rs.getString("empId"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("NAME");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200,100,150,30);
        add(lblname);
        
        JLabel labelaname = new JLabel("AADHAR");
        labelaname.setBounds(50,150,100,30);
        add(labelaname);
        
        JLabel lblaname = new JLabel();
        lblaname.setBounds(200,150,200,30);
        add(lblaname);
        
        JLabel labelemail = new JLabel("EMAIL");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200,200,250,30);
        add(lblemail);
        
        
        JLabel labelphone = new JLabel("PHONE");
        labelphone.setBounds(50,250,100,30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200,250,150,30);
        add(lblphone);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where empId= '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next())
            {
                lblphone.setText(rs.getString("phone"));
                lblaname.setText(rs.getString("aadhar"));
                lblname.setText(rs.getString("name"));
                lblemail.setText(rs.getString("email"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {

                        try{
                   Conn c=new Conn();
                   String query="select * from employee where empId= '"+cEmpId.getSelectedItem()+"'";
                   ResultSet rs= c.s.executeQuery(query);
                   while(rs.next())
                   {
                       lblphone.setText(rs.getString("phone"));
                       lblaname.setText(rs.getString("aadhar"));
                       lblname.setText(rs.getString("name"));
                       lblemail.setText(rs.getString("email"));
                   }
               }
               catch(SQLException ex)
               {
                   ex.printStackTrace();
               }
            }
        });
        
        delet =new JButton("REMOVE");
        delet.setBounds(80,300,130,30);
        delet.setBackground(Color.BLACK);
        delet.setForeground(Color.white);
        delet.addActionListener(this);
        add(delet);
        
        back =new JButton("BACK");
        back.setBounds(220,300,130,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);//to scaled a image
        ImageIcon i3=new ImageIcon(i2);//and we can not pass a image directly into jlabel so we need to conver it into imageicon
        JLabel image=new JLabel(i3);//as we can not directly add a imageicon into frame so we need to create a jlabel
        image.setBounds(380, 0, 600, 400);
        add(image);
        
        setSize(1000,400);
        setLocation(300,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new RemoveEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== delet)
        {
              try{
                   Conn c=new Conn();
                   String query="delete from employee where empId= '"+cEmpId.getSelectedItem()+"'";
                   c.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null, "Employee information deleted successfully");
                   setVisible(false);
               }
               catch(SQLException ex)
               {
                   ex.printStackTrace();
               }
            
        }
        else
        {
            setVisible(false);
            new Home();
        }
    }
}
