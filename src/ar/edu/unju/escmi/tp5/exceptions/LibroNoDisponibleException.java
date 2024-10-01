package ar.edu.unju.escmi.tp5.exceptions;

public class LibroNoDisponibleException extends Exception {

	private static final long serialVersionUID = -7722206103632849864L;

	public LibroNoDisponibleException(String message) {
        super(message);
    }
}