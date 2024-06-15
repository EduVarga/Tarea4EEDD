import java.util.Scanner;

/**
 * Programa que utiliza la criba de Eratóstenes para encontrar números primos hasta un número dado.
 */
public class ProgramaJavaDoc {

    /**
     * Método principal que ejecuta el programa.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int maximo = teclado.nextInt();

        System.out.println("\nVector inicial hasta :" + maximo);
        imprimirVectorInicial(maximo);

        int[] primos = generarPrimos(maximo);
        System.out.println("\nVector de primos hasta:" + maximo);
        imprimirVector(primos);
    }

    /**
     * Imprime el vector inicial desde 1 hasta el número dado.
     *
     * @param maximo El número máximo hasta donde imprimir.
     */
    private static void imprimirVectorInicial(int maximo) {
        for (int i = 1; i <= maximo; i++) {
            if ((i - 1) % 10 == 0) System.out.println();
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    /**
     * Imprime un vector de enteros.
     *
     * @param vector El vector de enteros a imprimir.
     */
    private static void imprimirVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
        System.out.println();
    }

    /**
     * Genera un array de números primos desde 1 hasta el número máximo dado utilizando la criba de Eratóstenes.
     *
     * @param maximo El número máximo hasta donde buscar primos.
     * @return Un array de números primos.
     */
    public static int[] generarPrimos(int maximo) {
        if (maximo < 2) {
            return new int[0]; // Vector vacío si el máximo es menor que 2
        }

        boolean[] esPrimo = inicializarArray(maximo);
        cribarPrimos(esPrimo);

        return extraerPrimos(esPrimo);
    }

    /**
     * Inicializa un array booleano para el proceso de la criba de Eratóstenes.
     *
     * @param maximo El número máximo hasta donde inicializar el array.
     * @return Un array booleano inicializado.
     */
    private static boolean[] inicializarArray(int maximo) {
        int dimension = maximo + 1;
        boolean[] esPrimo = new boolean[dimension];

        for (int i = 2; i < dimension; i++) {
            esPrimo[i] = true;
        }
        return esPrimo;
    }

    /**
     * Aplica la criba de Eratóstenes para marcar los números no primos en el array booleano.
     *
     * @param esPrimo El array booleano que indica si un número es primo.
     */
    private static void cribarPrimos(boolean[] esPrimo) {
        int dimension = esPrimo.length;
        for (int i = 2; i <= Math.sqrt(dimension); i++) {
            if (esPrimo[i]) {
                for (int j = 2 * i; j < dimension; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }

    /**
     * Extrae los números primos del array booleano.
     *
     * @param esPrimo El array booleano que indica si un número es primo.
     * @return Un array de números primos.
     */
    private static int[] extraerPrimos(boolean[] esPrimo) {
        int cuenta = 0;
        for (boolean primo : esPrimo) {
            if (primo) {
                cuenta++;
            }
        }

        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
        return primos;
    }
}