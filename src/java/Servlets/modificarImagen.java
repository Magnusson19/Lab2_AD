/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.awt.Image;
import java.io.File;
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
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author nilmc
 */
@WebServlet(name = "modificarImagen", urlPatterns = {"/modificarImagen"})
@MultipartConfig
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
            Class.forName("org.sqlite.JDBC");   
          
          connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\nilmc\\Desktop\\LAB1.db");
          
                final String path = "C:\\Users\\nilmc\\OneDrive\\Documents\\NetBeansProjects\\Lab2_AD\\web\\imagenes";
                final Part filePart = request.getPart("imagen");
                String type = filePart.getContentType();
                if (!type.equals("jpeg")) {
                    response.sendRedirect("error?pagina=formatM");
                    return;
                }
                final String fileName = getFileName(filePart);
                
                PreparedStatement ps = connection.prepareStatement("select * from imagenes where nombre=?");
                ps.setString(1, fileName);

                ResultSet rs = ps.executeQuery();
            

                if (!rs.next()) {
                    OutputStream outS = null;
                    InputStream filecontent = null;
                    try {
                        outS = new FileOutputStream(new File(path + File.separator
                                + fileName));
                        filecontent = filePart.getInputStream();

                        int read = 0;
                        final byte[] bytes = new byte[1024];

                        while ((read = filecontent.read(bytes)) != -1) {
                            outS.write(bytes, 0, read);
                        }
                    } catch (FileNotFoundException fne) {
                        out.println("You either did not specify a file to upload or are "
                                + "trying to upload a file to a protected or nonexistent "
                                + "location.");
                        out.println("<br/> ERROR: " + fne.getMessage());

                    } finally {
                        if (outS != null) {
                            outS.close();
                        }
                        if (filecontent != null) {
                            filecontent.close();
                        }
                    }

                    int id = Integer.parseInt(request.getParameter("id"));  //Perque no agafa l'1 si es passa per parametre?
                    String titulo = request.getParameter("titulo");
                    String descripcion = request.getParameter("descripcion");
                    String palabras_clave = request.getParameter("palabras_clave");
                    String autor = request.getParameter("autor");
                    String fecha_creacion = request.getParameter("fecha_creacion");


                    PreparedStatement statement = connection.prepareStatement("update imagenes set titulo=?, descripcion=?,"
                                                                             +"palabras_clave=?, autor=?, fecha_creacion=?, nombre=? where id_imagen=?");

                    statement.setString(1,titulo);
                    statement.setString(2,descripcion);
                    statement.setString(3,palabras_clave);
                    statement.setString(4,autor);
                    statement.setString(5,fecha_creacion);
                    statement.setString(6,fileName);
                    statement.setInt(7, id);

                    int i = statement.executeUpdate();

                    if (i > 0) {
                        out.println("<html> "
                                      + "<body> "
                                          + "<h3>Modificació realitzada!</h3>"
                                              + "<p> <a href='menu.jsp'>Tornar al menú</a></p>"
                                      + "</body>"
                                    + "</html>");
                    }
                }
                else response.sendRedirect("error?pagina=existsM");
          
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
    private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
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
