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
    ArrayList<Pelicula> pelicula = (ArrayList<Pelicula>) request.getAttribute("lista");
    if (pelicula == null) {
        pelicula = new ArrayList<>();
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Más información</title>
    <link rel="stylesheet" href="../css/styles_view.css">
</head>
<body>
<div class="container">
    <% for (Pelicula pelicula1: pelicula){ %>
    <h1><%= pelicula1.getTitulo() %></h1>

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
            <td id="idPelicula"><%= pelicula1.getIdPelicula() %></td>
            <td id="Director"><%= pelicula1.getDirector() %></td>
            <td id="Año de Publicación"><%= pelicula1.getAnoPublicado() %></td>
            <td id="Rating"><%= pelicula1.getRating() %>/10</td>
            <td id="Box Office">$<%= pelicula1.getBoxOffice() %></td>
            <td id="Género"><%= pelicula1.getGenero().getNombre() %></td>
            <td id="Actores"><a href="listaActores.jsp">Ver Actores</a></td>
        </tr>
        </tbody>
    </table>
    <% }%>
</div>
</body>
</html>
