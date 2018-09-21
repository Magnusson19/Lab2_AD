<%-- 
    Document   : registrarImagen
    Created on : 21/09/2018, 13:25:10
    Author     : nilmc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="image; charset=UTF-8">
        <title>Registrar_Imatge</title>
    </head>
    <body>
        <form action="registrarImagen">
            <label for="titulo"><b>Título</b></label>
            <input type="text" name="titulo" required >
            <br><br>
            <label for="descripcion"><b>Descripción</b></label>
            <input type="text" size="50" height="50" name="descripcion" required>
            <br><br>
            <label for="palabras_clave"><b>Palabras clave</b></label>
            <input type="text" name="palabras_clave" required>
            <br><br>
            <label for="autor"><b>Autor</b></label>
            <input type="text" name="autor" required>
            <br><br>
            <label for="fecha_creacion"><b>Fecha de creación</b></label>
            <input type="text" name="fecha_creacion" required>
        </form>
    </body>
</html>
