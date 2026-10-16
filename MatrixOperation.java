
import java.util.Scanner;

public class MatrixOperation {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
            System.out.print("Enter rows and columns of Matrix A: ");
            int rowsA = scanner.nextInt();
            int colsA = scanner.nextInt();
            int[][] A = new int[rowsA][colsA];
            System.out.println("Enter elements of Matrix A:");
            for (int i = 0; i < rowsA; i++)
                for (int j = 0; j < colsA; j++)
                    A[i][j] = scanner.nextInt();
            
            System.out.print("Enter rows and columns of Matrix B: ");
            int rowsB = scanner.nextInt();
            int colsB = scanner.nextInt();
            int[][] B = new int[rowsB][colsB];
            System.out.println("Enter elements of Matrix B:");
            for (int i = 0; i < rowsB; i++)
                for (int j = 0; j < colsB; j++)
                    B[i][j] = scanner.nextInt();
            
            // ---- Addition ----
            if (rowsA == rowsB && colsA == colsB) {
                int[][] sum = new int[rowsA][colsA];
                for (int i = 0; i < rowsA; i++)
                    for (int j = 0; j < colsA; j++)
                        sum[i][j] = A[i][j] + B[i][j];
                
                System.out.println("\nSum of Matrix A and B:");
                printMatrix(sum);
            } else {
                System.out.println("\nAddition not possible: matrices must have the same dimensions.");
            }
            
            // ---- Multiplication ----
            if (colsA == rowsB) {
                int[][] product = new int[rowsA][colsB];
                for (int i = 0; i < rowsA; i++) {
                    for (int j = 0; j < colsB; j++) {
                        int sum = 0;
                        for (int k = 0; k < colsA; k++) {
                            sum += A[i][k] * B[k][j];
                        }
                        product[i][j] = sum;
                    }
                }
                
                System.out.println("\nProduct of Matrix A and B:");
                printMatrix(product);
            } else {
                System.out.println("\nMultiplication not possible: columns of A must equal rows of B.");
            }
        }
    

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    
}    
