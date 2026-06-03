import java.util.Random;
import java.util.Scanner;

public class Buscaminas {

    public static void main(String[] args) {
    	boolean jugando = true;
        boolean primeraJugada = true;
        Scanner sc = new Scanner(System.in);
        String[][] conecta = new String[5][5];
        boolean[][] minas = new boolean[5][5];
        int descubiertas = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                conecta[i][j] = "*";
            }
        }

        while (jugando) {
            System.out.println("  1 2 3 4 5");

            for (int i = 0; i < 5; i++) {
            	System.out.print((i + 1) + " ");
                for (int j = 0; j < 5; j++) {
                    System.out.print(conecta[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Por favor ingrese la coordenada de la forma: fila columna");
            System.out.println("b fila columna -> Colocar bandera");
            System.out.println("v -> Mostrar minas");

            String entrada = sc.next();

            if (entrada.equalsIgnoreCase("v")) {

                if (primeraJugada) {
                    System.out.println("Las minas aun no se han generado.");
                    continue;
                }

                System.out.println("\nTABLERO DE MINAS");
                System.out.println("  1 2 3 4 5");

                for (int i = 0; i < 5; i++) {

                    System.out.print((i + 1) + " ");

                    for (int j = 0; j < 5; j++) {

                        if (minas[i][j]) {
                            System.out.print("X ");
                        } else {
                            System.out.print("- ");
                        }
                    }

                    System.out.println();
                }

                System.out.println();
                continue;
            }

            if (entrada.equalsIgnoreCase("b")) {

                int fila = sc.nextInt() - 1;
                int columna = sc.nextInt() - 1;

                if (fila >= 0 && fila < 5 && columna >= 0 && columna < 5) {

                    if (conecta[fila][columna].equals("*")) {
                        conecta[fila][columna] = "F";
                    } else if (conecta[fila][columna].equals("F")) {
                        conecta[fila][columna] = "*";
                    }
                }

                continue;
            }

            int fila = Integer.parseInt(entrada) - 1;
            int columna = sc.nextInt() - 1;

            if (fila < 0 || fila > 4 || columna < 0 || columna > 4) {

                System.out.println("Coordenadas inválidas.");
                continue;
            }

            if (primeraJugada) {

                Random r = new Random();
                int cantidad = 0;

                while (cantidad < 4) {

                    int x = r.nextInt(5);
                    int y = r.nextInt(5);

                    if (!minas[x][y] && !(x == fila && y == columna)) {
                        minas[x][y] = true;
                        cantidad++;
                    }
                }
                primeraJugada = false;
            }

            if (conecta[fila][columna].equals("F")) {

                System.out.println("La casilla tiene una bandera.");
                continue;
            }

            if (minas[fila][columna]) {
                System.out.println("\nBOOM. Has perdido.\n");
                System.out.println("  1 2 3 4 5");
                for (int i = 0; i < 5; i++) {
                    System.out.print((i + 1) + " ");
                    for (int j = 0; j < 5; j++) {
                        if (minas[i][j]) {
                            System.out.print("X ");
                        } else {
                            System.out.print(conecta[i][j] + " ");
                        }
                    }

                    System.out.println();
                }
                break;
            }
            int contador = 0;
            for (int i = fila - 1; i <= fila + 1; i++) {
                for (int j = columna - 1; j <= columna + 1; j++) {
                    if (i >= 0 && i < 5 && j >= 0 && j < 5) {
                        if (minas[i][j]) {
                            contador++;
                        }
                    }
                }
            }

            if (conecta[fila][columna].equals("*")) {
                descubiertas++;
            }
            conecta[fila][columna] = String.valueOf(contador);

            if (descubiertas == 21) {
                System.out.println("\n¡Ganaste!\n");
                System.out.println("  1 2 3 4 5");
                for (int i = 0; i < 5; i++) {
                    System.out.print((i + 1) + " ");
                    for (int j = 0; j < 5; j++) {
                        if (minas[i][j]) {
                            System.out.print("X ");
                        } else {
                            System.out.print(conecta[i][j] + " ");
                        }
                    }

                    System.out.println();
                }
                jugando = false;
            }
        }
        sc.close();
    }
}