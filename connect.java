
import java.sql.*;

public class connect 
{
    Connection c;
    Statement s;
    connect()
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelDatabase","root","parvez");
        s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
