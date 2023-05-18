package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInputs {

    private final Scanner scanner;

    public UserInputs() {
        scanner = new Scanner(System.in);
    }

    public int chooseSize() {
        int boardSize = 0;
        while (true) {
            System.out.print("Please choose board size: ");
            try {
                boardSize = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Provide valid number!");
                continue;
            }

            if (10 <= boardSize && boardSize <= 20) {
                return boardSize;
            } else {
                System.out.println("Wrong board size, choose size between 10 and 20");
            }
        }
    }

    public List<int[]> getCoordinates(int boardSize) {
        while (true) {
            System.out.println("Enter coordinates. For example: (a3 b4) or (c1 e3 c5)");
            String coordinatesString = scanner.nextLine();
            List<int[]> transformedCoordinates = transformCoordinates(coordinatesString);
            if (!isInBounds(transformedCoordinates, boardSize) || transformedCoordinates.size() <= 1) {
                System.out.println("Invalid coordinates!");
                continue;
            }
            return transformedCoordinates;
        }
    }
    public List<int[]> translateCoordinates(ArrayList<String> coordinates) {
        //translating
        List<int[]> result = new ArrayList<>();
        for (String coordinate : coordinates) {
            String letter = coordinate.substring(0, 1);
            int[] transformedCoordinates = new int[]{letter.toLowerCase().charAt(0) - 'a',
                    Character.getNumericValue(coordinate.charAt(1)) - 1};
            result.add(transformedCoordinates);
        }
        return result;
    }

    public List<int[]> transformCoordinates(String coordinatesString) {
        try {
            // split coordinates
            String[] coordinatesPreParts = coordinatesString.split(" ");
            ArrayList<String> coordinates = new ArrayList<>(Arrays.asList(coordinatesPreParts));
            return translateCoordinates(coordinates);

        } catch (StringIndexOutOfBoundsException ignored) {}
        return new ArrayList<>();
    }
    public boolean isInBounds(List<int[]> coordinates, int size) {
        // checking are coordinates in board
        for (int[] coordinate : coordinates) {
            if (coordinate[1] >= size || coordinate[0] >= size) {
                return false;
            }
        }
        return true;
    }
}
