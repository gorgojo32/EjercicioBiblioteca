/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {

 List<Usuario> usuarios = new ArrayList<>();
    List<Libro> libros = new ArrayList<>();
    List<Prestamo> prestamos = new ArrayList<>();

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        escribirLog("usuarios.txt", "Nuevo usuario agregado: " + usuario);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        escribirLog("catalogo.txt", "Nuevo libro agregado: " + libro);
    }

    public void realizarPrestamo(Libro libro, Usuario usuario, Date fechaInicio, Date fechaDevolucion) {
        if (libro.disponible && libro.copias > 0) {
            Prestamo prestamo = new Prestamo(libro, usuario, fechaInicio, fechaDevolucion);
            prestamos.add(prestamo);
            libro.copias--;
            libro.disponible = libro.copias > 0;
            escribirLog("prestamos.txt", "Nuevo préstamo realizado: " + prestamo);
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    private void escribirLog(String archivo, String mensaje) {
        try (FileWriter fw = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(new Date() + ": " + mensaje);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de log: " + e.getMessage());
        }
    }

    public void mostrarEstadisticas() {
        System.out.println("\nEstadísticas de la biblioteca:");
        System.out.println("Número de usuarios: " + usuarios.size());
        System.out.println("Número de libros: " + libros.size());
        System.out.println("Número de préstamos: " + prestamos.size());
    }
    
}
