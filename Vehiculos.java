import java.util.Scanner;

/**
 * Clase principal: controla la interacción con el usuario mediante la consola.
 */
public class Vehiculos {

    // Método main: punto de entrada del programa.
    // 'public': accesible por la JVM desde cualquier lugar.
    // 'static': pertenece a la clase, no requiere crear un objeto Vehiculos para ejecutarse.
    // 'void': no devuelve ningún valor.
    // 'String[] args': arreglo para recibir argumentos desde la terminal.
    public static void main(String[] args) {
        // Instanciación de Scanner para leer la entrada estándar del teclado
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos vehículos querés cargar? (Máximo 10): ");
        int cantidad = scanner.nextInt();
        
        // Validación de rango para el tamaño del arreglo
        if (cantidad > 10) {
            System.out.println("El tamaño máximo permitido es 10. Se establecerá en 10.");
            cantidad = 10;
        } else if (cantidad <= 0) {
            System.out.println("Cantidad no válida. Se establecerá en 1 vehículo por defecto.");
            cantidad = 1;
        }

        // Estructura de datos: arreglo de tipo Vehiculo (tipo base/superclase)
        Vehiculo[] listaDeVehiculos = new Vehiculo[cantidad];
        int opcion = 0;
        int contadorCargados = 0; // Lleva el control de posiciones ocupadas en el arreglo

        // Bucle do-while: garantiza que el menú se ejecute al menos una vez
        do {
            System.out.println("\n menu de gestion de vehiculos");
            System.out.println("1. Cargar un nuevo vehículo");
            System.out.println("2. Mostrar todos los vehículos cargados");
            System.out.println("3. Salir");
            System.out.print("Seleccioná una opción: ");
            opcion = scanner.nextInt();

            // Estructura de control condicional múltiple para evaluar la opción elegida
            switch (opcion) {
                case 1:

                    // Verifica que el arreglo aún tenga espacio disponible
                    if (contadorCargados < listaDeVehiculos.length) {
                        System.out.println("\n--- Carga del vehículo " + (contadorCargados + 1) + " ");
                        System.out.println("¿Qué vehículo vas a cargar?");
                        System.out.println("1. Auto");
                        System.out.println("2. Moto");
                        System.out.print("Opción: ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine(); // Limpieza del buffer de entrada

                        System.out.print("Marca: ");
                        String marca = scanner.nextLine();

                        System.out.print("Modelo: ");
                        String modelo = scanner.nextLine();

                        System.out.print("Año: ");
                        int anio = scanner.nextInt();

                        System.out.print("Precio usd: ");
                        double precio = scanner.nextDouble();

                        if (tipo == 1) {

                            System.out.print("Impuesto por rueda usd: ");
                            double impuestoRueda = scanner.nextDouble();

                            // Polimorfismo: se guarda una instancia de la subclase Auto
                            // en una posición del arreglo de tipo Vehiculo
                            listaDeVehiculos[contadorCargados] = new Auto(marca, modelo, anio, precio, impuestoRueda);
                            System.out.println("Auto registrado con éxito");

                        } else if (tipo == 2) {
                            // Polimorfismo: Guardamos una Moto en el arreglo de Vehiculos
                            listaDeVehiculos[contadorCargados] = new Moto(marca, modelo, anio, precio);
                            System.out.println("Moto registrada con éxito");

                        } else {
                            System.out.println("Tipo de vehículo no válido. Registro cancelado.");
                            contadorCargados--; // Compensa el incremento posterior si hubo error
                        }

                        contadorCargados++; // Avanza a la siguiente posición del arreglo

                    } else {
                        System.out.println("¡está lleno! No podés cargar más vehículos.");
                    }
                    break;

                case 2:
                
                    System.out.println("\n===== LISTA DE VEHÍCULOS REGISTRADOS =====");
                    if (contadorCargados == 0) {
                        System.out.println("Aún no se han registrado vehículos.");
                    } else {
                        for (int i = 0; i < contadorCargados; i++) {
                            // Polimorfismo en ejecución: Java invoca automáticamente el toString() 
                            // específico implementado en Auto o Moto según el objeto real almacenado
                            System.out.println((i + 1) + ". " + listaDeVehiculos[i]);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intentá de nuevo.");
            }

        } while (opcion != 3); // Condición de salida del bucle

        scanner.close(); // Buena práctica: cerrar el objeto Scanner para liberar recursos
    }
}

/* ==========================================================================
   ESTRUCTURA DE CLASES BASE (Modelos)
   ========================================================================== */

/**
 * Superclase (clase padre): define los atributos y comportamientos comunes
 * que compartirán todas las variantes de vehículos.
 */
class Vehiculo {
    // Encapsulamiento: atributos privados accesibles solo dentro de esta clase
    private String marca;
    private String modelo;
    private int puertas;
    private int anio;
    private double precio;
    private int cantidadRuedas;
    private double impuestoPorRueda;

    // Sobrecarga de constructores (Constructor 1): recibe todos los datos incluyendo impuesto
    public Vehiculo(String marca, String modelo, int anio, int puertas, double precio, double impuestoPorRueda) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.puertas = puertas;
        this.precio = precio;
        this.impuestoPorRueda = impuestoPorRueda;
    }

    // Sobrecarga de constructores (Constructor 2): versión alternativa sin impuesto inicial
    public Vehiculo(String marca, String modelo, int anio, int puertas, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.puertas = puertas;
        this.precio = precio;
    }

    // Método setter: modifica el valor del atributo privado precio
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método setter: modifica el valor del impuesto por rueda
    public void setImpuestoPorRueda(double impuestoPorRueda) {
        this.impuestoPorRueda = impuestoPorRueda;
    }

    // Método para calcular el impuesto en función de ruedas y precio base
    public double getImpuestoCantRuedas() {
        this.impuestoPorRueda = ((impuestoPorRueda * this.cantidadRuedas) * this.precio) / 100;
        return impuestoPorRueda;
    }

    // Método getter: retorna el valor del atributo precio
    public double getPrecio() {
        return this.precio;
    }

    // Método setter: asigna la cantidad de ruedas del vehículo
    public void setCantidadRuedas(int cantidadRuedas) {
        this.cantidadRuedas = cantidadRuedas;
    }

    // Retorna la suma del precio base más el impuesto por rueda
    public double getPrecioImpuesto() {
        return this.precio + this.impuestoPorRueda;
    }

    // Sobrescribe el método toString() heredado de java.lang.Object
    @Override
    public String toString() {
        return marca + " " + modelo + ", " + anio + ", " + puertas + " Puertas, U$s " + this.getPrecioImpuesto();
    }

    // Método auxiliar para devolver únicamente los datos de identificación
    public String getDatosBasicos() {
        return marca + " " + modelo + ", " + anio;
    }
}

/**
 * Subclase Moto: hereda atributos y métodos de la clase Vehiculo ('extends').
 */
class Moto extends Vehiculo {

    // Constructor de la subclase
    public Moto(String marca, String modelo, int anio, double precio) {
        // 'super(...)': invoca al constructor de la clase padre (Vehiculo),
        // fijando 0 puertas e impuesto inicial en 0
        super(marca, modelo, anio, 0, precio, 0);
        super.setCantidadRuedas(2); // Define 2 ruedas mediante el método de la superclase
    }

    // Sobrescritura (@Override): redefine cómo se muestra en texto una Moto
    @Override
    public String toString() {
        return "[Moto] " + super.getDatosBasicos() + ", U$s " + this.getPrecioImpuesto();
    }
}

/**
 * Subclase Auto: hereda atributos y métodos de la clase Vehiculo ('extends').
 */
class Auto extends Vehiculo {

    // Constructor de la subclase
    public Auto(String marca, String modelo, int anio, double precio, double impuestoPorRueda) {
        // 'super(...)': invoca al constructor de Vehiculo fijando 4 puertas por defecto
        super(marca, modelo, anio, 4, precio, impuestoPorRueda);
    }

    // Sobrescritura (@Override): añade la etiqueta '[Auto]' al toString() original del padre
    @Override
    public String toString() {
        return "[Auto] " + super.toString();
    }
}
