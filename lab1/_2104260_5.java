

import java.util.Scanner;

public class _2104260_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String a = sc.nextLine();
        sc.close();
        int start = 0;
        int end = a.length()-1;
        while(start<=end){
            if(a.charAt(start)!=a.charAt(end))
            {
                System.out.println("No");
                return;
            }
            else{
                start++;
                end--;
            }
        }
        System.out.println("Yes");
       
    }
}
