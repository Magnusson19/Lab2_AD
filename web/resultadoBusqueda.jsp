<%-- 
    Document   : resultadoBusqueda
    Created on : 01-Oct-2018, 18:40:10
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
        <title>Resultado búsqueda</title>
        <link rel="stylesheet" type="text/css" href="style/estilos.css">
    </head>
    <sql:setDataSource var = "snapshot" driver = "org.sqlite.JDBC"
         url = "jdbc:sqlite:C:\\Users\\myPC\\Desktop\\LAB1.db"/>
        
                
    <sql:query dataSource = "${snapshot}" var = "result">
        ${query}
    </sql:query>
     <body>
        <h2>Resultado de búsqueda</h2>
         
         <c:forEach var = "row" items = "${result.rows}">
            
             <div class="imagen">   
             <img src="imagenes\\<c:out value = "${row.nombre}"/>"> <br>
               <c:choose>
                   <c:when test="${sessionScope.nombre == row.autor}">
                       <a class="botonMenu" href="modificarImagen.jsp?id=<c:out value = "${row.id_imagen}"/>"> Modificar imatge </a> <br><br>
                   </c:when>
               </c:choose>
             </div>
         </c:forEach>                                         
      
        <form class="menu">
            <p> <a href='buscarImagen.jsp'class="botonMenu">Buscar imatge</a></p><br>
                                 <br>
                                   <p> <a class="botonMenu" href='menu.jsp'>Tornar a menu</a></p>
                                   <br>
                      </form> 
    </body>
</html>
