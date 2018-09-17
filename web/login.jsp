<%-- 
    Document   : login
    Created on : 14/09/2018, 12:09:18
    Author     : nilmc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Benvingut!</h1>
        <form action="login">
            <label for="uname"><b>Username</b></label>
            <input type="text" name="uname" required >
            <br><br>
            <label for="psw"><b>Password</b></label>
            <input type="password" name="psw" required>
            <input type="submit" value="Submit">
        </form>
        
    </body>
</html>
