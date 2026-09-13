public class Main {
    public static void main(String[] args) {
        CabinaPeaje cabina = new CabinaPeaje();
        double tarifaBase = 1000.0;

        // Instanciamos los tres tipos de vehículos
        Vehiculo auto = new Auto("AA123CD", tarifaBase);
        Vehiculo moto = new Moto("A045DEF", tarifaBase);
        Vehiculo camion = new Camion("AE987GH", tarifaBase, 4); // 4 ejes

        System.out.println("=== COBRANDO PEAJES ===");
        cabina.cobrarPeaje(auto);   // Paga 1000
        cabina.cobrarPeaje(moto);   // Paga 500 (50%)
        cabina.cobrarPeaje(camion); // Paga 1000 + (4 * 500) = 3000

        cabina.mostrarReporte();
    }
}