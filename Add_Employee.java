
package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Add_Employee extends JFrame implements ActionListener{
        
    Random ran=new Random();
    int number=ran.nextInt(9999);//it will generate random number and those numbers are 4 digit integer
    
    JButton add,back;
    JTextField tfname,tSalary,tAddress,tPhone,tEmail,tDesignation,tAadhar,tname;
    JComboBox cbEducation;
    JLabel lblempid;
    JDateChooser dcdob;
    
    Add_Employee()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading=new JLabel("FILL EMPLOYEE DETAILS");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);
        
        JLabel lname=new JLabel("Name");
        lname.setBounds(50, 150, 150, 30);
        lname.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lname);
        
        tname=new JTextField();
        tname.setBounds(200, 150, 150, 30);
        add(tname);
        
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
        
        dcdob=new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
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
        
        String courses[]={"choose","BBA","BCA","BSC","B.TECH","B.COM","MBA","MCA","MTECH","MSC","PHD","Others"};
        cbEducation=new JComboBox(courses);
        cbEducation.setBackground(Color.white);
        cbEducation.setBounds(600, 300, 150, 30);
        add(cbEducation);
        
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
        
        tAadhar=new JTextField();
        tAadhar.setBounds(600, 350, 150, 30);
        add(tAadhar);
        
        JLabel lempid=new JLabel("Employee id");
        lempid.setBounds(50, 400, 150, 30);
        lempid.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lempid);
        
        lblempid=new JLabel("" + number);
        lblempid.setBounds(200, 400, 150, 30);
        lblempid.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lblempid);
        
        add=new JButton("ADD DETAILS");
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
        new Add_Employee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add)
        {
            String name=tname.getText();
            String fname=tfname.getText();
            String dob= ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();//to get a date from date field
            String salary=tSalary.getText();
            String address=tAddress.getText();
            String phone=tPhone.getText();
            String email=tEmail.getText();
            String education=(String)cbEducation.getSelectedItem();//to get selected item from dropdown or combobox
            String designation = tDesignation.getText();
            String aadhar = tAadhar.getText();
            String empid= lblempid.getText();
            
            try{
            
                Conn conn=new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empid+"')";
                conn.s.executeUpdate(query);//used to execute DML command
                JOptionPane.showMessageDialog(null,"Details added successfully");
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
