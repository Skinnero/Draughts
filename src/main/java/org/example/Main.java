package org.example;
import java.util.ArrayList;
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
            //ponieranie koordynat
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter coordinates. For example a3-b4 or c1-e3-c5");
            String coordinatesString = (scanner.nextLine());
            try {
                // splitowanie
                String[] coordinatesPreParts = coordinatesString.split("-");
                ArrayList<String> coordinates = new ArrayList<>();
                for (String part : coordinatesPreParts) {
                    coordinates.add(part);
                }
                // translator
                int[][] transformedCoordinates = translateCoordinates(coordinates);
                System.out.println(Arrays.deepToString(transformedCoordinates));

            } catch (Exception e) {
                System.out.println("Invalid coordinates");
            }
            System.out.println("Please provide coordinates in format (a1 b2): ");
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
            if (coordinates[0] >= size && coordinates[1] >= size) {
                return true;
            }
            return false;


    }

}
