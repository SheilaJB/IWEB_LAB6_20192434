package com.example.l06.daos;
import com.example.l06.beans.Actor;

import java.sql.*;
import java.util.ArrayList;

public class ActoresDaos {
    private static final String username= "root";
    private static final String password = "root";

    public  ArrayList<Actor> list(int idPelicula){
        ArrayList<Actor> listaActores = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/mydb";

        String sql = "SELECT " +
                "    a.idActor, " +
                "    a.Nombre, " +
                "    a.Apellido, " +
                "    a.anoNacimiento as AnoNacimiento, " +
                "    CASE " +
                "        WHEN a.premioOscar = 1 THEN 'TRUE' " +
                "        ELSE 'FALSE' " +
                "    END AS GanoPremioOscar " +
                "FROM " +
                "    actor a " +
                "JOIN " +
                "    protagonistas pa ON a.idActor = pa.idActor " +
                "WHERE " +
                "    pa.idPelicula = ?;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPelicula);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Actor actor = new Actor();
                // Valores de las columnas de la tabla Actores
                actor.setIdActor(rs.getInt("idActor"));
                actor.setNombre(rs.getString("Nombre"));
                actor.setApellido(rs.getString("Apellido"));
                actor.setAnoNacimiento(rs.getInt("AnoNacimiento"));
                actor.setPremioOscar(Boolean.parseBoolean(rs.getString("GanoPremioOscar")));

                listaActores.add(actor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaActores;
    }
}
