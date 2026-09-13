public class Usuario {
    private String nombre;
    private int idUsuario;

    public Usuario(String nombre, int idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }

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
