// PACKAGE: Define el espacio de nombres (namespace) y la ruta de carpetas donde reside esta clase.
// Evita colisiones de nombres con otras clases del proyecto y organiza modularmente el código.
package CursoJava.ArreglosDeObjetos;

// CLASE PRINCIPAL: Contiene el punto de entrada de la aplicación.
class GestorDeProductos {

    // MÉTODO MAIN: Punto de entrada (entry point) donde la JVM inicia la ejecución del programa.
    public static void main(String[] args) {
        
        // Instanciación del gestor/contenedor que manejará la colección de productos en memoria.
        ManejoDeStock stock = new ManejoDeStock();

        // Creación de instancias independientes de la clase Producto usando el constructor parametrizado.
        // Cada objeto ocupa un espacio único en memoria con sus propios valores de atributos.
        Producto producto1 = new Producto("Producto 1", 10.99, 100);
        Producto producto2 = new Producto("Producto 2", 5.49, 50);
        Producto producto3 = new Producto("Producto 3", 15.75, 75);

        // Inserción de referencias de objetos en posiciones específicas del arreglo interno.
        stock.agregarProducto(producto1, 0);
        stock.agregarProducto(producto2, 1);
        stock.agregarProducto(producto3, 2);

        System.out.println("Lista de productos:");
        // Al pasar el objeto 'stock' a println, Java invoca implícitamente su método .toString().
        System.out.println(stock);

    }
    
}

// CLASE DE SERVICIO / GESTIÓN: Administra el ciclo de vida y la colección de productos.
class ManejoDeStock {

    // ENCAPSULAMIENTO: El arreglo se declara 'private' para que no pueda ser alterado
    // directamente desde fuera de la clase, obligando a usar los métodos provistos.
    private Producto [] productos;

    // CONSTRUCTOR: Inicializa el estado del objeto. Aquí reserva memoria para el arreglo.
    public ManejoDeStock() { 
        this.productos = new Producto[1];
    }

    // Método mutador para asociar un producto a un índice específico del arreglo.
    public void agregarProducto(Producto product, int indice) {
        this.productos[indice] = product;
    }

    // Borrado lógico: Al asignar 'null', se rompe la referencia al objeto en esa posición,
    // permitiendo que el Garbage Collector (recolector de basura) libere esa memoria si ya no se usa.
    public void eliminarProducto(int indice) {
        this.productos[indice] = null;
    }

    // @OVERRIDE: Anotación que indica que se está sobrescribiendo un método de la clase padre
    // (en este caso, toString() heredado de java.lang.Object).
    // Ayuda al compilador a verificar la firma exacta del método y previene errores tipográficos.
    @Override
    public String toString() {
        String salida = "";
        // Bucle for-each: Recorre cómodamente cada referencia en el arreglo.
        for (Producto producto : productos) {
            // Control de nulidad: Evita un NullPointerException al manipular posiciones vacías.
            if(producto != null) {
                // Concatena la representación en texto de cada producto delegando en su propio toString().
                salida += producto + "\n";
            }
        }
        return salida;
    }

    // Método utilitario para imprimir directamente en la consola estándar la lista de productos.
    public void listarProducto() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

}

// CLASE DE DOMINIO / MODELO: Representa la entidad 'Producto'.
class Producto {
    // ATRIBUTOS PRIVADOS: Principio de ocultamiento de información (Encapsulamiento).
    private String nombre;
    private double precio;
    private int stock;

    // CONSTRUCTOR SOBRECARGADO: Asigna el estado inicial al instanciar el objeto.
    // 'this' resuelve la ambigüedad entre los parámetros y las variables de instancia.
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // @OVERRIDE: Sobrescritura de java.lang.Object.toString().
    // Por defecto devolvería algo como "Producto@1b6d3586" (nombreClase + hash);
    // al sobrescribirlo, devolvemos una representación textual amigable y legible para humanos.
    @Override
    public String toString() {
        return stock + " " + nombre + " $" + precio;        
    }
}
