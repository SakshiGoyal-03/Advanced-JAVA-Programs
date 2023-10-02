import java.util.Scanner;

public class _2104260_3 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a string : ");
    String input = sc.nextLine();

    int string_length = 0;
    int word_count = 1;
    for(int i=0;i<input.length();i++)
    {
        if(input.charAt(i)!=' '){
            string_length++;
        }
     }
    for(int i=0;i<input.length();i++)
    {
             if( (i>0) && (input.charAt(i)!=' ') && (input.charAt(i-1)==' '))
             {
                word_count++;
             }
    }
    int prod = word_count*string_length;
    System.out.println(prod);

    sc.close();
  }
}
