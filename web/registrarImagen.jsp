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
<c:choose>
    <c:when test="${sessionScope.nombre == null}">
        <c:redirect url="login.jsp"> </c:redirect>
    </c:when>
</c:choose>

<html>
    <head>
        <meta http-equiv="Content-Type" content="image; charset=UTF-8">
        <title>Registrar_Imatge</title>
    </head>
    <body>
        <h1>Registrar Imagen</h1>
        <form action="registrarImagen" method="POST" enctype="multipart/form-data">
            <label for="titulo"><b>Título</b></label>
            <input type="text" name="titulo" required >
            <br><br>
            <label for="descripcion"><b>Descripción</b></label>
            <textarea name="descripcion" rows="5" cols="25" required></textarea>
            <br><br>
            <label for="palabras_clave"><b>Palabras clave</b></label>
            <input type="text" name="palabras_clave" required>
            <br><br>
            <label for="autor"><b>Autor</b></label>
            <input type="text" name="autor" required>
            <br><br>
            <label for="fecha_creacion"><b>Fecha de creación</b></label>
            <input type="date" name="fecha_creacion" required>
            <br><br>
            <label for="imagen"><b>Inserta Imagen</b></label>
            <input type="file" name="imagen" accept="image/JPEG" required>
            <br><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
