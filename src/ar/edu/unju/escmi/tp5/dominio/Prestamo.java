package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;

public class Prestamo {
    private int id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Libro libro;
    private Usuario usuario;
    
    public Prestamo(int id, LocalDate fechaPrestamo, Libro libro, Usuario usuario) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaDevolucion = null; // Inicialmente no se ha devuelto
    }
    
    public void registrarDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        this.libro.setEstado(true); // El libro esta disponible nuevamente
    }
    
    public void mostrarDatos() {
        System.out.println("Préstamo ID: " + id);
        System.out.println("Fecha Préstamo: " + fechaPrestamo);
        System.out.println("Fecha Devolución: " + (fechaDevolucion != null ? fechaDevolucion : "No devuelto"));
        libro.mostrarDatos();
        usuario.mostrarDatos();
    }
}
