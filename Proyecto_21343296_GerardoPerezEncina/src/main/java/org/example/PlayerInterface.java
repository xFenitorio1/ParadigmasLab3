package org.example;

public interface PlayerInterface     {
    /**
     * Actualiza las estadísticas del jugador en función del resultado del juego.
     *
     * @param otroJugador El jugador contrario cuyas estadísticas también se actualizarán.
     * @param resultado   El resultado del juego ("victoria" o "empate").
     */
    void actualizarStats(Player otroJugador, String resultado);



    /**
     * Obtiene el nombre del jugador.
     *
     * @return El nombre del jugador.
     */
    String getName();


    /**
     * Obtiene el color del jugador.
     *
     * @return El color del jugador.
     */
    String getColor();


    /**
     * Obtiene el número de victorias del jugador.
     *
     * @return El número de victorias.
     */
    int getWins();


    /**
     * Obtiene el número de derrotas del jugador.
     *
     * @return El número de derrotas.
     */
    int getLosses();

    /**
     * Obtiene el número de empates del jugador.
     *
     * @return El número de empates.
     */
    int getDraws();


    /**
     * Obtiene el número de fichas restantes del jugador.
     *
     * @return El número de fichas restantes.
     */
    int getRemainingPieces();

    /**
     * Establece el número de fichas restantes del jugador.
     *
     * @param remainingPieces El número de fichas restantes.
     */
    void setRemainingPieces(int remainingPieces);
}
