package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Prestamo;
import java.util.ArrayList;
import java.util.List;

public class CollectionPrestamo {
    public static List<Prestamo> prestamos = new ArrayList<>();

    public static void registrarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public static Prestamo buscarPrestamoPorID(int id) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getId() == id) {
                return prestamo;
            }
        }
        return null;
    }
}