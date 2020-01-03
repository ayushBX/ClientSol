package db;

import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnect {
    static public Connection c;
    static public Statement st;
    public static PreparedStatement insertClient;
    public static PreparedStatement getClient;
    public static PreparedStatement updateClient;
    
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/clientsoldb","root","incapp");
            st=c.createStatement();
            insertClient=c.prepareStatement("insert into "
      + "client_info (name,gender,dob,country,address,"
                    + "language) values (?,?,?,?,?,?)");
            getClient=c.prepareStatement("select * from "
      + "client_info where name like ?");
            updateClient=c.prepareStatement("update client_info  "
 + "set name=?,gender=?,dob=?,country=?,address=?,language=?  "
                    + "where cid=?");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
