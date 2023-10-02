import java.util.Random;

public class as {
    public static void main(String[] args) {
        int numTriangles = 10; 
        for (int i = 0; i < numTriangles; i++) {
            double side1 = generateRandomSide();
            double side2 = generateRandomSide();
            double side3 = generateRandomSide();
             if (isValidTriangle(side1, side2, side3)==1) {
                System.out.println("Triangle " + (i + 1) + ": " + side1 + ", " + side2 + ", " + side3);
            } else { i--;
            }
        }
    }
    private static double generateRandomSide() {
        Random random = new Random();
        return 1 + random.nextDouble() * 9;
    }
        public static int isValidTriangle(double side1, double side2, double side3) {
            if((side1 + side2 > side3 ) && (side1 + side3 > side2) && (side2 + side3 > side1))
             return 1;
            else
            return 0 ;
    }
    
    }