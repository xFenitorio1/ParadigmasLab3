package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game implements GameInterface{
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    public List<String> historial;
    private Piece colorPlayer1;
    private Piece colorPlayer2;

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

    public void showHistory() {
        System.out.println("\n### Historial de Movimientos ###");
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }

    public boolean esEmpate() {
        // Verificar si el tablero tiene posiciones disponibles
        boolean tableroLleno = !board.canPlay();


        boolean sinFichas = (player1.getRemainingPieces() == 0 && player2.getRemainingPieces() == 0);


        return tableroLleno || sinFichas;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void boardGetState() {
        System.out.println("\n### Estado Actual del Tablero ###");
        board.printBoard(); // Llama a la función existente en la clase Board
    }


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
}



