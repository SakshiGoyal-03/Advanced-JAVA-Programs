
import java.util.Scanner;

class MatrixAdditionThread extends Thread {
    private final int[][] A;
    private final int[][] B;
    private final int[][] C;
    private final int startRow;
    private final int endRow;

    public MatrixAdditionThread(int[][] A, int[][] B, int[][] C, int startRow, int endRow) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public void run() {
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < A[i].length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
    }
}


    

public class _2104260_6a_{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of threads
        int N = scanner.nextInt(); // Matrix dimension
        int[][] A = new int[N][N];
        int[][] B = new int[N][N];
        int[][] C = new int[N][N];
     

      
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                B[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        MatrixAdditionThread[] additionThreads = new MatrixAdditionThread[T];
        int rowsPerThreadAddition = N / T;
        int startRow = 0;
        int endRow = rowsPerThreadAddition;

        long startTimeAddition = System.currentTimeMillis();

        for (int i = 0; i < T; i++) {
            if (i == T - 1) {
                endRow = N; // Last thread handles remaining rows
            }
            additionThreads[i] = new MatrixAdditionThread(A, B, C, startRow, endRow);
            additionThreads[i].start();
            startRow = endRow;
            endRow = startRow+ rowsPerThreadAddition;
        }

        try {
            for (Thread thread : additionThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTimeAddition = System.currentTimeMillis();
        long executionTimeAddition = endTimeAddition - startTimeAddition;

       
        System.out.println("Matrix C (Result of Addition Matrix A and Matrix B):");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Addition Execution time: " + executionTimeAddition + " milliseconds");

       
                
    }
}
