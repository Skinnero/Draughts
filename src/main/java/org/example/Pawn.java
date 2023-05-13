package org.example;

public class Pawn {

    private int[] coordinates;

    private final Player player;

    private boolean isCrowned = false;

    public Pawn(int[] coordinates, Player player) {
        this.coordinates = coordinates;
        this.player = player;
    }

    public boolean isValidMovementForPawn(int[] designedCoordinates) {
        return Math.abs(coordinates[0] - designedCoordinates[0]) == 1 &&
        Math.abs(coordinates[1] - designedCoordinates[1]) == 1;
    }

    public boolean isValidAttackForPawn(int[] designedCoordinates) {
        return Math.abs(coordinates[0] - designedCoordinates[0]) == 2 &&
                Math.abs(coordinates[1] - designedCoordinates[1]) == 2;
    }

    public boolean isValidMoveForCrownedPawn(int[] designedCoordinates) {
        return Math.abs(coordinates[0] - designedCoordinates[0]) == Math.abs(coordinates[1] - designedCoordinates[1]);
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public Player getPlayer() {
        return player;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void setCrowned(boolean crowned) {
        isCrowned = crowned;
    }

    public boolean isCrowned() {
        return isCrowned;
    }
}
