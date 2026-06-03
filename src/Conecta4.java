import java.util.Scanner;

public class Conecta4 {

    public static void main(String[] args) {

        boolean flag = true;
        boolean turno = true;
        int lugar = 0;
        int contador = 0;

        Scanner sc = new Scanner(System.in);

        String conecta[][] = new String[4][4];

        // Inicializar tablero
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                conecta[i][j] = "*";
            }
        }

        while (flag) {

            System.out.println("1 2 3 4");

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(conecta[i][j] + " ");
                }
                System.out.println();
            }

            if (turno) {
                System.out.println("Es el turno de X");
            } else {
                System.out.println("Es el turno de O");
            }

            System.out.println("Por favor seleccione la columna en la que desea jugar");

            lugar = sc.nextInt() - 1;

            // Validar columna
            if (lugar < 0 || lugar > 3) {
                System.out.println("Columna inválida");
                continue;
            }

            boolean insertado = false;

            for (int i = 3; i >= 0; i--) {

                if (conecta[i][lugar].equals("*") && turno) {
                    conecta[i][lugar] = "X";
                    insertado = true;
                    break;

                } else if (conecta[i][lugar].equals("*") && !turno) {
                    conecta[i][lugar] = "O";
                    insertado = true;
                    break;
                }
            }

            if (!insertado) {
                System.out.println("La columna está llena");
                continue;
            }

            // ====================
            // COMPROBAR X
            // ====================

            // Filas
            for (int i = 0; i < 4; i++) {
                contador = 0;

                for (int j = 0; j < 4; j++) {
                    if (conecta[i][j].equals("X")) {
                        contador++;
                    }
                }

                if (contador == 4) {
                    System.out.println("Ha ganado X");
                    flag = false;
                }
            }

            // Columnas
            for (int i = 0; i < 4; i++) {
                contador = 0;

                for (int j = 0; j < 4; j++) {
                    if (conecta[j][i].equals("X")) {
                        contador++;
                    }
                }

                if (contador == 4) {
                    System.out.println("Ha ganado X");
                    flag = false;
                }
            }

            // Diagonal principal
            contador = 0;

            for (int i = 0; i < 4; i++) {
                if (conecta[i][i].equals("X")) {
                    contador++;
                }
            }

            if (contador == 4) {
                System.out.println("Ha ganado X");
                flag = false;
            }

            // Diagonal secundaria
            contador = 0;

            for (int i = 0; i < 4; i++) {
                if (conecta[i][3 - i].equals("X")) {
                    contador++;
                }
            }

            if (contador == 4) {
                System.out.println("Ha ganado X");
                flag = false;
            }

            // ====================
            // COMPROBAR O
            // ====================

            // Filas
            for (int i = 0; i < 4; i++) {
                contador = 0;

                for (int j = 0; j < 4; j++) {
                    if (conecta[i][j].equals("O")) {
                        contador++;
                    }
                }

                if (contador == 4) {
                    System.out.println("Ha ganado O");
                    flag = false;
                }
            }

            // Columnas
            for (int i = 0; i < 4; i++) {
                contador = 0;

                for (int j = 0; j < 4; j++) {
                    if (conecta[j][i].equals("O")) {
                        contador++;
                    }
                }

                if (contador == 4) {
                    System.out.println("Ha ganado O");
                    flag = false;
                }
            }

            // Diagonal principal
            contador = 0;

            for (int i = 0; i < 4; i++) {
                if (conecta[i][i].equals("O")) {
                    contador++;
                }
            }

            if (contador == 4) {
                System.out.println("Ha ganado O");
                flag = false;
            }

            // Diagonal secundaria
            contador = 0;

            for (int i = 0; i < 4; i++) {
                if (conecta[i][3 - i].equals("O")) {
                    contador++;
                }
            }

            if (contador == 4) {
                System.out.println("Ha ganado O");
                flag = false;
            }

            turno = !turno;
        }

        sc.close();
    }
}