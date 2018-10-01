<%-- 
    Document   : menu
    Created on : 21/09/2018, 12:33:12
    Author     : nilmc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<c:choose>
    <c:when test="${sessionScope.nombre == null}">
        <c:redirect url="login.jsp"> </c:redirect>
    </c:when>
</c:choose>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <link rel="stylesheet" type="text/css" href="style/estilos.css">
    </head>
    <body>
        <h2>Benvingut al Menu</h2>
        <form>
            <p> <a href='registrarImagen.jsp' class="botonMenu">Registrar una imatge</a></p>
            <br>
            <p> <a href='list.jsp' class="botonMenu">Llistar totes les imatges</a></p>
            <br>
            <p> <a href='buscarImagen.jsp' class="botonMenu">Buscar imatge</a></p>
            <br>
            <p> <a href='logout.jsp' class="botonMenu">Sortir de la sessió</a></p>
            <br>
        </form>
    </body>
</html>
