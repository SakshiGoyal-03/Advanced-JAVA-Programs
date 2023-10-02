import java.util.*;

abstract class Shape {
    abstract double area();
    abstract double perimeter();

}


class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    double perimeter() {
        return 2 * (width + height);
    }
}
class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double area() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double perimeter() {
        return side1 + side2 + side3;
    }
}
public class _2104260_asg04_5 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N ;
        System.out.println("Enter N : ");
        N = sc.nextInt();
        List<Shape> shapes = new ArrayList<>();

       
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            int choice = random.nextInt(3); 
            if (choice == 0) {
                double radius = random.nextDouble() * 10;
                shapes.add(new Circle(radius));
            } else if (choice == 1) {
                double width = random.nextDouble() * 10;
                double height = random.nextDouble() * 10;
                shapes.add(new Rectangle(width, height));
            } else {
                double side1 = random.nextInt(1 , 100) ;
                double side2 = random.nextInt(1 ,100) ;
                double side3 = random.nextInt(1 ,100) ;
                if (isValidTriangle(side1, side2, side3)==1) {
                shapes.add(new Triangle(side1, side2, side3));
                }
                else { i--;
                }
            }
        }
        
        selectionSort(shapes, "area");
        System.out.println("\nSorted by Area:");
        for (Shape shape : shapes) {
            System.out.printf("%s:  = %.2f\n", shape.getClass().getSimpleName(), shape.area());
        }
        selectionSort(shapes, "perimeter");
        System.out.println("\nSorted by Perimeter:");
        for (Shape shape : shapes) {
            System.out.printf("%s:  = %.2f\n", shape.getClass().getSimpleName(), shape.perimeter());
        }
    }
    public static int isValidTriangle(double side1, double side2, double side3) {
        if((side1 + side2 > side3 ) && (side1 + side3 > side2) && (side2 + side3 > side1))
          return 1;
        else
          return 0 ;
    }
     private static void selectionSort(List<Shape> shapes, String sortBy) {
        int n = shapes.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (sortBy.equals("area")) {
                    if (shapes.get(j).area() < shapes.get(minIndex).area()) {
                        minIndex = j;
                    }
                } else if (sortBy.equals("perimeter")) {
                    if (shapes.get(j).perimeter() < shapes.get(minIndex).perimeter()) {
                        minIndex = j;
                    }
                }
            }
            Shape temp = shapes.get(i);
            shapes.set(i, shapes.get(minIndex));
            shapes.set(minIndex, temp);
        }
    }
}
