import java.util.ArrayList;
/**
 * Representa una cabina de peaje encargada del cobro y registro de vehículos.
 */
public class CabinaPeaje {
    // Encapsulamiento: atributos privados protegidos del acceso externo directo
    private double totalRecaudado;
    private ArrayList<Vehiculo> listaVehiculos;
// Constructor: inicializa el estado de la instancia reservando la memoria para la lista
    public CabinaPeaje() {
        this.totalRecaudado = 0;
        this.listaVehiculos = new ArrayList<>();
    }
// Polimorfismo: el método recibe un tipo genérico 'Vehiculo' (clase base),
    // pero en tiempo de ejecución se ejecutará el comportamiento específico 
    // del método calcularPeaje() según la subclase real (Auto, Moto o Camion).
    public void cobrarPeaje(Vehiculo vehiculo) {
        double costo = vehiculo.calcularPeaje();
        totalRecaudado += costo;
        listaVehiculos.add(vehiculo);
        
        System.out.println("Vehículo registrado -> Patente: " + vehiculo.getPatente() + " | Cobrado: $" + costo);
    }
// 'public': Modificador de acceso que permite invocar el método desde cualquier otra clase.
    // 'void': Tipo de retorno que indica que el método ejecuta acciones pero no devuelve ningún valor.
    public void mostrarReporte() {
        System.out.println("\n=== REPORTE DE CABINA DE PEAJE ===");
        System.out.println("Vehículos procesados: " + listaVehiculos.size());
        System.out.println("Total recaudado: $" + totalRecaudado);
    }
}
