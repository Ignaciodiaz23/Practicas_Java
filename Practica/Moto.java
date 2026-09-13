public class Moto extends Vehiculo {

    public Moto(String patente, double tarifaBase) {
        super(patente, tarifaBase);
    }

    @Override
    public double calcularPeaje() {
        return getTarifaBase() * 0.5; // Paga la mitad
    }
}