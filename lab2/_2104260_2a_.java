import java.util.Scanner;

public class _2104260_2a_{
    public static int  maxShekels = 0;
    public static int gameLength(int n) {
        int length = 0;
        while (n != 1) {
            if (n % 2 == 1) {
                n = n + 2 * n + 1;
            } else {
                n = n / 2;
            }
            length++;
        }
        return length;
    }

    public static int maxGoldShekels(int X) {
        int totalShekels = 0;
        for (int num = 1; num <= X; num++) {
            totalShekels = gameLength(num);
            if(totalShekels > maxShekels)
            {
               maxShekels = totalShekels;
            }
        }
        
        return maxShekels;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X[] = new int[4];
        for(int i =0;i<4;i++){
               X[i] = scanner.nextInt();
        }
        for(int i = 0;i<4;i++)
        {
           int result = maxGoldShekels(X[i]);
           System.out.println(result);
        }
        
    }
}