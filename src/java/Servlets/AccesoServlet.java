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

public class AccesoServlet extends HttpServlet {

    private boolean respuesta = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String correo = request.getParameter("correo").trim();
            String clave = request.getParameter("clave").trim();

            UsuarioDTO usuario_dto = new UsuarioDTO();
            usuario_dto.setCorreo(correo);
            usuario_dto.setClave(clave);

            UsuarioDAO usuario_dao = new UsuarioDAO();

            respuesta = usuario_dao.AccesoSistema(usuario_dto);
            response.getWriter().write(Boolean.toString(respuesta));
            if (respuesta) {
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("usuario", correo);
                // Modo de emergencia
                sesion.setAttribute("nombreUsuario", usuario_dto.getCorreo());
                sesion.setAttribute("nombres", usuario_dto.getNombres());
                sesion.setAttribute("apellidos", usuario_dto.getApellidos());
                sesion.setAttribute("celular", usuario_dto.getCelular());
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
