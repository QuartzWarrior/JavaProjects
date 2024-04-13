package Battleship;
import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        Board playerOneBoard = new Board();
        Board playerTwoBoard = new Board();
        Scanner scanner = new Scanner(System.in);
        String[] ships = { "Carrier", "BattleShip", "Cruiser", "Submarine", "Patrol Boat" };
        int[] shipLength = { 5, 4, 3, 3, 2 };

        System.out.println("Player 1, place your ships:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter startRow, startCol, isHorizontal for the " + ships[i] + ", which has a length of "
                    + shipLength[i]);
            int size = shipLength[i];
            int startRow = scanner.nextInt();
            int startCol = scanner.nextInt();
            boolean isHorizontal = scanner.nextBoolean();
            while (!playerOneBoard.addShip(size, startRow, startCol, isHorizontal, i)) {
                System.out.println("Invalid position. Enter startRow, startCol, isHorizontal for the " + ships[i]
                        + ", which has a length of " + shipLength[i]);
                size = scanner.nextInt();
                startRow = scanner.nextInt();
                startCol = scanner.nextInt();
                isHorizontal = scanner.nextBoolean();
            }
            playerOneBoard.printShipBoard();
        }

        System.out.println("Player 2, place your ships:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter startRow, startCol, isHorizontal for the " + ships[i] + ", which has a length of "
                    + shipLength[i]);
            int size = shipLength[i];
            int startRow = scanner.nextInt();
            int startCol = scanner.nextInt();
            boolean isHorizontal = scanner.nextBoolean();
            while (!playerTwoBoard.addShip(size, startRow, startCol, isHorizontal, i)) {
                System.out.println("Invalid position. Enter startRow, startCol, isHorizontal for the " + ships[i]
                        + ", which has a length of " + shipLength[i]);
                size = scanner.nextInt();
                startRow = scanner.nextInt();
                startCol = scanner.nextInt();
                isHorizontal = scanner.nextBoolean();
            }
            playerTwoBoard.printShipBoard();
        }

        while (!playerOneBoard.gameOver() && !playerTwoBoard.gameOver()) {
            System.out.println("Player 1, attack a space:");
            System.out.println("Enter row and col to attack");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (playerTwoBoard.fire(row, col)) {
                System.out.println("Hit!");
            } else {
                System.out.println("Miss!");
            }
            playerTwoBoard.sunkShips();
            playerTwoBoard.printAttackBoard();

            if (playerTwoBoard.gameOver()) {
                System.out.println("Player One Wins!");
                break;
            }

            System.out.println("Player 2, attack a space:");
            System.out.println("Enter row and col to attack");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (playerOneBoard.fire(row, col)) {
                System.out.println("Hit!");
            } else {
                System.out.println("Miss!");
            }
            playerOneBoard.sunkShips();
            playerOneBoard.printAttackBoard();

            if (playerOneBoard.gameOver()) {
                System.out.println("Player Two Wins!");
                break;
            }
        }

        System.out.println("Game over! All ships have been sunk.");

        scanner.close();
    }
}