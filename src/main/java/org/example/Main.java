package org.example;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String greeting = "Welcome into Polish Draughts!";
        System.out.println(greeting);
        int size = 0;
    while (true) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose board size: ");
        try {
            size = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Provide valid number");
            continue;
        }

        if (10 < size && size < 20) {
            break;
        } else {
            System.out.println("Wrong board size, choose size between 10 and 20");
        }
    }
        Board board = new Board(size);
        System.out.println(Arrays.deepToString(board.getBoard()));
        board.getBoard();




//        System.out.println("Enter first player name: ");
//        String name = scanner.nextLine();
//        Player player_1 = new Player(1, name);
//
//        System.out.println("Enter second player name: ");
//        name = scanner.nextLine();
//        Player player_2 = new Player(2, name);
//
//        Player playerInGame = player_1;

        boolean gameOn = true;


        while (gameOn) {
            // TODO: GET COORDINATES FROM PLAYER
            System.out.println("Please provide coordinates in format (a1 b2): ");
            // TODO: isValidFormat, isInBounds, coordinatesInterpreter
            break;
        }
    }


}