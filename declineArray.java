import java.util.Arrays;


public class declineArray {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {6, 7, 8, 9, 10};
        int[] C = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            C[i] = A[i] + B[i];
        }

        System.out.println("A = " + Arrays.toString(A));
        System.out.println("B = " + Arrays.toString(B));
        System.out.println("A + B = " + Arrays.toString(C)); // [7, 9, 11, 13, 15]
    }
}
