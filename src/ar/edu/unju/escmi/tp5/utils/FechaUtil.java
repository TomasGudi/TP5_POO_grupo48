package ar.edu.unju.escmi.tp5.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FechaUtil {

    //metodo para pasar de string a formato dd/MM/yyyy
    public static LocalDate convertirStringLocalDate(String fechaStr) throws IllegalArgumentException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        try {
            return LocalDate.parse(fechaStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Fecha en formato inválido. Debe ser dd/MM/yyyy.", e);
        }
    }
}