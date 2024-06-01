package com.example.l06.daos;

import com.example.l06.beans.Genero;
import com.example.l06.beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class ListaPeliculasDaos {
    public ArrayList<Pelicula> obtenerListaPeliculas(){
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
    public ArrayList<Pelicula> buscarPeliculasPorTitulo(String titulo) {
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre AS genero " +
                "FROM pelicula p " +
                "JOIN genero g ON p.idGenero = g.idGenero " +
                "WHERE p.titulo LIKE ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + titulo + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Genero generoPelicula = new Genero();
                Pelicula pelicula = new Pelicula();

                // Valores de las columnas de la tabla Película
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPeliculas;
    }

    public Pelicula buscarIdPelicula(int idPelicula) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre " +
                "FROM pelicula p " +
                "JOIN genero g ON p.idGenero = g.idGenero " +
                "WHERE p.idPelicula = ?";

        Pelicula pelicula = null;

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPelicula);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pelicula = new Pelicula();
                Genero generoPelicula = new Genero();
                pelicula.setIdPelicula(rs.getInt("idPelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setAnoPublicado(rs.getInt("anoPublicacion"));
                pelicula.setRating(rs.getDouble("rating"));
                pelicula.setBoxOffice(rs.getInt("boxOffice"));
                generoPelicula.setNombre(rs.getString("nombre"));
                pelicula.setGenero(generoPelicula);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pelicula;
    }
}
