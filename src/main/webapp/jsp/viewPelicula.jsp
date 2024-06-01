<%--
  Created by IntelliJ IDEA.
  User: sajba
  Date: 30/05/2024
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.l06.beans.Pelicula" %>
<%
    Pelicula pelicula = (Pelicula) request.getAttribute("lista");
    if (pelicula == null) {
        pelicula = new Pelicula();
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Más información</title>
    <link rel="stylesheet" href="css/styles_view.css">
</head>
<body>
<div class="container">

    <h1><%= pelicula.getTitulo() %></h1>

    <table>
        <thead>
        <tr>
            <th>idPelicula</th>
            <th>Director</th>
            <th>Año de Publicación</th>
            <th>Rating</th>
            <th>Box Office</th>
            <th>Género</th>
            <th>Actores</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td id="idPelicula"><%= pelicula.getIdPelicula() %></td>
            <td id="Director"><%= pelicula.getDirector() %></td>
            <td id="Año de Publicación"><%= pelicula.getAnoPublicado() %></td>
            <td id="Rating"><%= pelicula.getRating() %>/10</td>
            <td id="Box Office">$<%= pelicula.getBoxOffice() %></td>
            <td id="Género"><%= pelicula.getGenero().getNombre() %></td>
            <td id="Actores"><a href="listaActores.jsp">Ver Actores</a></td>
        </tr>
        </tbody>
    </table>

</div>
</body>
</html>
