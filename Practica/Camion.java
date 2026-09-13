public class Camion extends Vehiculo {
    private int cantidadEjes;

    public Camion(String patente, double tarifaBase, int cantidadEjes) {
        super(patente, tarifaBase);
        this.cantidadEjes = cantidadEjes;
    }

    @Override
    public double calcularPeaje() {
        // Paga la tarifa base + $500 por cada eje
        return getTarifaBase() + (cantidadEjes * 500);
    }
}
