package org.example;

import java.util.ArrayList;
import java.util.List;


public class Board {
    private int filas;
    private int columnas;
    private List<List<Character>> tablero;

    public Board(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        tablero = new ArrayList<>();

        for (int i = 0; i < filas; i++) {
            List<Character> row = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                row.add('0');
            }
            tablero.add(row);
        }
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public void printBoard() {
        for (List<Character> row : tablero) {
            for (Character cell : row) {
                System.out.print("| " + cell + " ");
            }
            System.out.println("|");
        }
    }
}
