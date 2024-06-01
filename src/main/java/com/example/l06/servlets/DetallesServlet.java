package com.example.l06.servlets;
import com.example.l06.beans.Pelicula;
import com.example.l06.beans.Actor;
import com.example.l06.daos.ListaPeliculasDaos;
import com.example.l06.daos.ActoresDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
@WebServlet(name = "DetallesServlet", value = "/DetallesServlet")
public class DetallesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));

        ListaPeliculasDaos listaPeliculasDaos = new ListaPeliculasDaos();
        ActoresDaos actoresDaos = new ActoresDaos();

        Pelicula pelicula = listaPeliculasDaos.buscarIdPelicula(idPelicula);
        ArrayList<Actor> listaActores = actoresDaos.list(idPelicula);

        request.setAttribute("lista", pelicula);

        request.setAttribute("listaActores", listaActores);

        RequestDispatcher view = request.getRequestDispatcher("viewPelicula.jsp");
        view.forward(request, response);
    }
}
