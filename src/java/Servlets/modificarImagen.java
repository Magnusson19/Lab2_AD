/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nilmc
 */
@WebServlet(name = "modificarImagen", urlPatterns = {"/modificarImagen"})
public class modificarImagen extends HttpServlet {

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
                
        Connection connection = null;
        try {
            
            
          String titulo = request.getParameter("titulo");
          String descripcion = request.getParameter("descripcion");
          String palabras_clave = request.getParameter("palabras_clave");
          String autor = request.getParameter("autor");
          String fecha_creacion = request.getParameter("fecha_creacion");
          String nom = request.getParameter("nom");
          java.util.Date fecha_alta = new Date();
          
          Class.forName("org.sqlite.JDBC");   
          
          connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\nilmc\\Desktop\\LAB1.db");
          PreparedStatement statement = connection.prepareStatement("insert into imagenes values (?, ?, ?, ?, ?, ?, ?)");
          statement.setString(1,titulo);
          statement.setString(2,descripcion);
          statement.setString(3,palabras_clave);
          statement.setString(4,autor);
          statement.setString(5,fecha_creacion);
          statement.setString(6,nom);
          statement.setString(7, fecha_alta.toString());
          
          int i = statement.executeUpdate();
          
          if (i > 0) {
              out.println("<html> "
                            + "<body> "
                                + "<h3>Registre realitzat!</h3>"
                                + "<form>"
                                    + "<p> <a href='menu.jsp'>Tornar al menú</a></p>"
                                    + "<br>"
                                    + "<p> <a href='registrarImagen.jsp'>Tornar a registrar una imatge</a></p>"
                                + "</form> "
                            + "</body>"
                          + "</html>");
          }
          /*Statement s = connection.createStatement();
          ResultSet r = s.executeQuery("select * from imagenes where titulo = 'hola' ");
            
          if(r.next()) out.println("OK");
          else out.println("ERROR");*/
          
          
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }   
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
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
