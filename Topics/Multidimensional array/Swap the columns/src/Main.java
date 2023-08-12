import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int column = scanner.nextInt();

        int[][] matrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int column1 = scanner.nextInt();
        int column2 = scanner.nextInt();

        int[] tempMatrix = new int[row];

        for (int i = 0; i < row; i++) {
            tempMatrix[i] = matrix[i][column1];
            matrix[i][column1] = matrix[i][column2];
            matrix[i][column2] = tempMatrix[i];
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
