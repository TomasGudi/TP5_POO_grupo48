package ar.edu.unju.escmi.tp5.dominio;

public class Alumno extends Usuario {
    private String curso;
    private int numeroLibreta;
    
    public Alumno(int id, String nombre, String apellido, String email, String curso, int numeroLibreta) {
        super(id, nombre, apellido, email);
        this.curso = curso;
        this.numeroLibreta = numeroLibreta;
    }
    
    @Override
    public void mostrarDatos() {
        System.out.println("Alumno [ID: " + getId() + ", Nombre: " + nombre + " " + apellido + ", Email: " + email + ", Curso: " + curso + ", Número Libreta: " + numeroLibreta + "]");
    }
}
