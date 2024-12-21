package org.example;

import java.util.Scanner;
import static org.example.ConsoleColors.*;


public class Main {
    private static Player player1;
    private static Player player2;
    private static Board board;
    private static int fichasPorJugador;
    private static Piece colorPlayer1;
    private static Piece colorPlayer2;

    public static void main(String[] args) {
        /**Board board = new Board(6, 7); // Tablero de 6 filas y 7 columnas
        board.printBoard();
        System.out.println("Se puede jugar?:" + board.canPlay());

        board.placePiece(3, 'R');
        board.placePiece(3, 'R');
        board.printBoard();
        **/
        Scanner scanner = new Scanner(System.in);
        boolean jugando = true;
        System.out.println("-----MENU PRINCIPAL-----");
        System.out.println("Bienvenido a Conecta 4");

        while(jugando){
            System.out.println("\nSeleccione una opcion");
            System.out.println("1.- Crear nuevo juego");
            System.out.println("2.- Visualizar estado del tablero");
            System.out.println("3.- Realizar jugada");
            System.out.println("4.- Ver estadisticas");
            System.out.println("5.- Salir del juego");
            System.out.println("Ingrese su opcion: ");
            int opcion = scanner.nextInt();

            scanner.nextLine();

            switch(opcion){
                case 1:
                    crearNuevoJuego(scanner);
                    break;
                case 2:
                    board.printBoard();
                    break;
                case 3:
                    realizarJugada(scanner);
                    break;
                case 4:
                    //verEstadisticas();
                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    jugando = false;
                    break;
                default:
                    System.out.println("Opcion no valida, intente denuevo");
            }

        }
        scanner.close();
    }

    private static void crearNuevoJuego(Scanner scanner) {
        System.out.println("\n CREAR NUEVO JUEGO");

        System.out.println("--- Configuracion del jugador 1 ---");
        System.out.print("Ingrese el nombre del jugador 1: ");
        String nombreJugador1 = scanner.nextLine();
        System.out.print("Ingrese el color del jugador 1: ");
        String colorJugador1 = scanner.nextLine();

        System.out.println("\n--- Configuracion del Jugador 2 ---");
        System.out.print("Ingrese el nombre del jugador 2: ");
        String nombreJugador2 = scanner.nextLine();
        System.out.print("Ingrese el color del jugador 2: ");
        String colorJugador2 = scanner.nextLine();
        System.out.println("Usted tiene el color" + YELLOW_BOLD + " AMARILLO" + RESET);
        System.out.println("\n--- Configuracion del juego ---");
        System.out.print("Ingrese la cantidad de fichas (4 a 21)    : ");
        fichasPorJugador = scanner.nextInt();

        if (fichasPorJugador < 4 || fichasPorJugador > 21){
            System.out.println("Numero de fichas invalidas, se usara el valor por defecto 10");
            fichasPorJugador = 10;
        }

        player1 = new Player(1, nombreJugador1, colorJugador1, 0, 0, 0, fichasPorJugador);
        player2 = new Player(2, nombreJugador2, colorJugador2, 0, 0, 0, fichasPorJugador);
        board = new Board(6, 7);
        colorPlayer1 = new Piece(colorJugador1);
        colorPlayer2 = new Piece(colorJugador2);


        System.out.println("\nJuego creado exitosamente");

    }
    private static void realizarJugada(Scanner scanner){
        System.out.print("Jugador 1 (" + colorPlayer1.getColor() + "): ");
        System.out.println("Ingrese la columna en la cual desea colocar la ficha");
        int columna = scanner.nextInt();

        board.placePiece(columna, colorPlayer1);

        board.printBoard();

        board.canPlay();

        System.out.print("Jugador 2 (" + colorPlayer2.getColor() + "): ");
        System.out.println("Ingrese la columna en la cual desea colocar la ficha");
        columna = scanner.nextInt();

        board.placePiece(columna, colorPlayer2);

        board.printBoard();

        board.canPlay();


    }
}
