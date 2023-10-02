import java.util.Random;
import java.util.Scanner;

public class _2104260_lab03_{
    private static int N; 
    private static int TIMES1;
    private static int TIMES2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N: ");
        N = sc.nextInt();
        System.out.println("Enter TIMES for method1: ");
        TIMES1 = sc.nextInt();
        System.out.println("Enter TIMES for method2: ");
        TIMES2 = sc.nextInt();
        int minLength = 6; 
        int maxLength = 10; 

        String[] randomStrings = generateRandomStrings(N, minLength, maxLength);
   
        
        
        
        long ans1 = method1(randomStrings , TIMES1);
        System.out.println("Time taken for method1 : "+ ans1 + "ns");
           
        long ans2 = method2(randomStrings , TIMES2 );
        System.out.println("Time taken for method1 : "+ ans2 + "ns");
            
       sc.close();
    
}

    public static String[] generateRandomStrings(int N, int minLength, int maxLength) {
        String[] strings = new String[N];
        Random random = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < N; i++) {
            int length = random.nextInt(maxLength - minLength ) + minLength;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                int index = random.nextInt(chars.length());
                sb.append(chars.charAt(index));
            }
            strings[i] = sb.toString();
            
        }

        return strings;
    }
    
    public static long method1(String[] S, int TIMES) {
        
        Random r = new Random();
        String S1 = "";
        long start = System.nanoTime();
        for(int i=0;i<TIMES;i++)
        {
             int l = r.nextInt(0,N-1); 
              S1 = S1+S[l];
        }
        long end =  System.nanoTime();
        long time =  end - start;
        return time; 
    }
    public static long method2( String[] str , int TIMES) {
        long start = System.nanoTime();
        StringBuffer S2 = new StringBuffer();
        Random ran = new Random();
        for(int i=0;i<TIMES;i++)
        {
          int p = ran.nextInt(0,N-1);
          S2.append(str[p]);
       } 
       long end = System.nanoTime();
       long time = end-start;
       return time;
    }
}