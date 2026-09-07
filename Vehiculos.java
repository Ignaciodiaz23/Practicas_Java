import java.util.Scanner;
public class Vehiculos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos vehículos querés cargar? (Máximo 10): ");
        int cantidad = scanner.nextInt();
        
        if (cantidad > 10) {
            System.out.println("El tamaño máximo permitido es 10. Se establecerá en 10.");
            cantidad = 10;
        } else if (cantidad <= 0) {
            System.out.println("Cantidad no válida. Se establecerá en 1 vehículo por defecto.");
            cantidad = 1;
        }

        Vehiculo[] listaDeVehiculos = new Vehiculo[cantidad];
        int opcion = 0;
        int contadorCargados = 0;
        do {
            System.out.println("\n menu de gestion de vehiculos");
            System.out.println("1. Cargar un nuevo vehículo");
            System.out.println("2. Mostrar todos los vehículos cargados");
            System.out.println("3. Salir");
            System.out.print("Seleccioná una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:

                    if (contadorCargados < listaDeVehiculos.length) {
                        System.out.println("\n--- Carga del vehículo " + (contadorCargados + 1) + " ");
                        System.out.println("¿Qué vehículo vas a cargar?");
                        System.out.println("1. Auto");
                        System.out.println("2. Moto");
                        System.out.print("Opción: ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();

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

                            listaDeVehiculos[contadorCargados] = new Auto(marca, modelo, anio, precio, impuestoRueda);
                            System.out.println("Auto registrado con éxito");

                        } else if (tipo == 2) {
                            // Guardamos una Moto en el arreglo de Vehiculos
                            listaDeVehiculos[contadorCargados] = new Moto(marca, modelo, anio, precio);
                            System.out.println("Moto registrada con éxito");

                        } else {
                            System.out.println("Tipo de vehículo no válido. Registro cancelado.");
                            contadorCargados--;
                        }

                        contadorCargados++;

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
                            // Java invoca automáticamente el toString() correspondiente de Auto o Moto
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

        } while (opcion != 3);

        scanner.close(); // Buena práctica: cerrar el objeto Scanner
    }
}

/* ==========================================================================
   ESTRUCTURA DE CLASES BASE (Modelos)
   ========================================================================== */

class Vehiculo {
    private String marca;
    private String modelo;
    private int puertas;
    private int anio;
    private double precio;
    private int cantidadRuedas;
    private double impuestoPorRueda;

    public Vehiculo(String marca, String modelo, int anio, int puertas, double precio, double impuestoPorRueda) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.puertas = puertas;
        this.precio = precio;
        this.impuestoPorRueda = impuestoPorRueda;
    }

    public Vehiculo(String marca, String modelo, int anio, int puertas, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.puertas = puertas;
        this.precio = precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setImpuestoPorRueda(double impuestoPorRueda) {
        this.impuestoPorRueda = impuestoPorRueda;
    }

    public double getImpuestoCantRuedas() {
        this.impuestoPorRueda = ((impuestoPorRueda * this.cantidadRuedas) * this.precio) / 100;
        return impuestoPorRueda;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setCantidadRuedas(int cantidadRuedas) {
        this.cantidadRuedas = cantidadRuedas;
    }

    public double getPrecioImpuesto() {
        return this.precio + this.impuestoPorRueda;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + ", " + anio + ", " + puertas + " Puertas, U$s " + this.getPrecioImpuesto();
    }

    public String getDatosBasicos() {
        return marca + " " + modelo + ", " + anio;
    }
}

class Moto extends Vehiculo {

    public Moto(String marca, String modelo, int anio, double precio) {
        super(marca, modelo, anio, 0, precio, 0);
        super.setCantidadRuedas(2);
    }

    @Override
    public String toString() {
        return "[Moto] " + super.getDatosBasicos() + ", U$s " + this.getPrecioImpuesto();
    }
}

class Auto extends Vehiculo {

    public Auto(String marca, String modelo, int anio, double precio, double impuestoPorRueda) {
        super(marca, modelo, anio, 4, precio, impuestoPorRueda);
    }

    @Override
    public String toString() {
        return "[Auto] " + super.toString();
    }
}