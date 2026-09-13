import java.util.ArrayList;

public class GestionBiblioteca {
    private ArrayList<Libro> listaLibros;

    public GestionBiblioteca() {
        listaLibros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
        System.out.println("Libro '" + libro.getTitulo() + "' agregado a la biblioteca.");
    }

    public void mostrarCatalogo() {
        if (listaLibros.isEmpty()) {
            System.out.println("La biblioteca no tiene libros cargados.");
            return;
        }
        System.out.println("\n--- Catálogo de la Biblioteca ---");
        for (Libro l : listaLibros) {
            l.mostrarInfo();
        }
    }

    public Libro buscarPorIsbn(String isbn) {
        for (Libro l : listaLibros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null; // Si no lo encuentra
    }
}