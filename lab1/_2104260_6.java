import java.util.Scanner;

public class _2104260_6  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature followed by unit (C/F): ");
        String input = scanner.nextLine();

        char unit = input.charAt(0);
        double value = Double.parseDouble(input.substring(2));


        switch(unit){
            case 'C':
                double fahrenheit = celsiusToFahrenheit(value);
                System.out.printf("%.1f %n", fahrenheit);
                break;
            case 'F':
                 double celsius = fahrenheitToCelsius(value);
                 System.out.printf("%.1f %n", celsius);
                 break;
            default:
               System.err.println("Invalid Conversion");     
              
        }
     
        scanner.close();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
