package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import net.proteanit.sql.DbUtils;


public class ViewEmployee extends JFrame implements ActionListener{
    
    JTable table;
    Choice cemployeeId;
    JButton search,print,update,back;
    
    ViewEmployee()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Employee id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        
        table=new JTable();
        cemployeeId = new Choice();
        cemployeeId.setBounds(180,20,150,20);
        add(cemployeeId);
        
        try{
            Conn c =new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");//to fetch data from table
            
            while(rs.next())
            {
              cemployeeId.add(rs.getString("empid"));
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        try{
            Conn c =new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");//to fetch data from table
            table.setModel(DbUtils.resultSetToTableModel(rs));//to write all data that was fetch into table
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);//to take a scroll bar in table 
        jsp.setBounds(0, 100, 900, 550);
        add(jsp);
        
        
        search =new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        
        print =new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update =new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back =new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,650);
        setLocation(250,50);
        setVisible(true);
    }
    
   public static void main(String[] args)
   {
       new ViewEmployee();
   }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource() == search)
        {
            String query="select * from employee where empid='"+cemployeeId.getSelectedItem()+"'";//to find details of empid selected from table 
            try
            { 
                Conn c1=new Conn();
                ResultSet rs1=c1.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs1));
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(e.getSource() == print)
        {
          try
          {
              table.print();
          }catch(Exception ex)
          {
              ex.printStackTrace();
          }
        }
        else if(e.getSource() == update)
        {
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        }
        else
        {
            setVisible(false);
            new Home();
        }
    }
}
