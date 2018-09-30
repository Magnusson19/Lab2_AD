/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author nilmc
 */
@WebServlet(name = "error", urlPatterns = {"/error"})
public class error extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            if (request.getParameter("pagina").equals("login")) {
                out.println("<html> "
                            + "<body> "
                                + "<h3>Usuari o contrassenya incorrecte</h3>"
                                + "<form>"
                                    + "<p> <a href='login.jsp'>Tornar al login</a></p>"
                                + "</form> "
                            + "</body>"
                          + "</html>");
            }
            else if (request.getParameter("pagina").equals("buida")) {
                out.println("<html> "
                            + "<body> "
                                + "<h3>BD buida</h3>"
                                    + "<p> <a href='registrarImagen.jsp'>Tornar a registrar una imatge</a></p>"
                            + "</body>"
                          + "</html>");
            }
            else if (request.getParameter("pagina").equals("exists")) {
                out.println("<html> "
                            + "<body> "
                                + "<h3>L'imatge ja exisetix</h3>"
                                    + "<p> <a href='registrarImagen.jsp'>Tornar a registrar una imatge</a></p>"
                            + "</body>"
                          + "</html>");
            }
            else if (request.getParameter("pagina").equals("existsM")) {
                out.println("<html> "
                            + "<body> "
                                + "<h3>L'imatge ja exisetix</h3>"
                                    + "<p> <a href='menu.jsp'>Tornar al menú</a></p>"
                            + "</body>"
                          + "</html>");
            }
            else if (request.getParameter("pagina").equals("format")) {
                out.println("<html> "
                            + "<body> "
                                + "<h3>Format d'imatge incorrecte</h3>"
                                    + "<p> <a href='registrarImagen.jsp'>Tornar a registrar una imatge</a></p>"
                            + "</body>"
                          + "</html>");
            }
            else if (request.getParameter("pagina").equals("formatM")) {
                out.println("<html> "
                            + "<body> "
                                + "<h3>Format d'imatge incorrecte</h3>"
                                    + "<p> <a href='menu.jsp'>Tornar al menú</a></p>"
                            + "</body>"
                          + "</html>");
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
