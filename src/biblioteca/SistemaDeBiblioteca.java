/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author jpber
 */
public class SistemaDeBiblioteca {
    private static Scanner scanner = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Sistema de Gestión de Biblioteca ---");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Agregar libro");
            System.out.println("3. Realizar préstamo");
            System.out.println("4. Mostrar estadísticas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarUsuario();
                    break;
                case 2:
                    agregarLibro();
                    break;
                case 3:
                    realizarPrestamo();
                    break;
                case 4:
                    biblioteca.mostrarEstadisticas();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        System.out.println("Gracias por usar el Sistema de Gestión de Biblioteca.");
    }

    private static void agregarUsuario() {
        System.out.print("Nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del usuario: ");
        String id = scanner.nextLine();
        System.out.print("Tipo de usuario (lector/bibliotecario): ");
        String tipoUsuario = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correoElectronico = scanner.nextLine();

        Usuario usuario = new Usuario(nombre, id, tipoUsuario, correoElectronico);
        biblioteca.agregarUsuario(usuario);
        System.out.println("Usuario agregado con éxito.");
    }

    private static void agregarLibro() {
        System.out.print("Título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Número de copias: ");
        int copias = scanner.nextInt();
        scanner.nextLine(); 

        Libro libro = new Libro(titulo, autor, isbn, genero, copias);
        biblioteca.agregarLibro(libro);
        System.out.println("Libro agregado con éxito.");
    }

    private static void realizarPrestamo() {
        if (biblioteca.libros.isEmpty() || biblioteca.usuarios.isEmpty()) {
            System.out.println("No hay libros o usuarios registrados para realizar préstamos.");
            return;
        }

        System.out.println("Libros disponibles:");
        for (int i = 0; i < biblioteca.libros.size(); i++) {
            System.out.println(i + ": " + biblioteca.libros.get(i).titulo);
        }
        System.out.print("Seleccione el número del libro: ");
        int libroIndex = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Usuarios registrados:");
        for (int i = 0; i < biblioteca.usuarios.size(); i++) {
            System.out.println(i + ": " + biblioteca.usuarios.get(i).nombre);
        }
        System.out.print("Seleccione el número del usuario: ");
        int usuarioIndex = scanner.nextInt();
        scanner.nextLine(); 

        Date fechaInicio = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.DAY_OF_MONTH, 14); 
        Date fechaDevolucion = calendar.getTime();

        biblioteca.realizarPrestamo(
            biblioteca.libros.get(libroIndex),
            biblioteca.usuarios.get(usuarioIndex),
            fechaInicio,
            fechaDevolucion
        );
        System.out.println("Préstamo realizado con éxito.");
    }
}
