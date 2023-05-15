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
            // TODO: (KACPER) MULTIPLE COORDINATES HANDLING
            System.out.println("Now is moving: " + playerInGame.getColor() + playerInGame.getName() + "\u001B[0m");
            Board.printBoard(board);
            System.out.println("Enter coordinates. For example: (a3 b4) or (c1 e3 c5)");
            String coordinatesString = scanner.nextLine();
            int[][] transformedCoordinates = transformCoordinates(coordinatesString);


            if (isInBounds(transformedCoordinates, boardSize)) {
                continue;
            }

            Pawn pickedPawn = board.getPawn(transformedCoordinates[0], playerInGame);
            if (Objects.isNull(pickedPawn)){
                continue;
            }

            if (pickedPawn.isCrowned()) {
                if (pickedPawn.isValidMoveForCrownedPawn(transformedCoordinates[1])) {
                    List<Pawn> attackedPawns = board.isLegalMove(pickedPawn, transformedCoordinates[1]);
                    if (attackedPawns.size() == 1) {
                        board.movePawn(pickedPawn, transformedCoordinates[1]);
                        board.removePawn(attackedPawns.get(0).getCoordinates());
                        pickedPawn.setCoordinates(transformedCoordinates[1]);
                    } else if (attackedPawns.size() == 0) {
                        board.movePawn(pickedPawn, transformedCoordinates[1]);
                        pickedPawn.setCoordinates(transformedCoordinates[1]);
                    }
                } else {
                    continue;
                }
            } else {
                if (pickedPawn.isValidMovementForPawn(transformedCoordinates[1])) {
                    board.movePawn(pickedPawn, transformedCoordinates[1]);
                    pickedPawn.setCoordinates(transformedCoordinates[1]);
                } else if (pickedPawn.isValidAttackForPawn(transformedCoordinates[1])) {
                    List<Pawn> attackedPawns = board.isLegalMove(pickedPawn, transformedCoordinates[1]);
                    board.movePawn(pickedPawn, transformedCoordinates[1]);
                    board.removePawn(attackedPawns.get(0).getCoordinates());
                    pickedPawn.setCoordinates(transformedCoordinates[1]);
                }
            }

            playerInGame = playerInGame == player_1 ? player_2 : player_1;
        }
    }

        public static int[][] translateCoordinates (ArrayList < String > coordinates) {
            //translating
            int[][] result = new int[coordinates.size()][2];
            for (int i = 0; i < coordinates.size(); i++) {
                String coordinate = coordinates.get(i);
                String letter = coordinate.substring(0, 1);
                int number = Integer.parseInt(coordinate.substring(1));
                int x = letter.toLowerCase().charAt(0) - 'a';
                result[i][0] = x;
                result[i][1] = number - 1;
            }
            return result;
        }

        public static boolean isInBounds (int[][] coordinates, int size){
            // checking are coordinates in board
            for (int i=0; i < coordinates.length; i++ ) {
                if (coordinates[i][1] > size-1) {
                    return true;
                }
            }
            return false;
        }

        public static int[][] transformCoordinates (String coordinatesString){
            try {
                // split coordinates
                String[] coordinatesPreParts = coordinatesString.split(" ");
                ArrayList<String> coordinates = new ArrayList<>(Arrays.asList(coordinatesPreParts));
                return translateCoordinates(coordinates);

            } catch (Exception e) {
                System.out.println("Invalid coordinates");
            }
            return new int[0][];
        }


}