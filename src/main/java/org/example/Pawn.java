package org.example;

public class Pawn {

    int[] coordinates;

    Player player;

    boolean isCrowned = false;

    public Pawn(int[] coordinates, Player player) {
        this.coordinates = coordinates;
        this.player = player;
    }
    // TODO: Setter to isCrowned, coordinates| ValidMovement, getPawn, ValidAttack

    public int[] getCoordinates() {
        return coordinates;
    }

    public Player getPlayer() {
        return player;
    }
}
