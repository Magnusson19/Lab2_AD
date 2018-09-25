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
        <h1>Registrar Imagen</h1>
        <form action="registrarImagen">
            <label for="titulo"><b>Título</b></label>
            <input type="text" name="titulo">
            <br><br>
            <label for="descripcion"><b>Descripción</b></label>
            <textarea name="descripcion" rows="5" cols="25" ></textarea>
            <br><br>
            <label for="palabras_clave"><b>Palabras clave</b></label>
            <input type="text" name="palabras_clave">
            <br><br>
            <label for="autor"><b>Autor</b></label>
            <input type="text" name="autor">
            <br><br>
            <label for="fecha_creacion"><b>Fecha de creación</b></label>
            <input type="date" name="fecha_creacion">
            <br><br>
            <label for="imagen"><b>Inserta Imagen</b></label>
            <input type="file" name="imagen">
            <br><br>
            <label for="nom"><b>Nombre del fichero</b></label>
            <input type="text" name="nom">
            <br><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
