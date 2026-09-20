/**
 * Representa a un usuario del sistema con sus datos de identificación.
 * Aplica el principio de encapsulamiento protegiendo sus atributos.
 */
public class Usuario {
    // Encapsulamiento: atributos privados accesibles solo a través de getters
    private String nombre;
    private int idUsuario;
// Constructor: 'this' diferencia el atributo de instancia del parámetro recibido
    public Usuario(String nombre, int idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }
// Métodos de acceso (Getters): proveen lectura controlada de los atributos privado
    public String getNombre() {
        return nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void mostrarInfo() {
        System.out.println("Nombre del usuario: " + nombre);
        System.out.println("ID del usuario: " + idUsuario);
    }
    
}
