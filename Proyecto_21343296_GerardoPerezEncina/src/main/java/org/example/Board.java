package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el tablero del juego Conecta 4.
 * Proporciona métodos para administrar el estado del tablero,
 * verificar victorias y realizar movimientos.
 */
public class Board implements BoardInterface{
    /**
     * Número de filas del tablero.
     */
    private int filas;

    /**
     * Número de columnas del tablero.
     */
    private int columnas;

    /**
     * Representación del tablero como una lista de listas de caracteres.
     * Cada celda contiene '0' (vacía) o un carácter que representa el color de una ficha.
     */
    private List<List<Character>> tablero;

    /**
     * Constructor que inicializa un tablero vacío.
     *
     * @param filas    Número de filas del tablero.
     * @param columnas Número de columnas del tablero.
     */
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

    /**
     * Verifica si aún se puede jugar en el tablero.
     *
     * @return {@code true} si hay posiciones disponibles, {@code false} en caso contrario.
     */
    @Override
    public boolean canPlay() {
        for (List<Character> columna : tablero) {
            if (columna.get(0) == '0') { // Verificar si la primera fila está vacía en alguna columna
                return true;
            }
        }
        return false;
    }

    /**
     * Coloca una ficha en la columna especificada.
     * La ficha se coloca en la posición más baja disponible.
     *
     * @param columna Índice de la columna (1 a columnas).
     * @param piece   Ficha a colocar en el tablero.
     * @return {@code true} si se colocó con éxito, {@code false} si la columna está llena.
     * @throws IllegalArgumentException Si la columna está fuera de rango.
     */
    @Override
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

    /**
     * Imprime el estado actual del tablero en consola.
     */
    @Override
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

    /**
     * Verifica si hay un ganador con una victoria vertical.
     *
     * @return El color del ganador si hay una victoria, {@code null} si no hay ganador.
     */
    @Override
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
                } else {
                    contador = 1; // Reinicia el contador
                }
                anterior = actual;
            }
        }
        return null; // No hay ganador
    }

    /**
     * Verifica si hay un ganador con una victoria horizontal.
     *
     * @return El color del ganador si hay una victoria, {@code null} si no hay ganador.
     */
    @Override
    public String horizontalWin() {
        for (int fila = filas - 1; fila >= 0; fila--) {
            int contador = 1;
            char anterior = '0';
            for (int col = 0; col < columnas; col++) {
                char actual = tablero.get(col).get(fila);
                if (actual != '0' && actual == anterior) {
                    contador++;
                    if (contador == 4) {
                        return String.valueOf(actual);
                    }
                } else {
                    contador = 1;
                }
                anterior = actual;
            }
        }
        return null;
    }

    /**
     * Verifica si hay un ganador con una victoria diagonal.
     *
     * @return El color del ganador si hay una victoria, {@code null} si no hay ganador.
     */
    @Override
    public String diagonalWin() {
        // Verificar las diagonales descendentes (de izquierda a derecha)
        for (int fila = 0; fila < filas - 3; fila++) {
            for (int col = 0; col < columnas - 3; col++) {
                char ficha = tablero.get(col).get(fila);
                if (ficha != '0' &&
                        ficha == tablero.get(col + 1).get(fila + 1) &&
                        ficha == tablero.get(col + 2).get(fila + 2) &&
                        ficha == tablero.get(col + 3).get(fila + 3)) {
                    return String.valueOf(ficha);
                }
            }
        }

        // Verificar las diagonales ascendentes (de izquierda a derecha)
        for (int fila = 3; fila < filas; fila++) {
            for (int col = 0; col < columnas - 3; col++) {
                char ficha = tablero.get(col).get(fila);
                if (ficha != '0' &&
                        ficha == tablero.get(col + 1).get(fila - 1) &&
                        ficha == tablero.get(col + 2).get(fila - 2) &&
                        ficha == tablero.get(col + 3).get(fila - 3)) {
                    return String.valueOf(ficha);
                }
            }
        }

        return null; // No se encontró ningún ganador en las diagonales
    }

    /**
     * Determina si hay un ganador verificando todas las posibles condiciones de victoria.
     *
     * @return El color del ganador si hay una victoria, {@code null} si no hay ganador.
     */
    @Override
    public String entregarGanador() {
        String verticalWinner = verticalWin();
        if (verticalWinner != null) {
            System.out.println("VICTORIA VERTICAL!!!\n");
            return verticalWinner;
        }

        String horizontalWinner = horizontalWin();
        if (horizontalWinner != null) {
            System.out.println("VICTORIA HORIZONTAL!!\n");
            return horizontalWinner;
        }

        String diagonalWinner = diagonalWin();
        if (diagonalWinner != null) {
            System.out.println("VICTORIA DIAGONAL!!\n");
            return diagonalWinner;
        }
        return null;
    }
}
