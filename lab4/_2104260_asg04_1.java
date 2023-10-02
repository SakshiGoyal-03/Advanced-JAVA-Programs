class Vehicle {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

class Car extends Vehicle {
    private int numberOfDoors;
    private int seatingCapacity;
    private boolean isConvertible;

    public Car(String make, String model, int year, int numberOfDoors, int seatingCapacity, boolean isConvertible) {
        super(make, model, year);
        this.numberOfDoors = numberOfDoors;
        this.seatingCapacity = seatingCapacity;
        this.isConvertible = isConvertible;
    }

    public void displayCarInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Seating Capacity: " + seatingCapacity + " passengers");
        System.out.println("Convertible: " + (isConvertible ? "Yes" : "No"));
    }
}

class Motorcycle extends Vehicle {
    private int topSpeed;
    private boolean hasSidecar;
    private String licenseType;

    public Motorcycle(String make, String model, int year, int topSpeed, boolean hasSidecar, String licenseType) {
        super(make, model, year);
        this.topSpeed = topSpeed;
        this.hasSidecar = hasSidecar;
        this.licenseType = licenseType;
    }

    public void displayMotorcycleInfo() {
        super.displayInfo();
        System.out.println("Top Speed: " + topSpeed + " mph");
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("License Type Required: " + licenseType);
    }
}

public class _2104260_asg04_1 {
    public static void main(String[] args) {
        Car car = new Car("Maruti", "Fronx", 2023, 4, 5, false);
        Motorcycle motorcycle = new Motorcycle("Honda", "SP 125", 2023, 120, false, "A");

        System.out.println("Car Information:");
        car.displayCarInfo();

        System.out.println("\nMotorcycle Information:");
        motorcycle.displayMotorcycleInfo();

        
        Vehicle vehicle = car;
        System.out.println("\nPolymorphism Example - Vehicle reference to a Car:");
        vehicle.displayInfo();

       
    }
}