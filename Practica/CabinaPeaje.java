import java.util.ArrayList;

public class CabinaPeaje {
    private double totalRecaudado;
    private ArrayList<Vehiculo> listaVehiculos;

    public CabinaPeaje() {
        this.totalRecaudado = 0;
        this.listaVehiculos = new ArrayList<>();
    }

    public void cobrarPeaje(Vehiculo vehiculo) {
        double costo = vehiculo.calcularPeaje();
        totalRecaudado += costo;
        listaVehiculos.add(vehiculo);
        
        System.out.println("Vehículo registrado -> Patente: " + vehiculo.getPatente() + " | Cobrado: $" + costo);
    }

    public void mostrarReporte() {
        System.out.println("\n=== REPORTE DE CABINA DE PEAJE ===");
        System.out.println("Vehículos procesados: " + listaVehiculos.size());
        System.out.println("Total recaudado: $" + totalRecaudado);
    }
}