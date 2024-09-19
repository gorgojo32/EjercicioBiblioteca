/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jpber
 */
public class Prestamo {
        Libro libro;
    Usuario usuario;
    Date fechaInicio;
    Date fechaDevolucion;
    String estado;

    public Prestamo(Libro libro, Usuario usuario, Date fechaInicio, Date fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = "pendiente";
    }

    
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Prestamo{" +
                "libro=" + libro.titulo +
                ", usuario=" + usuario.nombre +
                ", fechaInicio=" + sdf.format(fechaInicio) +
                ", fechaDevolucion=" + sdf.format(fechaDevolucion) +
                ", estado='" + estado + '\'' +
                '}';
    }
}
