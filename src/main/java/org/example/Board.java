package org.example;


public class Board {
    private int[][] board;
    private int size;

    public Board(int boardSize) {
        board = new int[boardSize][boardSize];
    }

    public int[][] getBoard() {
        return board;
    }
    public int getBoardSize() {
        return size;
    }
}