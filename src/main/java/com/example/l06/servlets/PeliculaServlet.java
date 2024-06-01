package com.example.l06.servlets;

import com.example.l06.beans.Pelicula;
import com.example.l06.daos.ListaPeliculasDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

@WebServlet(name = "PeliculaServlet", value = "/PeliculaServlet")

public class PeliculaServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ListaPeliculasDaos listaPeliculasDaos = new ListaPeliculasDaos();
        ArrayList<Pelicula> listaPeliculas = listaPeliculasDaos.obtenerListaPeliculas();

        // Ordenar las películas por rating y luego por box office
        listaPeliculas.sort(Comparator.comparingDouble(Pelicula::getRating).reversed().thenComparingDouble(Pelicula::getBoxOffice).reversed());
        request.setAttribute("lista", listaPeliculas);
        RequestDispatcher view = request.getRequestDispatcher("listaPeliculas.jsp");
        view.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

        String titulo = request.getParameter("titulo");
        ListaPeliculasDaos listaPeliculasDaos = new ListaPeliculasDaos();
        ArrayList<Pelicula> listaPeliculas;

        if (titulo != null && !titulo.isEmpty()) {
            listaPeliculas = listaPeliculasDaos.buscarPeliculasPorTitulo(titulo);
        } else {
            listaPeliculas = listaPeliculasDaos.obtenerListaPeliculas();
        }

        // Ordenar las películas por rating y luego por box office
        listaPeliculas.sort(Comparator.comparingDouble(Pelicula::getRating).reversed()
                .thenComparingDouble(Pelicula::getBoxOffice).reversed());

        request.setAttribute("lista", listaPeliculas);
        request.setAttribute("titulo", titulo);
        RequestDispatcher view = request.getRequestDispatcher("listaPeliculas.jsp");
        view.forward(request, response);
    }


}
