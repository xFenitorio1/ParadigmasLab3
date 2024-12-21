package org.example;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private int filas; // Número de filas del tablero
    private int columnas; // Número de columnas del tablero
    private List<List<Character>> tablero; // Tablero representado como lista de listas

    public Board(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        tablero = new ArrayList<>(columnas);


        for (int col = 0; col < columnas; col++) {
            List<Character> columna = new ArrayList<>(filas);
            for (int fila = 0; fila < filas; fila++) {
                columna.add('0');
            }
            tablero.add(columna);
        }
    }

    public void printBoard() {
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                System.out.print("| " + tablero.get(col).get(fila) + " ");
            }
            System.out.println("|");
        }
        System.out.print("  ");
        for (int col = 1; col <= columnas; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
    }
    //La idea es usar esta funcion despues de que cada pieza se coloque
    //lo mismo con check vertical, horizontal y diagonal.
    public boolean canPlay() {
        for (List<Character> columna : tablero) {
            if (columna.get(0) == '0') { // Verificar si la primera fila está vacía en alguna columna
                return true;
            }
        }
        return false;
    }

    // Getters
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public List<List<Character>> getTablero() {
        return tablero;
    }
}
