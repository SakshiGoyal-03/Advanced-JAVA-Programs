
import java.util.Scanner;

class MatrixMulThread extends Thread {
    private int[][] A, B, C;
    private int rowStart, rowEnd;

    public MatrixMulThread(int[][] A, int[][] B, int[][] C, int rowStart, int rowEnd) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
    }

    @Override
    public void run() {
        int N = A.length;
        int M = B[0].length;

        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }
}

public class _2104260_6b_{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of threads
        int N = scanner.nextInt(); // Dimension N
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
        long startTime = System.currentTimeMillis();

        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        long endTime = System.currentTimeMillis();
        long singleThreadedTime = endTime - startTime;

        System.out.println("Single-Threaded Execution Time : " + singleThreadedTime +" milliseconds");

        // Multithreaded matrix multiplication
        Thread[] threads = new Thread[T];
        int rowsPerThread = N / T;
        startTime = System.currentTimeMillis();

        for (int i = 0; i < T; i++) {
            int rowStart = i * rowsPerThread;
            int rowEnd = (i == T - 1) ? N : (i + 1) * rowsPerThread;
            threads[i] = new MatrixMulThread(A, B, C, rowStart, rowEnd);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(C[i][j]/2 + " ");
            }
            System.out.println();
        }

        endTime = System.currentTimeMillis();
        long multiThreadedTime = endTime - startTime;
        
        

        System.out.println("Multithreaded Execution Time : " + multiThreadedTime + " milliseconds");
        
       
    }
}