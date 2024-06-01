package com.example.l06.daos;

import com.example.l06.beans.Genero;
import com.example.l06.beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class ListaPeliculasDaos {
    public ArrayList<Pelicula> listar(){
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql ="SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre AS genero " +
                "FROM pelicula p " +
                "JOIN genero g ON p.idGenero = g.idGenero;";

        try  (Connection conn = DriverManager.getConnection(url, user, pass)){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            //
            while (rs.next()){

                Genero generoPelicula = new Genero();
                Pelicula pelicula = new Pelicula();

                //Valores de las columnas de la tabla Película
                pelicula.setIdPelicula(rs.getInt("idPelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setAnoPublicado(rs.getInt("anoPublicacion"));
                pelicula.setRating(rs.getDouble("rating"));
                pelicula.setBoxOffice(rs.getDouble("boxOffice"));
                generoPelicula.setNombre(rs.getString("genero"));
                pelicula.setGenero(generoPelicula);

                listaPeliculas.add(pelicula);
            }
        //
        }catch ( SQLException e) {

            throw new RuntimeException(e);
        }
        return  listaPeliculas;
    }
}
