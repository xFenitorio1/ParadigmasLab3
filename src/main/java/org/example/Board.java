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

        // Inicializar el tablero con '0' para representar espacios vacíos
        for (int col = 0; col < columnas; col++) {
            List<Character> columna = new ArrayList<>(filas);
            for (int fila = 0; fila < filas; fila++) {
                columna.add('0'); // '0' representa espacio vacío
            }
            tablero.add(columna);
        }
    }

    public boolean placePiece(int columna, Piece piece) {
        int columnaInterna = columna - 1;
        if (columnaInterna < 0 || columnaInterna >= columnas) {
            throw new IllegalArgumentException("Columna fuera de rango");
        }
        char ficha = piece.getColor().charAt(0);

        List<Character> columnaSeleccionada = tablero.get(columnaInterna);
        for (int fila = filas - 1; fila >= 0; fila--) {
            if (columnaSeleccionada.get(fila) == '0') {
                columnaSeleccionada.set(fila, ficha);
                return true;
            }
        }
        return false;
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

    public boolean canPlay() {
        for (List<Character> columna : tablero) {
            if (columna.get(0) == '0') { // Verificar si la primera fila está vacía en alguna columna
                return true;
            }
        }
        return false;
    }

    public String verticalWin() {
        for (int col = 0; col < columnas; col++) {
            int contador = 1;
            char anterior = '0';
            for (int fila = filas - 1; fila >= 0; fila--) {
                char actual = tablero.get(col).get(fila);
                if (actual != '0' && actual == anterior) {
                    contador++;
                    if (contador == 4) {
                        return String.valueOf(actual); // Ganador encontrado
                    }
                }
                else {
                    contador = 1; // Reinicia el contador
                }
                anterior = actual;
            }
        }
        return null; // No hay ganador
    }

    public String horizontalWin(){
        for (int fila = filas - 1; fila >= 0; fila--){
            int contador = 1;
            char anterior = '0';
            for (int col = 0; col < columnas ; col++){
                char actual = tablero.get(col).get(fila);
                if (actual != '0' && actual == anterior){
                    contador++;
                    if (contador == 4){
                        return String.valueOf(actual);
                    }
                }
                else{
                    contador = 1;
                }
                anterior = actual;
            }
        }
        return null;
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
