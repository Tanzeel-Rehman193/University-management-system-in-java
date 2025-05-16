package university.management.system;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection Conn;
    public Statement s;
    public Conn(){
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/um","root" ,"#t4n233l193@");
          s = Conn.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeConnection() {

    }
}
