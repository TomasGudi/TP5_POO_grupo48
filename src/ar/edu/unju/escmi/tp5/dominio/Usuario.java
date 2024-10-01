package ar.edu.unju.escmi.tp5.dominio;

public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String apellido;
    protected String email;
    
    public Usuario(int id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }
    
    public abstract void mostrarDatos();
}
