import java.util.NoSuchElementException;
import java.util.Scanner;

// Calculadora en base 3
// Suma, resta y multiplica sin pasar a decimal.
// Los numeros se guardan como String y se operan digito por digito con for.
public class CalculadoraBase3 {

    // la base con la que trabajamos
    static final int BASE = 3;

    // ============================================================
    // EXCEPCION PROPIA
    // ============================================================

    // Creamos nuestra propia excepcion heredando de Exception.
    // Al heredar de Exception es "checked": obliga a usar try/catch
    // o a poner throws en el metodo que la puede lanzar.
    static class NumeroBase3Exception extends Exception {

        // le pasamos el mensaje de error al constructor de Exception
        public NumeroBase3Exception(String mensaje) {
            super(mensaje);
        }
    }

    // ============================================================
    // VALIDACION (aca se producen los errores de datos)
    // ============================================================

    // Revisa que el texto sea un numero en base 3 (solo 0, 1 y 2).
    // El "throws" avisa que este metodo puede lanzar la excepcion.
    static void validarNumero(String s) throws NumeroBase3Exception {

        // ERROR 1: el usuario no escribio nada
        if (s == null || s.isEmpty()) {
            // AQUI SE LANZA LA EXCEPCION (throw)
            throw new NumeroBase3Exception("no ingresaste ningun numero.");
        }

        // si empieza con '-' empezamos a revisar desde la posicion 1
        int inicio = 0;
        if (s.charAt(0) == '-') {
            inicio = 1;
        }

        // ERROR 2: escribio solo el signo '-' y nada mas
        if (inicio == s.length()) {
            // AQUI SE LANZA LA EXCEPCION (throw)
            throw new NumeroBase3Exception("falta el numero despues del signo '-'.");
        }

        // recorremos cada caracter con un for
        for (int i = inicio; i < s.length(); i++) {
            char c = s.charAt(i);

            // ERROR 3: un digito que no es 0, 1 o 2
            if (c < '0' || c > '2') {
                // AQUI SE LANZA LA EXCEPCION (throw)
                throw new NumeroBase3Exception("'" + c + "' no es un digito valido en base 3 (solo 0, 1 y 2).");
            }
        }
        // si llega hasta aca el numero es valido y no pasa nada
    }

    // ============================================================
    // METODOS AUXILIARES
    // ============================================================

    // Saca los ceros de la izquierda. Si queda vacio devuelve "0".
    static String quitarCeros(String s) {
        int i = 0;
        // avanzamos mientras haya ceros adelante (dejando al menos 1 digito)
        while (i < s.length() - 1 && s.charAt(i) == '0') {
            i++;
        }
        // devolvemos desde la primera posicion que no es cero
        return s.substring(i);
    }

    // Compara dos numeros sin signo.
    // Devuelve positivo si a > b, 0 si son iguales, negativo si a < b.
    static int comparar(String a, String b) {
        a = quitarCeros(a);
        b = quitarCeros(b);

        // el que tiene mas digitos es mas grande
        if (a.length() != b.length()) {
            return a.length() - b.length();
        }

        // misma cantidad de digitos: comparamos de izquierda a derecha
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.charAt(i) - b.charAt(i);
            }
        }

        // todos los digitos iguales
        return 0;
    }

    // dice si el numero tiene el signo '-' adelante
    static boolean esNegativo(String s) {
        return s.charAt(0) == '-';
    }

    // devuelve el numero sin el signo
    static String sinSigno(String s) {
        if (esNegativo(s)) {
            return s.substring(1);
        }
        return s;
    }

    // le pone el signo al resultado (el cero nunca lleva signo)
    static String ponerSigno(String num, boolean negativo) {
        num = quitarCeros(num);
        if (num.equals("0")) {
            return "0";
        }
        if (negativo) {
            return "-" + num;
        }
        return num;
    }

    // ============================================================
    // OPERACIONES SOBRE NUMEROS SIN SIGNO
    // ============================================================

    // SUMA: de derecha a izquierda, con acarreo
    static String sumarSinSigno(String a, String b) {
        // cantidad de vueltas = largo del numero mas largo
        int n = Math.max(a.length(), b.length());
        StringBuilder resultado = new StringBuilder();
        int acarreo = 0;

        for (int i = 0; i < n; i++) {
            // tomamos el digito de cada numero desde la derecha (0 si ya no hay)
            int da = 0;
            if (i < a.length()) {
                da = a.charAt(a.length() - 1 - i) - '0';
            }
            int db = 0;
            if (i < b.length()) {
                db = b.charAt(b.length() - 1 - i) - '0';
            }

            int suma = da + db + acarreo;

            // el digito que se escribe es el resto de dividir por 3
            resultado.append(suma % BASE);
            // lo que se lleva es el cociente
            acarreo = suma / BASE;
        }

        // si sobro acarreo lo agregamos al final
        if (acarreo > 0) {
            resultado.append(acarreo);
        }

        // lo armamos al reves, asi que lo damos vuelta
        return quitarCeros(resultado.reverse().toString());
    }

    // RESTA: a - b, solo funciona si a >= b. Usa prestamo.
    static String restarSinSigno(String a, String b) {
        StringBuilder resultado = new StringBuilder();
        int prestamo = 0;

        for (int i = 0; i < a.length(); i++) {
            int da = a.charAt(a.length() - 1 - i) - '0';

            int db = 0;
            if (i < b.length()) {
                db = b.charAt(b.length() - 1 - i) - '0';
            }

            int d = da - db - prestamo;

            if (d < 0) {
                // no alcanza: "pedimos prestado" 3 al digito de la izquierda
                d = d + BASE;
                prestamo = 1;
            } else {
                prestamo = 0;
            }

            resultado.append(d);
        }

        return quitarCeros(resultado.reverse().toString());
    }

    // MULTIPLICACION: cada digito de b por cada digito de a
    static String multiplicarSinSigno(String a, String b) {
        // el resultado puede tener como maximo largoA + largoB digitos
        int[] res = new int[a.length() + b.length()];

        // for de afuera: digitos de b / for de adentro: digitos de a
        for (int i = 0; i < b.length(); i++) {
            int db = b.charAt(b.length() - 1 - i) - '0';

            for (int j = 0; j < a.length(); j++) {
                int da = a.charAt(a.length() - 1 - j) - '0';

                // sumamos el producto en la posicion que le corresponde
                res[i + j] = res[i + j] + da * db;
            }
        }

        // pasamos los acarreos para que cada posicion quede entre 0 y 2
        for (int k = 0; k < res.length - 1; k++) {
            res[k + 1] = res[k + 1] + res[k] / BASE;
            res[k] = res[k] % BASE;
        }

        // armamos el String desde la ultima posicion a la primera
        StringBuilder resultado = new StringBuilder();
        for (int k = res.length - 1; k >= 0; k--) {
            resultado.append(res[k]);
        }

        return quitarCeros(resultado.toString());
    }

    // ============================================================
    // OPERACIONES CON SIGNO
    // ============================================================

    static String sumar(String x, String y) {
        boolean negX = esNegativo(x);
        boolean negY = esNegativo(y);
        String a = sinSigno(x);
        String b = sinSigno(y);

        // mismo signo: se suman y se queda el signo
        if (negX == negY) {
            return ponerSigno(sumarSinSigno(a, b), negX);
        }

        // signos distintos: se resta el mas chico del mas grande
        int cmp = comparar(a, b);

        if (cmp == 0) {
            // son iguales con signo opuesto, da 0
            return "0";
        }
        if (cmp > 0) {
            // gana el signo de x
            return ponerSigno(restarSinSigno(a, b), negX);
        }
        // gana el signo de y
        return ponerSigno(restarSinSigno(b, a), negY);
    }

    static String restar(String x, String y) {
        // x - y es lo mismo que x + (-y), asi que le cambiamos el signo a y
        String yCambiado;
        if (esNegativo(y)) {
            yCambiado = y.substring(1);
        } else {
            yCambiado = "-" + y;
        }
        return sumar(x, yCambiado);
    }

    static String multiplicar(String x, String y) {
        // menos por mas = menos, menos por menos = mas
        boolean negativo = esNegativo(x) != esNegativo(y);
        return ponerSigno(multiplicarSinSigno(sinSigno(x), sinSigno(y)), negativo);
    }

    // ============================================================
    // PROGRAMA PRINCIPAL
    // ============================================================

    public static void main(String[] args) {
        // Scanner para leer lo que escribe el usuario
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CALCULADORA EN BASE 3 ===");
        System.out.println("Solo se usan los digitos 0, 1 y 2 (negativos con '-').");
        System.out.println("Operaciones: +  -  *   |   Escribi 'salir' para terminar.");

        // TRY EXTERNO: protege todo el programa
        try {

            // for sin condicion: se repite hasta que haya un break
            for (;;) {

                // TRY INTERNO: protege una sola vuelta de la calculadora,
                // asi si hay un error el programa no se corta y vuelve a pedir datos
                try {
                    // pedimos el primer numero
                    System.out.print("\nPrimer numero (base 3): ");
                    String a = sc.nextLine().trim();
                    // si escribe "salir" cortamos el for
                    if (a.equalsIgnoreCase("salir")) {
                        break;
                    }

                    // pedimos la operacion
                    System.out.print("Operacion (+, -, *): ");
                    String op = sc.nextLine().trim();
                    if (op.equalsIgnoreCase("salir")) {
                        break;
                    }

                    // pedimos el segundo numero
                    System.out.print("Segundo numero (base 3): ");
                    String b = sc.nextLine().trim();
                    if (b.equalsIgnoreCase("salir")) {
                        break;
                    }

                    // VALIDAMOS: si algun numero esta mal, estos metodos
                    // lanzan NumeroBase3Exception y el programa salta
                    // directo al catch (no se ejecuta nada de lo que sigue)
                    validarNumero(a);
                    validarNumero(b);

                    // si llegamos aca los dos numeros son validos
                    String resultado;

                    // elegimos la operacion segun lo que escribio
                    switch (op) {
                        case "+":
                            resultado = sumar(a, b);
                            break;
                        case "-":
                            resultado = restar(a, b);
                            break;
                        case "*":
                            resultado = multiplicar(a, b);
                            break;
                        default:
                            // ERROR 4: la operacion no es +, - ni *
                            // AQUI SE LANZA LA EXCEPCION (throw)
                            // IllegalArgumentException ya viene hecha en Java
                            throw new IllegalArgumentException("operacion no valida. Usa +, - o *.");
                    }

                    // mostramos el resultado
                    System.out.println(a + " " + op + " " + b + " = " + resultado + "  (base 3)");

                // CATCH: AQUI SE ATRAPAN LAS EXCEPCIONES.
                // El "|" sirve para atrapar dos tipos distintos en un solo catch:
                // - NumeroBase3Exception: numero mal escrito (la lanza validarNumero)
                // - IllegalArgumentException: operacion invalida (la lanza el switch)
                } catch (NumeroBase3Exception | IllegalArgumentException e) {
                    // e.getMessage() devuelve el mensaje que pusimos en el throw
                    System.out.println("Error: " + e.getMessage());

                // FINALLY INTERNO: se ejecuta SIEMPRE en cada vuelta,
                // haya error, salga bien o el usuario escriba "salir"
                } finally {
                    System.out.println("------------------------------");
                }
            }

        // CATCH EXTERNO: se produce si se corta la entrada de datos
        // (por ejemplo con Ctrl+D) y nextLine() no tiene nada para leer
        } catch (NoSuchElementException e) {
            System.out.println("\nSe cerro la entrada de datos.");

        // FINALLY EXTERNO: se ejecuta siempre al terminar el programa,
        // lo usamos para cerrar el Scanner
        } finally {
            sc.close();
            System.out.println("Hasta luego!");
        }
    }
} 