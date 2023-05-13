package org.example;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String greeting = "Welcome into Polish Draughts!";
        System.out.println(greeting);

        Scanner scanner = new Scanner(System.in);
        System.out.print(" Please choose board size: ");
        int size = Integer.parseInt(scanner.nextLine()); //next int i try catch

        if (10 < size && size < 20) {
            Board board = new Board(size);
            System.out.println(Arrays.deepToString(board.getBoard()));
        } else {
            System.out.print("Wrong board size, choose size between 10 and 20");
        }
    }
}