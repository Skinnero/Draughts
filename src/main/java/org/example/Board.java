package org.example;


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

    // EMOJIS
    // NUMBERS: "1\uFE0F⃣ 2\uFE0F⃣ 3\uFE0F⃣ 4\uFE0F⃣ 5\uFE0F⃣ 6\uFE0F⃣ 7\uFE0F⃣ 8\uFE0F⃣ 9\uFE0F⃣ \uD83D\uDD1F" +
    //            " 1\uFE0F⃣ 2\uFE0F⃣ 3\uFE0F⃣ 4\uFE0F⃣ 5\uFE0F⃣ 6\uFE0F⃣ 7\uFE0F⃣ 8\uFE0F⃣ 9\uFE0F⃣ \uD83D\uDD1F"
    // WHITE SQUARE: ⬜
    // BLACK SQUARE: 🔳
    // RED SQUARE: 🟥
    // BLUE SQUARE: 🟦
    //
    // TODO: FILL BOARD WITH PAWNS
    // TODO: PRINT OUT BOARD

    public void fillBoardWithPawns(Player player1, Player player2) {

//        boardField[1][2] = new Pawn({1,2}, player1) {
//        }
//        boardField[1][2] = null;
//        boardField[3][4] = new Pawn({x,y}, player2) {
//        }
//
//        boardField[1][2].getPlayer().getName();
    }

//    public void printBoard() {
//        for (int i = 0; i < boardSize; i++) {
//            System.out.println(boardField[i][i]);
//        }
//    }
//
// boardFields[1][2]
}