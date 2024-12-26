package org.example;
import java.util.List;

public interface BoardInterface {
    /**
     * Verifica si aun se puede jugar en el tablero.
     *
     * @return {@code true} si hay posiciones disponibles, {@code false} en caso contrario.
     */
    boolean canPlay();

    /**
     * Coloca una ficha en la columna especificada.
     *
     * @param columna Indice de la columna (1 a columnas).
     * @param piece   Ficha a colocar en el tablero.
     * @return {@code true} si se coloco con éxito, {@code false} si la columna está llena
     */
    boolean placePiece(int columna, Piece piece);

    /**
     * Imprime el estado actual del tablero en consola
     */
    void printBoard();

    /**
     * Verifica si hay un ganador con una victoria vertical.
     *
     * @return El color del ganador si hay una victoria, {@code null} si no hay ganador.
     */
    String verticalWin();

    /**
     * Verifica si hay un ganador con una victoria horizontal.
     *
     * @return El color del ganador si hay una victoria, {@code null} si no hay ganador.
     */
    String horizontalWin();

    /**
     * Verifica si hay un ganador con una victoria diagonal.
     *
     * @return El color del ganador si hay una victoria, {@code null} si no hay ganador.
     */
    String diagonalWin();

    /**
     * Determina si hay un ganador verificando todas las posibles condiciones de victoria.
     *
     * @return El color del ganador si hay una victoria, {@code null} si no hay ganador.
     */
    String entregarGanador();


}

