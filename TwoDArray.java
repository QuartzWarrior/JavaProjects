import java.util.Scanner;

public class TwoDArray {
    public static void main(String[] args) {
        double[][] matrix = new double[3][4];

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3x4 matrix:");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }

        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int j = 0; j < matrix[0].length; j++) {
            double sum = sumColumn(matrix, j);
            System.out.println("Sum of column " + j + ": " + sum);
        }

        matrix = new double[3][4];
        System.out.println("Enter a 3x4 matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            double sum = sumColumn(matrix, j);
            System.out.println("Sum of column " + j + ": " + sum);
        }

        randomOs(args);

        System.out.println("Enter a 3x4 matrix for locating largest element:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        int[] largestLocation = locateLargest(matrix);
        System.out.println("Largest element is at: " + largestLocation[0] + " " + largestLocation[1]);

        int[][] intMatrix = new int[3][3];
        System.out.println("Enter a 3x3 matrix for diagonal sum:");
        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix[i].length; j++) {
                intMatrix[i][j] = input.nextInt();
            }
        }
        int diagonalSum = diagSum(intMatrix);
        System.out.println("Diagonal sum: " + diagonalSum);

        input.close();
    }

    public static double sumColumn(double[][] m, int columnindex) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][columnindex];
        }
        return sum;
    }

    public static void randomOs(String[] args) {
        int[][] matrix = new int[4][4];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 2);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int maxRow = 0;
        int maxColumn = 0;
        int maxRowCount = 0;
        int maxColumnCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            int rowCount = 0;
            int columnCount = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    rowCount++;
                }
                if (matrix[j][i] == 1) {
                    columnCount++;
                }
            }

            if (rowCount > maxRowCount) {
                maxRowCount = rowCount;
                maxRow = i;
            }

            if (columnCount > maxColumnCount) {
                maxColumnCount = columnCount;
                maxColumn = i;
            }
        }

        System.out.println("Row with the most 1s: " + maxRow);
        System.out.println("Column with the most 1s: " + maxColumn);
    }

    public static int[] locateLargest(double[][] a) {
        int[] location = { 0, 0 };
        double largest = a[0][0];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > largest) {
                    largest = a[i][j];
                    location[0] = i;
                    location[1] = j;
                }
            }
        }

        return location;

    }

    public static int diagSum(int[][] array) {
        int sum = 0;
        int rows = array.length;
        int columns = array[0].length;

        for (int i = 0; i < Math.min(rows, columns); i++) {
            sum += array[i][i];
        }

        return sum;
    }

}
