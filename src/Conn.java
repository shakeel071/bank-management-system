
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){

        try{
         
         c=DriverManager.getConnection("jdbc:mysql:///new1","root","shakeel@111");
         s=c.createStatement();
        }
        catch(Exception e){
  System.out.println(e);
        }
    }
}
