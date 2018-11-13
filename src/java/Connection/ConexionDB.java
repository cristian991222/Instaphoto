package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    private static Connection conn;
    private final String url = "jdbc:mysql://localhost:3306/db_instaphoto";
    private final String driver = "com.mysql.jdbc.Driver";

    public Connection ConnectDB()  {

        try {
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            conn = DriverManager.getConnection(url, "root", "");
   
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return conn;
    }
    
    public void Close() {
        if (ConnectDB() != null) {
            try {
                ConnectDB().close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}