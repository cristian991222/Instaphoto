
package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {

    private static Connection conn;
    private final String url = "jdbc:mysql://localhost:3306/db_instaphoto";
    private final String driver = "com.mysql.jdbc.Driver";
    
    private static ConexionDB connection = null;
    
    public static ConexionDB getInstance() {
        
        if (connection == null) {
            connection = new ConexionDB();
        }
        return connection;
    }
        
    public Connection ConnectDB () { 
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException e ) {
            throw new ClassCastException(e.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
    
    public static void Cerrar() throws SQLException {
        
        if (conn != null) {
            conn.close();
        }
    }
    
    public static void main(String[] args) {
        
        ConexionDB.getInstance().ConnectDB();
        
    }
    
}
