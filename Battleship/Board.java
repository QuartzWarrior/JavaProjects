package Battleship;
public class Board {
    private char[][] shipBoard;
    private char[][] attackBoard;

    public Board() {
        shipBoard = new char[11][11];
        attackBoard = new char[11][11];

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                shipBoard[i][j] = '-';
                attackBoard[i][j] = '-';
            }
        }
    }

    public boolean addShip(int size, int startRow, int startCol, boolean isHorizontal, int placement) {
        char letter = '-';
        if (size == 5) {
            letter = 'C';
        } else if (size == 4) {
            letter = 'B';
        } else if (size == 3 && placement == 2) {
            letter = 'D';
        } else if (size == 3) {
            letter = 'S';
        } else if (size == 2) {
            letter = 'P';
        }
        if (isHorizontal) {
            if (startCol + size > 11)
                return false;
            for (int i = startCol; i < startCol + size; i++) {
                if (shipBoard[startRow][i] != '-')
                    return false;
            }
            for (int i = startCol; i < startCol + size; i++) {
                shipBoard[startRow][i] = letter;
            }
        } else {
            if (startRow + size > 11)
                return false;
            for (int i = startRow; i < startRow + size; i++) {
                if (shipBoard[i][startCol] != '-')
                    return false;
            }
            for (int i = startRow; i < startRow + size; i++) {
                shipBoard[i][startCol] = letter;
            }
        }
        return true;
    }

    public boolean fire(int row, int col) {
        if (shipBoard[row][col] != '-') {
            attackBoard[row][col] = 'X';
            shipBoard[row][col] = Character.toLowerCase(shipBoard[row][col]);
            return true;
        } else {
            attackBoard[row][col] = 'M';
            return false;
        }
    }

    public void sunkShips() {
        String[] shipTypes = { "C", "B", "D", "S", "P" };
        for (String shipType : shipTypes) {
            boolean isSunk = true;
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    if (shipBoard[i][j] == shipType.charAt(0)) {
                        isSunk = false;
                        break;
                    }
                }
                if (!isSunk)
                    break;
            }
            if (isSunk)
                if (shipType.equals("C"))
                    System.out.println("Carrier has been sunk");
                else if (shipType.equals("B"))
                    System.out.println("Battleship has been sunk");
                else if (shipType.equals("D"))
                    System.out.println("Destroyer has been sunk");
                else if (shipType.equals("S"))
                    System.out.println("Submarine has been sunk");
                else if (shipType.equals("P"))
                    System.out.println("Patrol Boat has been sunk");
        }
    }

    public boolean gameOver() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (Character.isUpperCase(shipBoard[i][j]))
                    return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                sb.append(attackBoard[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void printShipBoard() {
        System.out.print("   ");
        for (int col = 0; col < 11; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < 11; row++) {
            if (row < 10) {
                System.out.print(row + "  ");
            } else {
                System.out.print(row + " ");
            }
            for (int col = 0; col < 11; col++) {
                System.out.print(shipBoard[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void printAttackBoard() {
        System.out.print("   ");
        for (int col = 0; col < 11; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < 11; row++) {
            if (row < 10) {
                System.out.print(row + "  ");
            } else {
                System.out.print(row + " ");
            }
            for (int col = 0; col < 11; col++) {
                System.out.print(attackBoard[row][col] + " ");
            }
            System.out.println();
        }
    }

}