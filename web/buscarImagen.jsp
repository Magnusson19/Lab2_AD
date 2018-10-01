<%-- 
    Document   : buscarImagen
    Created on : 30-Sep-2018, 11:41:21
    Author     : myPC
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Imagen</title>
        <link rel="stylesheet" type="text/css" href="style/estilos.css">
    </head>
    <body>
        <h1>Buscar Imagen</h1>
        <form action="buscarImagen" method="GET" enctype="multipart/form-data">
            <label for="titulo"><b>Título</b></label>
            <input type="text" name="titulo" >
            <br><br>
            <label for="palabras_clave"><b>Palabras clave</b></label>
            <input type="text" name="palabras_clave" >
            <br><br>
            <label for="autor"><b>Autor</b></label>
            <input type="text" name="autor" >
            <br><br>
            <label for="fecha_creacion"><b>Fecha de creación</b></label>
            <input type="date" name="fecha_creacion" >
            <br><br>
            <input type="submit" value="Submit" class="botonMenu">
        </form>
    </body>
</html>
