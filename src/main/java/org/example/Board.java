package org.example;


import java.util.Objects;

public class Board {
    private Pawn[][] boardField;
    private int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        boardField = new Pawn[boardSize][boardSize];
    }

    public Pawn[][] getBoard() {
        return boardField;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public boolean isOccupied(int[] designedCoordinates) {
        return !Objects.isNull(boardField[designedCoordinates[0]][designedCoordinates[1]]);
    }
    public boolean isLegalMove(Pawn pawn, int[] designedCoordinates) {
        int pawnCounter = 0;
        int vectorX = designedCoordinates[0] - pawn.getCoordinates()[0];
        int vectorY = designedCoordinates[1] - pawn.getCoordinates()[1];

        vectorX = vectorX < 0 ? -1 : 1;
        vectorY = vectorY < 0 ? -1 : 1;

        while (pawn.getCoordinates()[0] + vectorX != designedCoordinates[0] &&
                pawn.getCoordinates()[1] + vectorY != designedCoordinates[1]) {

            if (!Objects.isNull(boardField[pawn.getCoordinates()[0] + vectorX][pawn.getCoordinates()[1] + vectorY])) {
                if (boardField[pawn.getCoordinates()[0] + vectorX][pawn.getCoordinates()[1] + vectorY].getPlayer()
                        .getId() == pawn.getPlayer().getId()) {
                    return false;
                }
                pawnCounter++;
            }

            if (pawnCounter == 2) {
                return false;
            }

            vectorX = vectorX < 0 ? vectorX - 1 : vectorX + 1;
            vectorY = vectorY < 0 ? vectorY - 1 : vectorY + 1;
        }
        return true;
    }

    public boolean isDesignedCoordinatesOccupied(int[] designedCoordinates) {
        return !Objects.isNull(boardField[designedCoordinates[0]][designedCoordinates[1]]);
    }

}