public class Vehiculo {
    private String patente;
    private double tarifaBase;

    public Vehiculo(String patente, double tarifaBase) {
        this.patente = patente;
        this.tarifaBase = tarifaBase;
    }

    public String getPatente() {
        return patente;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    //Este metodo lo van a sobreescribir o usar las subclases
    public double calcularPeaje() {
        return tarifaBase;
    }
    
    public void mostrarDatos() {
        System.out.println("Patente: " + patente);
        System.out.println("Tarifa Base: " + tarifaBase);
    }
}
