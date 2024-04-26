import java.util.Scanner;

public class AddMatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of row of two matrix: ");
        int m = scanner.nextInt();
        System.out.println("Enter the number of column of two matrix: ");
        int n = scanner.nextInt();
        int firstArray[][] = new int[m][n];
        int secondArray[][] = new int[m][n];
        System.out.println("First Matrix");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter element a" + i + j + " :");          //Input first matrix
                firstArray[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Second Matrix");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter element a" + i + j + " :");        //Input second matrix
                secondArray[i][j] = scanner.nextInt();
            }
        }

        System.out.println("The result is");
        int resultMatrix[][] = addMatrix(firstArray, secondArray, m, n);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] addMatrix(int firstArray[][], int secondArray[][], int m, int n) {
        int sumArray[][] = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sumArray[i][j] = firstArray[i][j] + secondArray[i][j];
            }
        }
        return sumArray;
    }
}
