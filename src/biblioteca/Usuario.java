/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author jpber
 */
public class Usuario {
    String nombre;
    String id;
    String tipoUsuario;
    String correoElectronico;

    public Usuario(String nombre, String id, String tipoUsuario, String correoElectronico) {
        this.nombre = nombre;
        this.id = id;
        this.tipoUsuario = tipoUsuario;
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    } 
}
