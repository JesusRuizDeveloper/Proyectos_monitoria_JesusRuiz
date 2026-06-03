import java.util.Random;
import java.util.Scanner;

public class BatallaNaval {

    public static void main(String[] args) {

        String[][] matriz1 = new String[9][9];
        String[][] matriz2 = new String[9][9];

        // Inicializar matriz 1
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matriz1[i][j] = "*";
            }
        }

        // Inicializar matriz 2
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matriz2[i][j] = "*";
            }
        }

        Random random = new Random();

        // Barcos jugador 1
        int barcos = 3;

        while (barcos > 0) {

            int fila = random.nextInt(9);
            int columna = random.nextInt(9);
            int orientacion = random.nextInt(2);

            boolean valido = true;

            if (orientacion == 0) {

                if (columna + barcos > 9) {
                    valido = false;
                } else {

                    for (int j = 0; j < barcos; j++) {
                        if (matriz1[fila][columna + j].equals("B")) {
                            valido = false;
                        }
                    }
                }

                if (valido) {
                    for (int j = 0; j < barcos; j++) {
                        matriz1[fila][columna + j] = "B";
                    }
                    barcos--;
                }

            } else {

                if (fila + barcos > 9) {
                    valido = false;
                } else {

                    for (int i = 0; i < barcos; i++) {
                        if (matriz1[fila + i][columna].equals("B")) {
                            valido = false;
                        }
                    }
                }

                if (valido) {
                    for (int i = 0; i < barcos; i++) {
                        matriz1[fila + i][columna] = "B";
                    }
                    barcos--;
                }
            }
        }

        // Barcos jugador 2
        barcos = 3;

        while (barcos > 0) {

            int fila = random.nextInt(9);
            int columna = random.nextInt(9);
            int orientacion = random.nextInt(2);

            boolean valido = true;

            if (orientacion == 0) {

                if (columna + barcos > 9) {
                    valido = false;
                } else {

                    for (int j = 0; j < barcos; j++) {
                        if (matriz2[fila][columna + j].equals("B")) {
                            valido = false;
                        }
                    }
                }

                if (valido) {
                    for (int j = 0; j < barcos; j++) {
                        matriz2[fila][columna + j] = "B";
                    }
                    barcos--;
                }

            } else {

                if (fila + barcos > 9) {
                    valido = false;
                } else {

                    for (int i = 0; i < barcos; i++) {
                        if (matriz2[fila + i][columna].equals("B")) {
                            valido = false;
                        }
                    }
                }

                if (valido) {
                    for (int i = 0; i < barcos; i++) {
                        matriz2[fila + i][columna] = "B";
                    }
                    barcos--;
                }
            }
        }

        Scanner sc = new Scanner(System.in);

        int barcosJugador1 = 6;
        int barcosJugador2 = 6;

        while (barcosJugador1 > 0 && barcosJugador2 > 0) {

            // TURNO JUGADOR 1
            System.out.println("\n===== TURNO JUGADOR 1 =====");

            System.out.print("   ");
            for (int j = 1; j <= 9; j++) {
                System.out.print(j + " ");
            }
            System.out.println();

            for (int i = 0; i < 9; i++) {

                System.out.print((i + 1) + "  ");

                for (int j = 0; j < 9; j++) {

                    if (matriz2[i][j].equals("B")) {
                        System.out.print("* ");
                    } else {
                        System.out.print(matriz2[i][j] + " ");
                    }
                }

                System.out.println();
            }

            System.out.print("Fila (1-9): ");
            int fila = sc.nextInt() - 1;

            System.out.print("Columna (1-9): ");
            int columna = sc.nextInt() - 1;

            if (matriz2[fila][columna].equals("B")) {

                System.out.println("¡Encontraste un barco!");

                matriz2[fila][columna] = "X";
                barcosJugador2--;

            } else {

                System.out.println("Agua.");

                matriz2[fila][columna] = "O";
            }

            if (barcosJugador2 == 0) {

                System.out.println("\nJugador 1 ha ganado.");
                break;
            }

            // TURNO JUGADOR 2
            System.out.println("\n===== TURNO JUGADOR 2 =====");

            System.out.print("   ");
            for (int j = 1; j <= 9; j++) {
                System.out.print(j + " ");
            }
            System.out.println();

            for (int i = 0; i < 9; i++) {

                System.out.print((i + 1) + "  ");

                for (int j = 0; j < 9; j++) {

                    if (matriz1[i][j].equals("B")) {
                        System.out.print("* ");
                    } else {
                        System.out.print(matriz1[i][j] + " ");
                    }
                }

                System.out.println();
            }

            System.out.print("Fila (1-9): ");
            fila = sc.nextInt() - 1;

            System.out.print("Columna (1-9): ");
            columna = sc.nextInt() - 1;

            if (matriz1[fila][columna].equals("B")) {

                System.out.println("¡Encontraste un barco!");

                matriz1[fila][columna] = "X";
                barcosJugador1--;

            } else {

                System.out.println("Agua.");

                matriz1[fila][columna] = "O";
            }

            if (barcosJugador1 == 0) {

                System.out.println("\nJugador 2 ha ganado.");
                break;
            }
        }

        sc.close();
    }
}