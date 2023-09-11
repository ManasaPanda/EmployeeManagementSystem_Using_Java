
package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JButton add,back;
    JTextField tfname,tSalary,tAddress,tPhone,tEmail,tDesignation,tAadhar,teducation;
    JLabel lblempid;
    String empId;
    UpdateEmployee(String empId)
    {
        this.empId=empId;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading=new JLabel("UPDATE EMPLOYEE DETAILS");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);
        
        JLabel lname=new JLabel("Name");
        lname.setBounds(50, 150, 150, 30);
        lname.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(fname);
        
        tfname=new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        add(tfname);
        
        JLabel ldob=new JLabel("Date Of Birth");
        ldob.setBounds(50, 200, 150, 30);
        ldob.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(ldob);
        
        JLabel lbldcdob=new JLabel();
        lbldcdob.setBounds(200, 200, 150, 30);
        add(lbldcdob);
        
        JLabel lSalary=new JLabel("Salary");
        lSalary.setBounds(400, 200, 150, 30);
        lSalary.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lSalary);
        
        tSalary=new JTextField();
        tSalary.setBounds(600, 200, 150, 30);
        add(tSalary);
        
        JLabel lAddress=new JLabel("Address");
        lAddress.setBounds(50, 250, 150, 30);
        lAddress.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lAddress);
        
        tAddress=new JTextField();
        tAddress.setBounds(200, 250, 150, 30);
        add(tAddress);
        
        JLabel lPhone=new JLabel("Phone");
        lPhone.setBounds(400, 250, 150, 30);
        lPhone.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lPhone);
        
        tPhone=new JTextField();
        tPhone.setBounds(600, 250, 150, 30);
        add(tPhone);
        
        JLabel lEmail=new JLabel("Email");
        lEmail.setBounds(50, 300, 150, 30);
        lEmail.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lEmail);
        
        tEmail=new JTextField();
        tEmail.setBounds(200, 300, 150, 30);
        add(tEmail);
        
         JLabel lEducation=new JLabel("Highest Education");
        lEducation.setBounds(400, 300, 180, 30);
        lEducation.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lEducation);
        
        teducation=new JTextField();
        teducation.setBounds(600, 300, 150, 30);
        add(teducation);
        
        JLabel lDesignation=new JLabel("Designation");
        lDesignation.setBounds(50, 350, 150, 30);
        lDesignation.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lDesignation);
        
        tDesignation=new JTextField();
        tDesignation.setBounds(200, 350, 150, 30);
        add(tDesignation);
        
        JLabel lAddhar=new JLabel("Aadhar Number");
        lAddhar.setBounds(400, 350, 150, 30);
        lAddhar.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lAddhar);
        
        JLabel lblAadhar=new JLabel();
        lblAadhar.setBounds(600, 350, 150, 30);
        add(lblAadhar);
        
        JLabel lempid=new JLabel("Employee id");
        lempid.setBounds(50, 400, 150, 30);
        lempid.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lempid);
        
        lblempid=new JLabel("");
        lblempid.setBounds(200, 400, 150, 30);
        lblempid.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lblempid);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where empId = '"+empId+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                lblname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                lbldcdob.setText(rs.getString("dob"));
                tSalary.setText(rs.getString("salary"));
                tAddress.setText(rs.getString("address"));
                tPhone.setText(rs.getString("phone"));
                tEmail.setText(rs.getString("email"));
                teducation.setText(rs.getString("education"));
                tDesignation.setText(rs.getString("designation"));
                lblAadhar.setText(rs.getString("aadhar"));
                lblempid.setText(rs.getString("empId"));
             
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        add=new JButton("UPDATE DETAILS");
        add.setBounds(250, 500, 150, 40);
       add.addActionListener(this);
       add.setBackground(Color.black);
       add.setForeground(Color.white);
        add(add);
        
        back=new JButton("BACK");
        back.setBounds(450, 500, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        
        setSize(900,650);
        setLocation(250,50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new UpdateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add)
        {
           
            String fname=tfname.getText();
            String salary=tSalary.getText();
            String address=tAddress.getText();
            String phone=tPhone.getText();
            String email=tEmail.getText();
            String education=teducation.getText();
            String designation = tDesignation.getText();
            try{
            
                Conn conn=new Conn();
                String query = "update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empId='"+empId+"'";
                conn.s.executeUpdate(query);//used to execute DML command
                JOptionPane.showMessageDialog(null,"Details update successfully");
                setVisible(false);
                new Home();
            } catch(Exception ex)
            {
                  ex.printStackTrace();
            }
        
        }
        else if(e.getSource() == back)
        {
            setVisible(false);
            new Home();
        }
    }
}
