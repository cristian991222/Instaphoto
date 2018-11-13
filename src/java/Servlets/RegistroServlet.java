package Servlets;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Connection.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroServlet extends HttpServlet {

    private boolean respuesta = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String nombres = request.getParameter("nombre");
            String apellidos = request.getParameter("apellido");
            String correo = request.getParameter("correo");
            String clave = request.getParameter("clave");
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            String numeroCelular = request.getParameter("celular");

//            UsuarioDTO usuario_dto = new UsuarioDTO();
//            usuario_dto.setNombres(nombres);
//            usuario_dto.setApellidos(apellidos);
//            usuario_dto.setCorreo(correo);
//            usuario_dto.setClave(clave);
//            usuario_dto.setFecha_nacimiento(fechaNacimiento);
//            usuario_dto.setCelular(numeroCelular);
//            
//            UsuarioDAO usuario_dao = new UsuarioDAO();


            ConexionDB conn = new ConexionDB();
            PreparedStatement pst = null;
            
            try {
                
                String insertar = "INSERT INTO tbl_usuario (nombres, apellidos, correo, clave, fecha_nacimiento, numero_celular) VALUES (?, ?, ?, ?, ?, ?)";
                pst = conn.ConnectDB().prepareStatement(insertar);

                pst.setString(1, nombres);
                pst.setString(2, apellidos);
                pst.setString(3, correo);
                pst.setString(4, clave);
                pst.setString(5, fechaNacimiento);
                pst.setString(6, numeroCelular);

                pst.executeUpdate();
                respuesta = true;
                
            } catch (SQLException ex) {
                System.out.println("Error DAO -> " + ex);
            } finally {
                try {
                   conn.Close();
                } catch (Exception ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (respuesta) {
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("usuarioTmp", correo);
            }
            
            response.getWriter().write(Boolean.toString(respuesta));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
