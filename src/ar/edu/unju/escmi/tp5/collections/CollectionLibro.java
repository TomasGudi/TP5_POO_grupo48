package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Libro;
import java.util.ArrayList;
import java.util.List;

public class CollectionLibro {
    public static List<Libro> libros = new ArrayList<>();

    public static void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public static Libro buscarLibroPorID(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public static List<Libro> listarLibrosDisponibles() {
        List<Libro> disponibles = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }
}