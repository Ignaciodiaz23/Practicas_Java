public class SaludoPersonalizado {
    public static void main(String[] args){
        if (args.length > 0){
            System.out.println("Hola!"+ args [0] +"Bienvenido a la ingenieria en Java.");

        } else {
            System.out.println("Hola, Desarrollador Anonimo! Pasa tu nombre como argumento.");
            
        }
    }
}
