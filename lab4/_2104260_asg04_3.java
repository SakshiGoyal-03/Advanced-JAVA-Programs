
class Shape {
    public double area() {
        return 0.0; 
    }

    public double perimeter() {
        return 0.0;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
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
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
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
    public double area() {
        double s = (side1 + side2 + side3) / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }
}

public class _2104260_asg04_3 {
    public static void main(String[] args) {
        Circle circle = new Circle(7.5);
        Rectangle rectangle = new Rectangle(5.0, 8.0);
        Triangle triangle = new Triangle(3.5, 4.6, 5.8);

        System.out.println("Circle - Area: " + String.format("%.2f",circle.area())+ ", Perimeter: " + String.format("%.2f" , circle.perimeter()));
        System.out.println("Rectangle - Area: " +String.format("%.2f" ,rectangle.area() )  + " Perimeter: " + String.format("%.2f",rectangle.perimeter()));
        System.out.println("Triangle - Area: " + String.format("%.2f" , triangle.area() ) + ", Perimeter: " + String.format("%.2f", triangle.perimeter()));
    }
}
