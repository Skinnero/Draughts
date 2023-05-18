package org.example;

import java.util.*;

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

        System.out.print("Enter first player name: ");
        String name = scanner.nextLine();
        Player player_1 = new Player(1, name, boardSize * 2, "\u001B[34m");

        System.out.print("Enter second player name: ");
        name = scanner.nextLine();
        Player player_2 = new Player(2, name, boardSize * 2, "\u001B[31m");

        Player playerInGame = player_1;
        board.fillBoardWithPawns(board, player_1, player_2);
        boolean gameOn = true;

        while (gameOn) {
            // TODO: REFACTORING
            System.out.println("Now is moving player: " + playerInGame.getColor() + playerInGame.getName() + "\u001B[0m");
            board.printBoard(board);
            System.out.println("Enter coordinates. For example: (a3 b4) or (c1 e3 c5)");
            String coordinatesString = scanner.nextLine();
            List<int[]> transformedCoordinates = transformCoordinates(coordinatesString);


            if (isInBounds(transformedCoordinates, boardSize)) {
                System.out.println("Coordinates out of bounds!");
                continue;
            }

            Pawn pickedPawn = board.getPawn(transformedCoordinates.get(0), playerInGame);
            if (Objects.isNull(pickedPawn)) {
                System.out.println("You picked wrong pawn!");
                continue;
            }

            boolean isCoordinatesInvalid = false;
            do {
                if (transformedCoordinates.size() >= 2 &&
                        pickedPawn.isValidMovementForPawn(transformedCoordinates.get(1))) {
                    board.movePawn(pickedPawn, transformedCoordinates.get(1));
                    pickedPawn.setCoordinates(transformedCoordinates.get(1));
                    break;
                }
                List<Pawn> attackedPawns = board.isLegalMove(pickedPawn, transformedCoordinates.get(1));
                if (pickedPawn.isValidMoveForCrownedPawn(transformedCoordinates.get(1)) &&
                        !board.isOccupied(transformedCoordinates.get(1)) &&
                        pickedPawn.isCrowned()) {
                    if (attackedPawns.size() == 1) {
                        board.movePawn(pickedPawn, transformedCoordinates.get(1));
                        board.removePawn(attackedPawns.get(0).getCoordinates());
                        pickedPawn.setCoordinates(transformedCoordinates.get(1));
                    } else if (attackedPawns.size() == 0) {
                        board.movePawn(pickedPawn, transformedCoordinates.get(1));
                        pickedPawn.setCoordinates(transformedCoordinates.get(1));
                    } else {
                        isCoordinatesInvalid = true;
                        break;
                    }
                } else if (pickedPawn.isValidAttackForPawn(transformedCoordinates.get(1)) &&
                        !board.isOccupied(transformedCoordinates.get(1))) {
                    board.movePawn(pickedPawn, transformedCoordinates.get(1));
                    board.removePawn(attackedPawns.get(0).getCoordinates());
                    pickedPawn.setCoordinates(transformedCoordinates.get(1));
                } else {
                    isCoordinatesInvalid = true;
                    break;
                }
                transformedCoordinates.remove(1);
            } while (transformedCoordinates.size() >= 2);

            if (isCoordinatesInvalid) {
                System.out.println("You have provided invalid coordinates!");
                continue;
            }

            if (player_1.isPlayerWin() || player_2.isPlayerWin()) {
                gameOn = false;
            }

            board.crownPawn(pickedPawn);
            playerInGame = playerInGame == player_1 ? player_2 : player_1;
        }
        System.out.println("GAME OVER!");
    }

    public static List<int[]> translateCoordinates(ArrayList<String> coordinates) {
        //translating
        List<int[]> result = new ArrayList<>();
        for (String coordinate : coordinates) {
            String letter = coordinate.substring(0, 1);
            int[] transformedCoordinates = new int[]{letter.toLowerCase().charAt(0) - 'a',
                    Character.getNumericValue(coordinate.charAt(1))};
            result.add(transformedCoordinates);
        }
        return result;
    }

    public static boolean isInBounds(List<int[]> coordinates, int size) {
        // checking are coordinates in board
        for (int[] coordinate : coordinates) {
            if (coordinate[1] >= size || coordinate[0] >= size)  {
                return true;
            }
        }
        return false;
    }

    public static List<int[]> transformCoordinates(String coordinatesString) {
        try {
            // split coordinates
            String[] coordinatesPreParts = coordinatesString.split(" ");
            ArrayList<String> coordinates = new ArrayList<>(Arrays.asList(coordinatesPreParts));
            return translateCoordinates(coordinates);

        } catch (Exception e) {
            System.out.println("Invalid coordinates");
        }
        return new ArrayList<>();
    }
}