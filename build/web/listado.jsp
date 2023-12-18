<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Modelo.Nacimiento"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Nacimientos</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 5px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <h1>Listado de Nacimientos</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Peso</th>
                <th>Fecha Nacimiento</th>
                <th>Prematuro</th>
                <th>Sexo</th>
                <th>Centro</th>
                <th>Acción</th>
            </tr>
            <c:forEach items="${listaNacimientos}" var="nacimiento">
                <tr>
                    <td><c:out value="${nacimiento.id}"/></td>
                    <td><c:out value="${nacimiento.nombre}"/></td>
                    <td><c:out value="${nacimiento.peso}"/> grs</td>
                    <td><c:out value="${nacimiento.fechaNacimiento}"/></td>
                    <td><c:out value="${nacimiento.prematuro ? 'Sí' : 'No'}"/></td>
                    <td><c:out value="${nacimiento.descripcionSexo}"/></td>
                    <td><c:out value="${nacimiento.centro}"/></td>
                    <td><a href="EliminarNacimientoServlet?id=${nacimiento.id}">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="registro.jsp">Registrar Nuevo Nacimiento</a>
    </body>
</html>
