package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {
    public int length;
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
    // TODO: (KACPER) movePawn(), removePawn()
    public boolean isOccupied(int[] designedCoordinates) {
        return !Objects.isNull(boardField[designedCoordinates[0]][designedCoordinates[1]]);
    }
    public List<Pawn> isLegalMove(Pawn pawn, int[] designedCoordinates) {
        List<Pawn> attackedPawns = new ArrayList<>();
        int vectorX = designedCoordinates[0] - pawn.getCoordinates()[0];
        int vectorY = designedCoordinates[1] - pawn.getCoordinates()[1];

        vectorX = vectorX < 0 ? -1 : 1;
        vectorY = vectorY < 0 ? -1 : 1;

        while (pawn.getCoordinates()[0] + vectorX != designedCoordinates[0] &&
                pawn.getCoordinates()[1] + vectorY != designedCoordinates[1]) {

            int[] inBetweenCoordinates = {pawn.getCoordinates()[0] + vectorX, pawn.getCoordinates()[1] + vectorY};

            if (isOccupied(inBetweenCoordinates)) {
                if (boardField[inBetweenCoordinates[0]][inBetweenCoordinates[1]].getPlayer()
                        .getId() == pawn.getPlayer().getId()) {
                    return attackedPawns;
                }
                attackedPawns.add(boardField[inBetweenCoordinates[0]][inBetweenCoordinates[1]]);
            }

            if (attackedPawns.size() == 2) {
                return attackedPawns;
            }

            vectorX = vectorX < 0 ? vectorX - 1 : vectorX + 1;
            vectorY = vectorY < 0 ? vectorY - 1 : vectorY + 1;
        }
        return attackedPawns;
    }
    public Pawn getPawn(int[] pawnCoordinates, Player player) {
        try {
            if (boardField[pawnCoordinates[0]][pawnCoordinates[1]].getPlayer().getId() == player.getId()) {
                return boardField[pawnCoordinates[0]][pawnCoordinates[1]];
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public boolean isDesignedCoordinatesOccupied(int[] designedCoordinates) {
        return !Objects.isNull(boardField[designedCoordinates[0]][designedCoordinates[1]]);
    }

    public void fillBoardWithPawns(Board board,Player player1, Player player2) {
        int displacement = 0;
        for (int i = board.getBoardSize()-1; i > board.getBoardSize()/2; i--) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                if (((j + displacement) % 2)  == 1) {
                    board.getBoard()[i][j] = new Pawn(new int[]{i, j}, player1);
                } else {
                    board.getBoard()[i][j] = null;
                }
            }
            displacement ++;

        }
        displacement = 0;
        for (int i = 0; i < (board.getBoardSize()/2)-1; i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                if (((j + displacement) % 2)  == 0) {
                    board.getBoard()[i][j] = new Pawn(new int[]{i, j}, player2);
                }
            }
            displacement ++;
        }
    }
}