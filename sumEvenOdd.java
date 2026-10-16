import java.util.Scanner;

public class sumEvenOdd {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner ( System.in)) {
            System.out.print("Enter new positive number n: ");
            int n = scanner.nextInt();
            
            int sumEven = 0;
            int sumOdd = 0;
            
            for (int i = 1; i <= n; i++) {
                sumEven += 2 * i;
                sumOdd += (2 * i - 1);
            }
            System.out.print("Sum of first " + n + " even integers: " + sumEven);
            
            System.out.print("Sum of first " + n + " odd integers: " + sumOdd);
        }
    }
    
}
