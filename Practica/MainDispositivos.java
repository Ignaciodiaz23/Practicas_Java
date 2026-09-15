// Clase Base (Padre)
class Dispositivo {
    protected String marca;
    protected String modelo;

    public Dispositivo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void mostrarInfo() {
        System.out.println("Dispositivo: " + marca + " " + modelo);
    }
}

// Clase Derivada (Hija)
class Computadora extends Dispositivo {
    private int memoriaRam;

    public Computadora(String marca, String modelo, int memoriaRam) {
        super(marca, modelo); // Llama al constructor de la clase padre
        this.memoriaRam = memoriaRam;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Computadora: " + marca + " " + modelo + " | RAM: " + memoriaRam + "GB");
    }
}

// Clase Principal
public class MainDispositivos {
    public static void main(String[] args) {
        Dispositivo d = new Dispositivo("Generic", "X1");
        Computadora c = new Computadora("Apple", "MacBook Air", 16);

        d.mostrarInfo();
        c.mostrarInfo();
    }
}