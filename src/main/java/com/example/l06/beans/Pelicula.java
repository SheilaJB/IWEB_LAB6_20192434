package com.example.l06.beans;

public class Pelicula {

    private  int idPelicula;
    private String titulo;
    private  String director;
    private  int anoPublicado;
    private  double rating;
    private  double boxOffice;
    private String idGenero;
    private  Genero  genero;


    public int getIdPelicula() {
        return idPelicula;
    }
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public int getAnoPublicado() {
        return anoPublicado;
    }
    public void setAnoPublicado(int anoPublicado) {
        this.anoPublicado = anoPublicado;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public double getBoxOffice() {
        return boxOffice;
    }
    public void setBoxOffice(double boxOffice) {
        this.boxOffice = boxOffice;
    }
    public String getIdGenero() {
        return idGenero;
    }
    public void setIdGenero(String idGenero) {
        this.idGenero = idGenero;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
