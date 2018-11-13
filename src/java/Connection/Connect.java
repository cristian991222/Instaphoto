package Connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Connect {

    public String db = "db_instaphoto";
    public String url = "jdbc:mysql://localhost:3306/db_instaphoto";
    public String user = "root";
    public String pass = "";


   public Connection Conectar(){

       Connection conn = null;

       try{

           try {
               Class.forName("com.mysql.jdbc.Driver");
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
           }

           conn = DriverManager.getConnection(this.url, this.user, this.pass);

       }catch(SQLException ex){

           JOptionPane.showMessageDialog(null, ex);

       }
       return conn;
   }
   
   public static void main(String[] args) {       
       Connect cn = new Connect();
       cn.Conectar();
   }
}
   
