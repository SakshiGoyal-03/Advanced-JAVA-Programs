import java.util.Scanner;

public class _2104260_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your input string: ");
        String input = sc.nextLine();
        sc.close();
        String[] words = input.split(" ");
        if (words.length < 2) {
            System.out.println("Please enter the string which have atleast two words");
            return;
        }

        String substring = words[0].toLowerCase();
        StringBuilder fullString = new StringBuilder();
        for (int i = 1; i < words.length; i++) {
            fullString.append(words[i]);
            if (i < words.length - 1) {
                fullString.append(" ");
            }
        }

        String fullStringLower = fullString.toString().toLowerCase();

        System.out.print(fullString.length());
        System.out.print(" " + fullString.toString().toUpperCase());

        if (fullStringLower.contains(substring)) {
            System.out.print(" Substring Found");
        } else {
            System.out.print(" Substring Not Found");
        }
    }

    
}
