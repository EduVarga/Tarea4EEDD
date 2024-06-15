import java.util.Scanner;

public class ProgramaRefactorizado {
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

    private static void imprimirVectorInicial(int maximo) {
        for (int i = 1; i <= maximo; i++) {
            if ((i - 1) % 10 == 0) System.out.println();
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    private static void imprimirVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
        System.out.println();
    }

    // Generar números primos de 1 a maximo
    public static int[] generarPrimos(int maximo) {
        if (maximo < 2) {
            return new int[0]; // Vector vacío si el máximo es menor que 2
        }

        boolean[] esPrimo = inicializarArray(maximo);
        cribarPrimos(esPrimo);

        return extraerPrimos(esPrimo);
    }

    // Inicializar el array de booleanos
    private static boolean[] inicializarArray(int maximo) {
        int dimension = maximo + 1;
        boolean[] esPrimo = new boolean[dimension];

        for (int i = 2; i < dimension; i++) {
            esPrimo[i] = true;
        }
        return esPrimo;
    }

    // Aplicar la criba de Eratóstenes
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

    // Extraer los números primos del array booleano
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