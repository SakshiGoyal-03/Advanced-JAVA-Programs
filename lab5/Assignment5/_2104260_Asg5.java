class Employee{
    private int id;
    private String name;
    private double salary;

    Employee(int id , String name , double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public int getId(){
        return id;
    }
    public void displayInfo(){
        System.out.println("Employee ID: "+ getId());
        System.out.println("Employee Name: "+getName());
        System.out.println("Employee Salary: Rs. " +getSalary());
    }

}
class Manager extends Employee{
    String department;
    public String getDepartment() {
        return department;
    }

    public Manager( int id , String name , double salary , String department){
            super(id, name , salary );
            this.department = department;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Manager's Department : "+department);
    }

}
class Developer extends Employee{
    String programmingLanguage;
    public String getProgrammingLanguage(){
        return programmingLanguage;
    }

    public Developer(int id , String name , double salary , String programmingLanguage ){
        super(id , name ,salary);
        this.programmingLanguage = programmingLanguage;
    }
    @Override
     public void displayInfo(){
        super.displayInfo();
            System.out.println("Developer's Programming language: "+programmingLanguage);
     }

}
class Tester extends Employee{
    String testingType;
    public String getTestingType(){
        return testingType;
    }
    public Tester(int id , String name , double salary , String testingType){
        super(id,name,salary);
        this.testingType = testingType;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Tester's TestingType: "+ testingType);
    }
}
public class _2104260_Asg5{
    public static void main(String[] args){
        Manager emp1 = new Manager( 1, "Rohit Garg" , 20000.00 , "Sales"  );
        Developer  emp2= new Developer(11,"Sachin Bansal" , 300000.00, "java");
        Tester emp3 = new Tester(111 , "Tarun Sharma" , 400000.00 , "Quality");
        emp1.displayInfo();
        System.out.println();

        emp2.displayInfo();
        System.out.println();

        emp3.displayInfo();
        System.out.println();

        System.out.println("Examples of Polymorphism by creating an array of Employee class: ");
        Employee[] employees = new Employee[3];
        employees[0] = emp1;
        employees[1] = emp2;
        employees[2] = emp3;
        for(int i=0;i<3;i++)
        {
            employees[i].displayInfo();
            System.out.println();
        }
    }
}