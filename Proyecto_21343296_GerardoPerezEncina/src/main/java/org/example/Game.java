package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Representa una partida del juego Conecta 4.
 * Esta clase gestiona el flujo del juego, el estado del tablero, los jugadores y las reglas.
 */
public class Game implements GameInterface{
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    public List<String> historial;
    private Piece colorPlayer1;
    private Piece colorPlayer2;

    /**
     * Constructor de la clase Game.
     * Inicializa una nueva partida de Conecta 4 con las dimensiones del tablero,
     * el número de fichas por jugador y los dos jugadores.
     *
     * @param filas El número de filas del tablero.
     * @param columnas El número de columnas del tablero.
     * @param fichasPorJugador El número de fichas que cada jugador comienza con.
     * @param player1 El primer jugador.
     * @param player2 El segundo jugador.
     */
    public Game(int filas, int columnas, int fichasPorJugador, Player player1, Player player2){
        this.board = new Board(filas, columnas);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.historial = new ArrayList<>();
        this.colorPlayer1 = new Piece(player1.getColor());
        this.colorPlayer2 = new Piece(player2.getColor());

        this.player1.setRemainingPieces(fichasPorJugador);
        this.player2.setRemainingPieces(fichasPorJugador);
    }

    /**
     * Muestra el historial completo de movimientos realizados durante la partida.
     * Cada movimiento se muestra en una línea separada, indicando el jugador y la columna en la que se colocó la ficha.
     */
    public void showHistory() {
        System.out.println("\n### Historial de Movimientos ###");
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }

    /**
     * Determina si se ha producido un empate.
     * Un empate ocurre cuando el tablero está completamente lleno o cuando ambos jugadores se han quedado sin fichas.
     *
     * @return `true` si hay un empate, `false` en caso contrario.
     */
    public boolean esEmpate() {
        // Verificar si el tablero tiene posiciones disponibles
        boolean tableroLleno = !board.canPlay();


        boolean sinFichas = (player1.getRemainingPieces() == 0 && player2.getRemainingPieces() == 0);


        return tableroLleno || sinFichas;
    }

    /**
     * Devuelve el jugador que tiene el turno actual.
     *
     * @return El jugador con el turno actual.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Muestra el estado actual del tablero en la consola.
     * Cada posición del tablero se representa con un carácter (por ejemplo, 'X', 'O' o '-').
     */
    public void boardGetState() {
        System.out.println("\n### Estado Actual del Tablero ###");
        board.printBoard(); // Llama a la función existente en la clase Board
    }


    /**
     * Finaliza la partida y muestra el resultado.
     *
     * @param resultado El resultado de la partida ("victoria" o "empate").
     * @param ganador El jugador ganador (si hay).
     * @param perdedor El jugador perdedor (si hay).
     */
    public void endGame(String resultado, Player ganador, Player perdedor) {
        if (resultado.equals("victoria")) {

            ganador.actualizarStats(perdedor, "victoria");
            System.out.println("El ganador es " + ganador.getName() + " con el color " + ganador.getColor() + "!");
        }
        else if (resultado.equals("empate")) {

            ganador.actualizarStats(perdedor, "empate");
            System.out.println("El juego termina en empate!");
        }

        showHistory();

        System.out.println("\nEl juego ha finalizado. No se permiten mas jugadas.");
    }

    /**
     * Cambia el turno al siguiente jugador.
     * El jugador actual se alterna entre player1 y player2.
     */
    public void switchTurn() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    /**
     * Realiza un movimiento en el juego.
     *
     * Permite al jugador actual colocar una ficha en la columna seleccionada.
     * Verifica la validez del movimiento, actualiza el estado del tablero,
     * comprueba si hay un ganador o un empate, y cambia el turno al siguiente jugador.</p>
     *
     * @param scanner Un objeto Scanner para leer la entrada del usuario.
     */
    public void realizarMovimiento(Scanner scanner) {
        boolean jugando = true;

        while (jugando) {
            // Obtener el jugador actual
            Player jugadorActual = getCurrentPlayer();
            Piece colorActual = (jugadorActual == player1) ? colorPlayer1 : colorPlayer2;

            // Turno del jugador actual
            System.out.print(jugadorActual.getName() + " (" + colorActual.getColor() + "): ");
            System.out.println("Ingrese la columna en la cual desea colocar la ficha");
            int columna = scanner.nextInt();

            // Intentar colocar la ficha
            boolean movimientoValido = board.placePiece(columna, colorActual);
            if (!movimientoValido) {
                System.out.println("Movimiento invalido. La columna " + columna + " esta llena o fuera de rango.");
                continue; // Volver a pedir al jugador que coloque una ficha
            }

            // Registrar el movimiento
            historial.add(jugadorActual.getName() + " (" + jugadorActual.getColor() + ") coloco ficha en columna " + columna);

            // Disminuir las fichas restantes
            jugadorActual.setRemainingPieces(jugadorActual.getRemainingPieces() - 1);

            // Verificar si hay un ganador
            String ganador = board.entregarGanador();
            if (ganador != null) {
                Player otroJugador = (jugadorActual == player1) ? player2 : player1;
                endGame("victoria", jugadorActual, otroJugador); // Finalizar el juego con victoria
                jugando = false; // Detener el ciclo
                return;
            }

            // Mostrar el estado actual del tablero
            boardGetState();

            // Verificar si el juego ha terminado en empate
            if (esEmpate()) {
                Player otroJugador = (jugadorActual == player1) ? player2 : player1;
                endGame("empate", jugadorActual, otroJugador); // Finalizar el juego con empate
                jugando = false; // Detener el ciclo
                return;
            }

            // Cambiar turno al otro jugador
            switchTurn();
        }
    }
}



