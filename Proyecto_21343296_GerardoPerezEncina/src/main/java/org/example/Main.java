package org.example;

import java.util.Scanner;

/**
 * Clase principal que ejecuta el juego Conecta 4.
 * Permite a los usuarios interactuar con el juego a través de un menú.
 */
public class Main {
    private static Player player1;
    private static Player player2;
    private static Board board;
    private static int fichasPorJugador;
    private static Piece colorPlayer1;
    private static Piece colorPlayer2;
    private static Game game;

    /**
     * Método principal que inicializa el programa y ejecuta el menú del juego.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jugando = true;
        System.out.println("-----MENU PRINCIPAL-----");
        System.out.println("Bienvenido a Conecta 4");

        while (jugando) {
            System.out.println("\nSeleccione una opcion");
            System.out.println("1.- Crear nuevo juego");
            System.out.println("2.- Visualizar estado del tablero");
            System.out.println("3.- Realizar jugada");
            System.out.println("4.- Ver estadisticas");
            System.out.println("5.- Salir del juego");
            System.out.println("Ingrese su opcion: ");
            int opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearNuevoJuego(scanner);
                    break;
                case 2:
                    if (verificarJuegoIniciado()) {
                        game.boardGetState();
                    }
                    break;
                case 3:
                    if (verificarJuegoIniciado()) {
                        game.realizarMovimiento(scanner);
                    }
                    break;
                case 4:
                    if (verificarJuegoIniciado()) {
                        verEstadisticas(player1, player2);
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    jugando = false;
                    break;
                default:
                    System.out.println("Opcion no valida, intente de nuevo");
            }
        }
        scanner.close();
    }

    /**
     * Método para crear un nuevo juego de Conecta 4.
     * Solicita los datos de configuración al usuario, como nombres, colores y cantidad de fichas.
     *
     * @param scanner Objeto Scanner para leer la entrada del usuario.
     */
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
        if (colorJugador1.equals(colorJugador2)) {
            System.out.print("Los colores no pueden ser iguales, ingrese otro: ");
            colorJugador2 = scanner.next();
        }

        System.out.println("\n--- Configuracion del juego ---");
        System.out.print("Ingrese la cantidad de fichas (4 a 21): ");
        fichasPorJugador = scanner.nextInt();

        if (fichasPorJugador < 4 || fichasPorJugador > 21) {
            System.out.println("Numero de fichas invalidas, se usara el valor por defecto 10");
            fichasPorJugador = 10;
        }

        player1 = new Player(1, nombreJugador1, colorJugador1, 0, 0, 0, fichasPorJugador);
        player2 = new Player(2, nombreJugador2, colorJugador2, 0, 0, 0, fichasPorJugador);
        board = new Board(6, 7);
        colorPlayer1 = new Piece(colorJugador1);
        colorPlayer2 = new Piece(colorJugador2);

        game = new Game(6, 7, fichasPorJugador, player1, player2);

        System.out.println("\nJuego creado exitosamente");
        game.boardGetState();
    }

    /**
     * Método para verificar si un juego ha sido creado.
     * Muestra un mensaje al usuario si el juego no ha sido inicializado.
     *
     * @return {@code true} si el juego ha sido creado, {@code false} en caso contrario.
     */
    private static boolean verificarJuegoIniciado() {
        if (game == null) {
            System.out.println("No se ha creado un juego. Por favor, seleccione la opcion 1 para crear un nuevo juego.");
            return false;
        }
        return true;
    }

    /**
     * Muestra las estadísticas de los jugadores en el juego actual.
     *
     * @param player1 Jugador 1 del juego.
     * @param player2 Jugador 2 del juego.
     */
    public static void verEstadisticas(Player player1, Player player2) {
        // Mostrar estadísticas del Jugador 1
        System.out.println("### Estadisticas de " + player1.getName() + " ###");
        System.out.println("Color: " + player1.getColor());
        System.out.println("Victorias: " + player1.getWins());
        System.out.println("Derrotas: " + player1.getLosses());
        System.out.println("Empates: " + player1.getDraws());
        System.out.println("Fichas restantes: " + player1.getRemainingPieces());
        System.out.println();

        // Mostrar estadísticas del Jugador 2
        System.out.println("### Estadisticas de " + player2.getName() + " ###");
        System.out.println("Color: " + player2.getColor());
        System.out.println("Victorias: " + player2.getWins());
        System.out.println("Derrotas: " + player2.getLosses());
        System.out.println("Empates: " + player2.getDraws());
        System.out.println("Fichas restantes: " + player2.getRemainingPieces());
        System.out.println();
    }
}
