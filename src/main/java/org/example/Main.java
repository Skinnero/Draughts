package org.example;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String greeting = "Welcome into Polish Draughts!";
        System.out.println(greeting);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please choose board size: ");
        int size = Integer.parseInt(scanner.nextLine());


        // TODO: ADD EXCEPTION WHEN PROVIDED STRING INSTEAD OF NUMBERS
        // TODO: LOOP
        if (10 < size && size < 20) {
        } else {
            System.out.print("Wrong board size, choose size between 10 and 20");
        }

        Board board = new Board(size);
        System.out.println(Arrays.deepToString(board.getBoard()));
            board.getBoard();



        System.out.println("Enter first player name: ");
        String name = scanner.nextLine();
        Player player_1 = new Player(1, name);

        System.out.println("Enter second player name: ");
        name = scanner.nextLine();
        Player player_2 = new Player(2, name);

        Player playerInGame = player_1;

        boolean gameOn = true;

        board.fillBoardWithPawns(player_1, player_2);

        while (gameOn) {
            // TODO: GET COORDINATES FROM PLAYER
            System.out.println("Please provide coordinates in format (a1 b2): ");
            // TODO: isValidFormat, isInBounds, coordinatesInterpreter
            break;
        }
    }


}