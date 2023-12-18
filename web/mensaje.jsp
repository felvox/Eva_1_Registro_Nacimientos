<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensaje</title>
        <style>
            .mensaje {
                padding: 10px;
                color: white;
                background-color: green;
                margin-bottom: 15px;
            }
            .error {
                padding: 10px;
                color: white;
                background-color: red;
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
        <h1>Mensaje del Sistema</h1>
        <c:choose>
            <c:when test="${not empty error}">
                <div class="error">${error}</div>
            </c:when>
            <c:when test="${not empty mensaje}">
                <div class="mensaje">${mensaje}</div>
            </c:when>
            <c:otherwise>
                <div class="mensaje">Sin mensajes para mostrar.</div>
            </c:otherwise>
        </c:choose>
        <a href="listado.jsp">Volver al Listado</a>
    </body>
</html>
