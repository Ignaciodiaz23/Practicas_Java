public class PerfilDesarrollador {
   public static void main(String[] args) {
if (args.length >= 2) {
    String nombre = args[0];
    String lenguaje = args[1];
    System.out.println("===============================");
    System.out.println("Nombre del desarrollador: " + nombre);
    System.out.println("Especialidad" + lenguaje);
    System.out.println("===============================");
} else {
    System.out.println("Uso: java PerfilDesarrollador <TuNombre> <TuLenguaje>");

}

   }
}
