<%-- 
    Document   : registrarImagen
    Created on : 21/09/2018, 13:25:10
    Author     : nilmc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="image; charset=UTF-8">
        <title>Modificar_Imatge</title>
    </head>
    
        <sql:setDataSource var = "snapshot" driver = "org.sqlite.JDBC"
         url = "jdbc:sqlite:C:\\Users\\nilmc\\Desktop\\LAB1.db"/>
        
                
        <sql:query dataSource = "${snapshot}" var = "result">
            SELECT * from imagenes where id_imagen=<%=Integer.parseInt(request.getParameter("id"))%>
        </sql:query>
         
         <c:forEach var="row" items="${result.rows}">
             <c:out value="${row}"/>
         </c:forEach>
                  
        <h1>Modificar Imagen</h1>
        <form action="modificarImagen" method="POST">
            <label for="titulo"><b>Título</b></label>
            <input type="text" name="titulo" value="${result.rows[0].titulo}">
            <br><br>
            <label for="descripcion"><b>Descripción</b></label>
            <textarea name="descripcion" rows="5" cols="25" >${result.rows[0].descripcion}</textarea>
            <br><br>
            <label for="palabras_clave"><b>Palabras clave</b></label>
            <input type="text" name="palabras_clave" value="${result.rows[0].palabras_clave}">
            <br><br>
            <label for="autor"><b>Autor</b></label>
            <input type="text" name="autor" value="${result.rows[0].autor}">
            <br><br>
            <label for="fecha_creacion"><b>Fecha de creación</b></label>
            <input type="date" name="fecha_creacion" value="${result.rows[0].fecha_creacion}">
            <br><br>
            <label for="imagen"><b>Inserta Imagen</b></label>
            <input type="file" name="imagen" value="${result.rows[0].imagen}">
            <br><br>
            <input type="hidden" name="id" value="${result.rows[0].id_imagen}">
            <input type="hidden" name="fecha_alta" value="${result.rows[0].fecha_alta}">
            <br>
            <input type="submit" value="Submit">
        </form>
    
</html>

