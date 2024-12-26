package org.example;

/**
 * Clase que representa una ficha del juego Conecta 4.
 * Cada ficha tiene un color asociado, el cual identifica al jugador al que pertenece.
 */
public class Piece implements PieceInterface{
    /**
     * Color de la ficha, utilizado para identificar al jugador.
     */
    private String color;

    /**
     * Constructor para inicializar una ficha con un color específico.
     *
     * @param color El color de la ficha. Por ejemplo, "Rojo" o "Amarillo".
     */
    public Piece(String color) {
        this.color = color;
    }

    /**
     * Obtiene el color de la ficha.
     *
     * @return El color de la ficha como una cadena de texto.
     */
    @Override
    public String getColor() {
        return color;
    }
}
