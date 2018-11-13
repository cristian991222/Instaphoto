package DAO;

import Connection.ConexionDB;
import Connection.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DTO.UsuarioDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private boolean respuesta = false;
    // private Connection conn = null;
   

    public boolean AccesoSistema(UsuarioDTO usuario) {

        ConexionDB conn = new ConexionDB();
        
        try {
            String query = "SELECT * FROM tbl_usuario WHERE correo = ? AND clave = ?";

            pst = conn.ConnectDB().prepareStatement(query);
            pst.setString(1, usuario.getCorreo());
            pst.setString(2, usuario.getClave());
            rs = pst.executeQuery();
            
            while (rs.next()) {
                
                UsuarioDTO usuario_dto = new UsuarioDTO();
                usuario_dto.setId(Integer.parseInt(rs.getString("id_usuario")));
                usuario_dto.setNombres(rs.getString("nombres"));
                usuario_dto.setApellidos(rs.getString("apellidos"));
                usuario_dto.setCorreo(rs.getString("correo"));
                usuario_dto.setCelular(rs.getString("numero_celular"));
                respuesta = true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            conn.Close();
        }

        return respuesta;
    }
    
    public boolean RegistrarUsuario (UsuarioDTO usuario) {
     
        Connect conn = new Connect();

        try {            
            String insertar = "INSERT INTO tbl_usuario (nombres, apellidos, correo, clave, fecha_nacimiento, numero_celular) VALUES (?, ?, ?, ?, ?, ?)";            
            pst = conn.Conectar().prepareStatement(insertar); 
            
            pst.setString(1, usuario.getNombres());
            pst.setString(2, usuario.getApellidos());
            pst.setString(3, usuario.getCorreo());
            pst.setString(4, usuario.getClave());
            pst.setString(5, usuario.getFecha_nacimiento());
            pst.setString(6, usuario.getCelular());
            
            pst.executeUpdate();
            respuesta = true;
        } 
        catch (SQLException ex) {
            System.out.println("Error DAO -> " + ex);
        }
        finally {
            try {
                conn.Conectar().close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return respuesta;
    }
    
    // Prueba de verificación
    public static void main(String[] args) {

        UsuarioDAO usuario = new UsuarioDAO();
        //Pasar valores de parámetros cada uno, no por objecto para hacer la prueba 
        //System.out.println(usuario.AccesoSistema("prueba123@hotmail.com", "123"));
    }

}
