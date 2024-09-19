/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author jpber
 */
public class Libro {
     String titulo;
    String autor;
    String isbn;
    String genero;
    int copias;
    boolean disponible;

    public Libro(String titulo, String autor, String isbn, String genero, int copias) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
        this.copias = copias;
        this.disponible = copias > 0;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genero='" + genero + '\'' +
                ", copias=" + copias +
                ", disponible=" + disponible +
                '}';
    }
}
