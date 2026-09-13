import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionBiblioteca biblioteca = new GestionBiblioteca();
        Scanner scanner = new Scanner(System.in);

        // Cargamos algunos libros iniciales
        biblioteca.agregarLibro(new Libro("El Aleph", "Jorge Luis Borges", "101"));
        biblioteca.agregarLibro(new Libro("Ficciones", "Jorge Luis Borges", "102"));
        biblioteca.agregarLibro(new Libro("Rayuela", "Julio Cortázar", "103"));

        int opcion = 0;

        do {
            System.out.println("\n=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Mostrar catálogo");
            System.out.println("2. Prestar libro por ISBN");
            System.out.println("3. Devolver libro por ISBN");
            System.out.println("4. Salir");
            System.out.print("Seleccioná una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    biblioteca.mostrarCatalogo();
                    break;

                case 2:
                    System.out.print("Ingresá el ISBN del libro a prestar: ");
                    String isbnPrestar = scanner.nextLine();
                    Libro libroAPrestar = biblioteca.buscarPorIsbn(isbnPrestar);

                    if (libroAPrestar != null) {
                        if (libroAPrestar.prestar()) {
                            System.out.println("¡Libro '" + libroAPrestar.getTitulo() + "' prestado con éxito!");
                        } else {
                            System.out.println("El libro ya se encuentra prestado.");
                        }
                    } else {
                        System.out.println("No se encontró ningún libro con ese ISBN.");
                    }
                    break;

                case 3:
                    System.out.print("Ingresá el ISBN del libro a devolver: ");
                    String isbnDevolver = scanner.nextLine();
                    Libro libroADevolver = biblioteca.buscarPorIsbn(isbnDevolver);

                    if (libroADevolver != null) {
                        libroADevolver.devolver();
                        System.out.println("¡Libro '" + libroADevolver.getTitulo() + "' devuelto con éxito!");
                    } else {
                        System.out.println("No se encontró ningún libro con ese ISBN.");
                    }
                    break;

                case 4:
                    System.out.println("¡Gracias por usar el sistema de biblioteca!");
                    break;

                default:
                    System.out.println("Opción no válida. Intentalo de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}