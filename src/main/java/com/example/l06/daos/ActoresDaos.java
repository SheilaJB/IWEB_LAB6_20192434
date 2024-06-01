package com.example.l06.daos;
import com.example.l06.beans.Actor;

import java.sql.*;
import java.util.ArrayList;

public class ActoresDaos {
    private static final String username= "root";
    private static final String password = "root";

    public  ArrayList<Actor> list(){
        ArrayList<Actor> listaActor = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/mydb";

        String sql ="SELECT " +
                "    a.idActor," +
                "    a.Nombre," +
                "    a.Apellido," +
                "    a.anoNacimiento as AnoNacimiento," +
                "    CASE " +
                "        WHEN a.premioOscar = 1 THEN 'TRUE'" +
                "        ELSE 'FLASE'" +
                "    END AS GanoPremioOscar" +
                "FROM " +
                "    actor a" +
                "JOIN " +
                "    protagonistas pa ON a.idActor = pa.idActor" +
                "WHERE " +
                "    pa.idPelicula = idPelicula;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()){

                Actor actor = new Actor();

                //Valores de las columnas de la tabla Actores
                actor.setIdActor(rs.getInt(1));
                actor.setNombre(rs.getString(2));
                actor.setApellido(rs.getString(3));
                actor.setAnoNacimiento(rs.getInt(4));
                actor.setPremioOscar(rs.getBoolean(5));

                listaActor.add(actor);
            }

        } catch (SQLException e) {
        throw new RuntimeException(e);}

        return listaActor;
    }
}
