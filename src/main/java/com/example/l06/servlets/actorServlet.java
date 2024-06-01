package com.example.l06.servlets;
import com.example.l06.beans.Actor;
import com.example.l06.daos.ActoresDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet(name = "ActorServlet", value = "/ActorServlet")
public class actorServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
        ActoresDaos actoresDaos = new ActoresDaos();

        // Obtener la lista de actores para la película con el idPelicula
        ArrayList<Actor> listaActores = actoresDaos.list(idPelicula);
        //
        request.setAttribute("listaActores", listaActores);
        //
        String tituloPelicula = request.getParameter("tituloPelicula");
        //
        request.setAttribute("tituloPelicula", tituloPelicula);

        // Redireccionar a listaActores.jsp
        RequestDispatcher view = request.getRequestDispatcher("listaActores.jsp");
        view.forward(request, response);
    }
}
