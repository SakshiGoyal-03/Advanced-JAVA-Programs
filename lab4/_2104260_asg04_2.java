class Employee {
    private String name;
    private String designation;
    private int employeeId;

    public Employee(String name, String designation, int employeeId) {
        this.name = name;
        this.designation = designation;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double calculateSalary() {
        return 0.0;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + calculateSalary());
    }

    public void updateName(String newName) {
        this.name = newName;
    }

    public void updateDesignation(String newDesignation) {
        this.designation = newDesignation;
    }
}

class Manager extends Employee {
    private double baseSalary;
    private double bonus;

    public Manager(String name, int employeeId, double baseSalary, double bonus) {
        super(name, "Manager", employeeId);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}

class Developer extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Developer(String name, int employeeId, double hourlyRate, int hoursWorked) {
        super(name, "Developer", employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

class Salesperson extends Employee {
    private double salesCommission;

    public Salesperson(String name, int employeeId, double salesCommission) {
        super(name, "Salesperson", employeeId);
        this.salesCommission = salesCommission;
    }

    @Override
    public double calculateSalary() {
        return salesCommission;
    }
}

public class _2104260_asg04_2 {
    public static void main(String[] args) {
        Manager manager = new Manager("Rohit Garg", 111, 49000.0, 10000.0);
        Developer developer = new Developer("Sachin Agarwal", 211, 30.0, 175);
        Salesperson salesperson = new Salesperson("Deepak Sharma", 311, 4000.0);

        System.out.println("Employee Details:");
        manager.displayDetails();
        developer.displayDetails();
        salesperson.displayDetails();

        
        manager.updateName("Mayank Kumar");
        manager.updateDesignation("Senior Manager");

        System.out.println("\nUpdated Employee Details:");
        manager.displayDetails();
    }
}
