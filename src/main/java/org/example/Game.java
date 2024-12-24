package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private int fichasPorJugador;
    public List<String> historial;
    private Piece colorPlayer1;
    private Piece colorPlayer2;

    public Game(int filas, int columnas, int fichasPorJugador, Player player1, Player player2){
        this.board = new Board(filas, columnas);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.fichasPorJugador = fichasPorJugador;
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
}