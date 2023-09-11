
package employee.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//register dirver
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","Password");//creating a connection
            s=c.createStatement();//create statement
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
