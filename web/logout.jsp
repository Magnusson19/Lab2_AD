<%-- 
    Document   : logout
    Created on : 30/09/2018, 12:45:29
    Author     : nilmc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <% session.invalidate();%>
        <c:redirect url="login.jsp" > </c:redirect>
    </body>
</html>
