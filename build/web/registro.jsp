<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registro de Nacimiento</title>
</head>
<body>
    <h1 style="text-align:center;">Registro de Nacimiento</h1>
    <form action="AgregarNacimientoServlet" method="post" style="margin-left:auto; margin-right:auto; width:300px;">
        ID: <input type="number" name="id" min="1" required style="display:block; margin-bottom:10px;"><br/>
        Nombre: <input type="text" name="nombre" pattern="[A-Za-z\sñÑáéíóúÁÉÍÓÚ]+" required style="display:block; margin-bottom:10px;"><br/>
        Peso (grs): <input type="number" name="peso" min="1" required style="display:block; margin-bottom:10px;"><br/>
        Fecha de Nacimiento: <input type="date" name="fechaNacimiento" required style="display:block; margin-bottom:10px;"><br/>
        Prematuro: 
        <input type="radio" name="prematuro" value="Si" required> Sí
        <input type="radio" name="prematuro" value="No" required> No<br/>
        Sexo: 
        <input type="radio" name="sexo" value="M" required> Masculino
        <input type="radio" name="sexo" value="F" required> Femenino<br/>
        Centro: 
        <select name="centro" required style="display:block; margin-bottom:10px;">
            <option value="">--Seleccione--</option>
            <option value="Centro1">Centro 1</option>
            <option value="Centro2">Centro 2</option>
            <option value="Centro3">Centro 3</option>
            <!-- Agrega más centros según sea necesario -->
        </select><br/>
        <input type="submit" value="Registrar" style="display:block; margin-top:10px;">
    </form>
    <br>
    <a href="listado.jsp" style="display:block; text-align:center;">Ver Listado de Nacimientos</a>
</body>
</html>
