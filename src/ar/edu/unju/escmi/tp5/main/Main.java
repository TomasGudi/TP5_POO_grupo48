package ar.edu.unju.escmi.tp5.main;

import ar.edu.unju.escmi.tp5.dominio.*;
import ar.edu.unju.escmi.tp5.collections.*;
import ar.edu.unju.escmi.tp5.exceptions.*;
import ar.edu.unju.escmi.tp5.utils.FechaUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("MENU:");
            System.out.println("1 - Registrar libro");
            System.out.println("2 - Registrar usuario");
            System.out.println("3 - Préstamo de libro");
            System.out.println("4 - Devolución de libro");
            System.out.println("5 - Listar libros disponibles");
            System.out.println("6 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarLibro(scanner);
                    break;
                case 2:
                    registrarUsuario(scanner);
                    break;
                case 3:
                    prestarLibro(scanner);
                    break;
                case 4:
                    devolverLibro(scanner);
                    break;
                case 5:
                    listarLibrosDisponibles();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
        
        scanner.close();
    }

    private static void registrarLibro(Scanner scanner) {
        System.out.println("Registrar nuevo libro:");
        System.out.print("Título: ");
        String titulo = scanner.next();
        System.out.print("Autor: ");
        String autor = scanner.next();
        System.out.print("ISBN: ");
        String isbn = scanner.next();
        
        Libro libro = new Libro(CollectionLibro.libros.size() + 1, titulo, autor, isbn, true);
        CollectionLibro.agregarLibro(libro);
        System.out.println("Libro registrado con éxito.");
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.println("Registrar nuevo usuario:");
        System.out.print("1 - Alumno\n2 - Bibliotecario\nSeleccione tipo de usuario: ");
        int tipoUsuario = scanner.nextInt();
        
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Apellido: ");
        String apellido = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();
        
        if (tipoUsuario == 1) {
            System.out.print("Curso: ");
            String curso = scanner.next();
            System.out.print("Número de libreta: ");
            int libreta = scanner.nextInt();
            Alumno alumno = new Alumno(CollectionUsuario.usuarios.size() + 1, nombre, apellido, email, curso, libreta);
            CollectionUsuario.agregarUsuario(alumno);
            System.out.println("Alumno registrado con éxito.");
        } else {
            System.out.print("Legajo: ");
            int legajo = scanner.nextInt();
            Bibliotecario bibliotecario = new Bibliotecario(CollectionUsuario.usuarios.size() + 1, nombre, apellido, email, legajo);
            CollectionUsuario.agregarUsuario(bibliotecario);
            System.out.println("Bibliotecario registrado con éxito.");
        }
    }

    private static void prestarLibro(Scanner scanner) {
        System.out.println("Préstamo de libro:");
        System.out.print("ID del libro: ");
        int idLibro = scanner.nextInt();
        
        try {
            Libro libro = CollectionLibro.buscarLibroPorID(idLibro);
            if (libro == null) {
                throw new LibroNoEncontradoException("El libro con ID " + idLibro + " no se encuentra en la biblioteca.");
            }
            if (!libro.isDisponible()) {
                throw new LibroNoDisponibleException("El libro no está disponible para préstamo.");
            }

            System.out.print("ID del usuario: ");
            int idUsuario = scanner.nextInt();
            Usuario usuario = CollectionUsuario.buscarUsuarioPorID(idUsuario);
            
            if (usuario == null) {
                throw new UsuarioNoRegistradoException("El usuario con ID " + idUsuario + " no está registrado.");
            }

            LocalDate fechaPrestamo = LocalDate.now();
            Prestamo prestamo = new Prestamo(CollectionPrestamo.prestamos.size() + 1, fechaPrestamo, libro, usuario);
            CollectionPrestamo.registrarPrestamo(prestamo);
            libro.setEstado(false);  // El libro ahora no está disponible
            System.out.println("Préstamo registrado con éxito.");

        } catch (LibroNoEncontradoException | LibroNoDisponibleException | UsuarioNoRegistradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void devolverLibro(Scanner scanner) {
        System.out.println("Devolución de libro:");
        System.out.print("ID del préstamo: ");
        int idPrestamo = scanner.nextInt();
        Prestamo prestamo = CollectionPrestamo.buscarPrestamoPorID(idPrestamo);

        if (prestamo == null) {
            System.out.println("Préstamo no encontrado.");
            return;
        }
        
        System.out.print("Fecha de devolución (dd/MM/yyyy): ");
        String fechaDevolucionStr = scanner.next();
        LocalDate fechaDevolucion = FechaUtil.convertirStringLocalDate(fechaDevolucionStr);
        
        prestamo.registrarDevolucion(fechaDevolucion);
        System.out.println("Devolución registrada con éxito.");
    }

    private static void listarLibrosDisponibles() {
        List<Libro> disponibles = CollectionLibro.listarLibrosDisponibles();
        for (Libro libro : disponibles) {
            libro.mostrarDatos();
        }
    }
}