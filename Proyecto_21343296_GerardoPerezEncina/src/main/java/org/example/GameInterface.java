package org.example;

import java.util.Scanner;

/**
 * Interfaz que define los métodos esenciales para la gestión de un juego.
 */
public interface GameInterface {

    /**
     * Muestra el historial de movimientos del juego.
     */
    void showHistory();

    /**
     * Verifica si el estado actual del juego es un empate.
     *
     * @return {@code true} si el juego termina en empate, {@code false} en caso contrario.
     */
    boolean esEmpate();

    /**
     * Obtiene el jugador que tiene el turno actualmente.
     *
     * @return El jugador actual.
     */
    Player getCurrentPlayer();

    /**
     * Muestra el estado actual del tablero en consola.
     */
    void boardGetState();

    /**
     * Finaliza el juego actualizando las estadísticas de los jugadores según el resultado.
     *
     * @param resultado El resultado del juego ("victoria" o "empate").
     * @param ganador   El jugador que ganó, o cualquiera de los jugadores en caso de empate.
     * @param perdedor  El jugador que perdió, o cualquiera de los jugadores en caso de empate.
     */
    void endGame(String resultado, Player ganador, Player perdedor);

    /**
     * Cambia el turno al siguiente jugador.
     */
    void switchTurn();

    /**
     * Permite a un jugador realizar un movimiento en el tablero.
     *
     * @param scanner El objeto {@link Scanner} para leer la entrada del jugador.
     */
    void realizarMovimiento(Scanner scanner);


}
