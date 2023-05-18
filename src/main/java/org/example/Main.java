package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome into Polish Draughts!");
        int boardSize;
        Scanner scanner = new Scanner(System.in);
        UserInputs userInputs = new UserInputs();
        boardSize = userInputs.chooseSize();
        Board board = new Board(boardSize);

        System.out.print("Enter first player name: ");
        String name = scanner.nextLine();
        Player player_1 = new Player(1, name, 1, "\u001B[34m");

        System.out.print("Enter second player name: ");
        name = scanner.nextLine();
        Player player_2 = new Player(2, name, 1, "\u001B[31m");

        Player playerInGame = player_1;
        board.fillBoardWithPawns(board, player_1, player_2);
        boolean gameOn = true;
        userInputs = new UserInputs();

        while (gameOn) {

            System.out.println("Now is moving: " + playerInGame.getColor() + playerInGame.getName() + "\u001B[0m");
            board.printBoard(board);
            List<int[]> transformedCoordinates = userInputs.getCoordinates(boardSize);

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
                        !board.isOccupied(transformedCoordinates.get(1)) &&
                        attackedPawns.size() == 1) {
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
        System.out.println(playerInGame.getColor() + playerInGame.getName() + "\u001B[0m" + " has won!");
    }
}