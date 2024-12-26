package org.example;

/**
 * Clase que representa a un jugador en el juego Conecta 4.
 * Cada jugador tiene atributos como su identificador, nombre, color, victorias, derrotas, empates y fichas restantes.
 */
public class Player implements PlayerInterface {
    private int id;
    private String name;
    private String color;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;

    /**
     * Constructor para inicializar un jugador con sus atributos.
     *
     * @param nId            Identificador único del jugador.
     * @param nName          Nombre del jugador.
     * @param nColor         Color asociado al jugador.
     * @param nWins          Número inicial de victorias.
     * @param nLosses        Número inicial de derrotas.
     * @param nDraws         Número inicial de empates.
     * @param nRemainingPieces Número inicial de fichas disponibles.
     */
    public Player(int nId, String nName, String nColor, int nWins, int nLosses, int nDraws, int nRemainingPieces) {
        this.id = nId;
        this.name = nName;
        this.color = nColor;
        this.wins = nWins;
        this.losses = nLosses;
        this.draws = nDraws;
        this.remainingPieces = nRemainingPieces;
    }

    /**
     * Actualiza las estadísticas del jugador y del oponente según el resultado del juego.
     *
     * @param otroJugador El jugador contrario en el juego.
     * @param resultado   Resultado del juego ("victoria" o "empate").
     */
    @Override
    public void actualizarStats(Player otroJugador, String resultado) {
        if (resultado.equals("victoria")) {
            this.wins += 1;  // Incrementar victorias del jugador actual.
            otroJugador.losses += 1;  // Incrementar derrotas del otro jugador.
        } else if (resultado.equals("empate")) {
            this.draws += 1;  // Incrementar empates del jugador actual.
            otroJugador.draws += 1;  // Incrementar empates del otro jugador.
        }
    }


    /**
     * Obtiene el nombre del jugador.
     *
     * @return El nombre del jugador.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Obtiene el color asociado al jugador.
     *
     * @return El color del jugador.
     */
    @Override
    public String getColor() {
        return color;
    }


    /**
     * Obtiene el número de victorias del jugador.
     *
     * @return Número de victorias.
     */
    @Override
    public int getWins() {
        return wins;
    }


    /**
     * Obtiene el número de derrotas del jugador.
     *
     * @return Número de derrotas.
     */
    @Override
    public int getLosses() {
        return losses;
    }


    /**
     * Obtiene el número de empates del jugador.
     *
     * @return Número de empates.
     */
    @Override
    public int getDraws() {
        return draws;
    }

    /**
     * Obtiene el número de fichas restantes del jugador.
     *
     * @return Número de fichas restantes.
     */
    @Override
    public int getRemainingPieces() {
        return remainingPieces;
    }

    /**
     * Establece el número de fichas restantes para el jugador.
     *
     * @param remainingPieces Nuevo número de fichas restantes.
     */
    @Override
    public void setRemainingPieces(int remainingPieces) {
        this.remainingPieces = remainingPieces;
    }
}
