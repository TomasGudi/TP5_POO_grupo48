package ar.edu.unju.escmi.tp5.dominio;

public abstract class Usuario {
    private int id;
    protected String nombre;
    protected String apellido;
    protected String email;
    
    public Usuario(int id, String nombre, String apellido, String email) {
        this.setId(id);
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }
    
    public abstract void mostrarDatos();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
