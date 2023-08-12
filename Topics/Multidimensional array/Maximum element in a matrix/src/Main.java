import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] arrayInt = new int[n][m];

        int maxNumber = Integer.MIN_VALUE;
        String indexMax = " ";

        for (int i = 0; i < arrayInt.length; i++) {
            for (int j = 0; j < arrayInt[i].length; j++) {
                arrayInt[i][j] = scanner.nextInt();
                if (arrayInt[i][j] > maxNumber) {
                    maxNumber = arrayInt[i][j];
                    indexMax = i + " " + j;
                }
            }
        }

        System.out.println(indexMax);
    }
}