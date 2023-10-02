import java.util.Scanner;
import java.util.Arrays;

public class _2104260_4 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter a list of space-separated integers: ");
    String array_input = sc.nextLine();

    String[] intStrings = array_input.split("\\s+");
    int[] input = new int[intStrings.length];

    for (int i = 0; i < intStrings.length; i++) {
        input[i] = Integer.parseInt(intStrings[i]);
    }
    Arrays.sort(input);

    System.out.print("Sorted integers: ");
    for (int i = 0; i < input.length; i++) {
        System.out.print(input[i]);
        if (i < input.length - 1) {
            System.out.print(", ");
        }
    }

    sc.close();
  }  
}

