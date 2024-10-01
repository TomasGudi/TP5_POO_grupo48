package ar.edu.unju.escmi.tp5.dominio;

public class Bibliotecario extends Usuario {
    private int legajo;
    
    public Bibliotecario(int id, String nombre, String apellido, String email, int legajo) {
        super(id, nombre, apellido, email);
        this.legajo = legajo;
    }
    
    @Override
    public void mostrarDatos() {
        System.out.println("Bibliotecario [ID: " + id + ", Nombre: " + nombre + " " + apellido + ", Email: " + email + ", Legajo: " + legajo + "]");
    }
}
