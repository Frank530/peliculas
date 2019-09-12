/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DARWIN
 */
public class Pelicula {
    private int id;
    private String nombre;
    private String descripcion;
    private String genero;
    private String director;

    private String tipo;
    private String lenguaje;
    private int duracion;
    private int puntuacion;
    private boolean selected;
    
    
    public Pelicula(){}
    public Pelicula(String nombre, String descripcion, String genero, String director,String tipo,String lenguaje, int duracion, int puntuacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.genero = genero;
        this.director=director;
        this.lenguaje=lenguaje;
        this.tipo=tipo;
        this.duracion=duracion;
        this.puntuacion=puntuacion;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

   

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
    
    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    

    public Pelicula(int id, String nombre, String descripcion, String genero, String director,String tipo,String lenguaje, int duracion, int puntuacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.genero = genero;
        this.director=director;
        this.lenguaje=lenguaje;
        this.tipo=tipo;
        this.duracion=duracion;
        this.puntuacion=puntuacion;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    
    
    
    
}
