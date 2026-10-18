package com.lenguaje.de.programcion.III.API.REST.model;

public class Juego {

    private Long id;
    private String titulo;
    private String genero;
    private String plataforma;
    private int anio;

    public Juego(Long id, String titulo, String genero, String plataforma, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.anio = anio;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public String getPlataforma() { return plataforma; }
    public int getAnio() { return anio; }
}