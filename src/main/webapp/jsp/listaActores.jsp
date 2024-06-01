<%--
  Created by IntelliJ IDEA.
  User: sajba
  Date: 30/05/2024
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.l06.beans.Actor" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de actores</title>
    <link rel="stylesheet" href="../css/styles_actor.css">
</head>
<body>
<div class="container">
    <h1>Lista de Películas</h1>

    <table>
        <thead>
        <tr>
            <th>idActor</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Año de Nacimiento</th>
            <th>Ganador Premio Oscar</th>
        </tr>
        </thead>

        <tbody>
        <% for (Actor actor : (ArrayList<Actor>)request.getAttribute("listaActores")) { %>
        <tr>
            <td><%= actor.getIdActor() %></td>
            <td><%= actor.getNombre() %></td>
            <td><%= actor.getApellido() %></td>
            <td><%= actor.getAnoNacimiento() %></td>
            <td><%= actor.isPremioOscar() ? "Sí" : "No" %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
