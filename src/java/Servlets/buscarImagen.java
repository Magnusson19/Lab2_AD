/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author myPC
 */
@WebServlet(name = "buscarImagen", urlPatterns = {"/buscarImagen"})
public class buscarImagen extends HttpServlet {

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
            Class.forName("org.sqlite.JDBC");   
            //connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\nilmc\\Desktop\\LAB1.db");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\nilmc\\Desktop\\LAB1.db");
            final String path = "C:\\Users\\nilmc\\Documents\\NetBeansProjects\\Lab2_AD\\web\\imagenes"; 
            String[] campos = { "titulo", "palabras_clave", "autor", "fecha_creacion"};
            String query = "";
            query += "select * from imagenes";
            int pos = 0;
            for (int i = 0; i < 4; i++){
                if(request.getParameter(campos[i]) != null && !request.getParameter(campos[i]).isEmpty()){
                    query = pos > 0 ? query + " and " + campos[i] + "= '" + request.getParameter(campos[i]) + "'" : query + " where "+ campos[i] + " like '%" + request.getParameter(campos[i]) + "%'";
                    pos++;
                }
            }
            
            if(query.contains("where")){                
                request.setAttribute("query", query);
                request.getRequestDispatcher("resultadoBusqueda.jsp").forward(request, response);
            }
            
           out.println(MostrarPaginaSinResultados());
         }
          
        catch(SQLException e)
        {          
            out.println(MostrarPaginaSinResultados());
        } 
        catch (ClassNotFoundException e) 
        {
            System.err.println(e.getMessage());
                out.println(MostrarPaginaSinResultados());
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
    
    private String MostrarPaginaSinResultados(){
        return  "<html> "
                + "<head><link rel='stylesheet' type='text/css' href='style/estilos.css'></head>"
                                    + "<body> "
                                        + "<h3>No s'ha trobat cap imatge! </h3>"
                                        + "<form>"
                                            + "<p> <a href='buscarImagen.jsp'>Buscar imatge</a></p>"
                                            + "<br>"
                                            + "<p> <a href='menu.jsp'>Tornar a menu</a></p>"
                                            + "<br>"
                                        + "</form> "
                                    + "</body>"
                                + "</html>";
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
