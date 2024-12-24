package org.example;

public class Player implements PlayerInterface {
    private int id;
    private String name;
    private String color;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;

    public Player(int nId, String nName, String nColor, int nWins, int nLosses, int nDraws, int nRemainingPieces) {
        this.id = nId;
        this.name = nName;
        this.color = nColor;
        this.wins = nWins;
        this.losses = nLosses;
        this.draws = nDraws;
        this.remainingPieces = nRemainingPieces;
    }

    public void actualizarStats(Player otroJugador, String resultado) {
        if (resultado.equals("victoria")) {
            this.wins += 1;  // Incrementar las victorias del jugador actual
            otroJugador.losses += 1;  // Incrementar las derrotas del otro jugador
        }
        else if (resultado.equals("empate")) {
            this.draws += 1;
            otroJugador.draws += 1;  // Incrementar los empates del otro jugador
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public int getWins() {

        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getRemainingPieces() {
        return remainingPieces;
    }

    public void setRemainingPieces(int remainingPieces) {
        this.remainingPieces = remainingPieces;
    }
}
