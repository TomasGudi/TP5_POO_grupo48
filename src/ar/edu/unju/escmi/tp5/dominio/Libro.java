package ar.edu.unju.escmi.tp5.dominio;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private boolean estado;
    
    public Libro(int id, String titulo, String autor, String isbn, boolean estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.estado = estado;
    }
    
    public void mostrarDatos() {
        System.out.println("ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + ", Estado: " + (estado ? "Disponible" : "No Disponible"));
    }
    
    public boolean isDisponible() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }
}
