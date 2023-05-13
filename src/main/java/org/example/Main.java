package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome into Polish Draughts!");
        int boardSize;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please choose board size: ");
            try {
                boardSize = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Provide valid number!");
                continue;
            }

            if (10 <= boardSize && boardSize <= 20) {
                break;
            } else {
                System.out.println("Wrong board size, choose size between 10 and 20");
            }
        }
        Board board = new Board(boardSize);
        System.out.println(Arrays.deepToString(board.getBoard()));
        // board.fillBoardWithPawns()

        System.out.print("Enter first player name: ");
        String name = scanner.nextLine();
        Player player_1 = new Player(1, name, boardSize * 2, "\u001B[31m");

        System.out.print("Enter second player name: ");
        name = scanner.nextLine();
        Player player_2 = new Player(2, name, boardSize * 2, "\u001B[34m");

        Player playerInGame = player_1;

        boolean gameOn = true;


        while (gameOn) {
            // TODO: Change comments to english
            //ponieranie koordynat
            System.out.println("Now is moving: " + playerInGame.getColor() + playerInGame.getName() + "\u001B[0m");
            // board.printBoard()
            System.out.println("Enter coordinates. For example: (a3 b4) or (c1 e3 c5)");
            String coordinatesString = scanner.nextLine();
            // TODO: Change this into function
            try {
                // splitowanie
                String[] coordinatesPreParts = coordinatesString.split(" ");
                ArrayList<String> coordinates = new ArrayList<>(Arrays.asList(coordinatesPreParts));
                // translator
                int[][] transformedCoordinates = translateCoordinates(coordinates);
                System.out.println(Arrays.deepToString(transformedCoordinates));


            } catch (Exception e) {
                System.out.println("Invalid coordinates");
            }
            //

            //playerInGame = playerInGame == player_1 ? player_2 : player_1;
            break;
        }
    }

    public static int[][] translateCoordinates(ArrayList<String> coordinates) {
        //translator
        int[][] result = new int[coordinates.size()][2];
        for (int i = 0; i < coordinates.size(); i++) {
            String coordinate = coordinates.get(i);
            String letter = coordinate.substring(0, 1);
            int number = Integer.parseInt(coordinate.substring(1));
            int x = letter.toLowerCase().charAt(0) - 'a';
            result[i][0] = x;
            result[i][1] = number;
        }
        return result;
    }

    public boolean isInBounds(int[] coordinates, int size) {
        // sprwadzenie czy koorddynaty są w planszy
        return coordinates[0] >= size && coordinates[1] >= size;
    }

}
