
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dr
 */
public class DbConnection {
    public static Connection getConnection(){
        Connection con = null;
        try {
            try {  
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:sqlserver://zaraq-pc\\SQLEXPRESS;user=Zaraq;password=iLoveAliMola;database=assignment4Db");
            System.out.println("Connected to database !");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } 
        
        return con;
        
    }
}
