import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaExcepciones {

    public static void probarDivision() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingresá el numerador (número entero): ");
            int num1 = scanner.nextInt();

            System.out.print("Ingresá el denominador (número entero): ");
            int num2 = scanner.nextInt();

            // Esto puede lanzar ArithmeticException si num2 es 0
            int resultado = num1 / num2;
            System.out.println("Resultado de la división: " + resultado);

        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar únicamente números enteros, no texto.");
        } catch (ArithmeticException e) {
            System.out.println("Error matemático: No se puede dividir por cero.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Operación finalizada (bloque finally ejecutado).");
        }
    }
}