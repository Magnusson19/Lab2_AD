<%-- 
    Document   : list
    Created on : 28/09/2018, 22:24:02
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar_imagenes</title>
        <link rel="stylesheet" type="text/css" href="style/estilos.css">
    </head>
    <sql:setDataSource var = "snapshot" driver = "org.sqlite.JDBC"
         url = "jdbc:sqlite:C:\\Users\\nilmc\\Desktop\\LAB1.db"/>
        
                
    <sql:query dataSource = "${snapshot}" var = "result">
        SELECT * from imagenes
    </sql:query>
    <body>
        <h2>Todas las imagenes</h2>
        <table border = "1" width = "100%">
         <tr>
            <th>Titulo</th>
            <th>Descripcion</th>
            <th>Palabras Clave</th>
            <th>Autor</th>
            <th>Usuario</th>
            <th>Fecha de Creacion</th>
            <th>Fecha de Alta</th>
            <th>Nombre</th>
            <th>Imagen</th>
            <th>Modificar</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td> <c:out value = "${row.titulo}"/></td>
               <td> <c:out value = "${row.descripcion}"/></td>
               <td> <c:out value = "${row.palabras_clave}"/></td>
               <td> <c:out value = "${row.autor}"/></td>
               <td> <c:out value="${sessionScope.nombre}"/></td>
               <td> <c:out value = "${row.fecha_creacion}"/></td>
               <td> <c:out value = "${row.fecha_alta}"/></td>
               <td> <c:out value = "${row.nombre}"/></td>
               <td> <a href="imagenes\\<c:out value = "${row.nombre}"/>" target="_blank"> Link </a> </td>
               <c:choose>
                   <c:when test="${sessionScope.nombre == row.usuario}">
                       <td><a href="modificarImagen.jsp?id=<c:out value = "${row.id_imagen}"/>"> Modificar imatge </a></td>
                   </c:when>
                   
                   <c:when test="${sessionScope.nombre != row.usuario}">
                       <td>No has enregistrat aquesta imatge</td>
                   </c:when>
               </c:choose>
            </tr>
         </c:forEach>
      </table>
    </body>
</html>
