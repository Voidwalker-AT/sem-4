import java.util.Scanner;

class Employee
{
    String name;
    int empid;
    double salary;
    Employee()
    {
        name = "Unknown";
        empid = 0;
        salary = 0;
    }
    Employee(String name, int empid, double salary)
    {
        this.name   = name;
        this.empid  = empid;
        this.salary = salary;
    }
    String getName()  { return name; }
    double getSalary() { return salary; }
    void increaseSalary(double pct) { salary += salary * pct / 100; }
}

class Manager extends Employee
{
    String department;
    Manager(String name, int empid, double salary, String dept)
    {
        super(name, empid, salary);
        this.department = dept;
    }
}

class EmployeeDemo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter salary increase percentage: ");
        double pct = sc.nextDouble();
        Employee e = new Employee("Rahul", 101, 50000);
        Manager  m = new Manager("Priya", 201, 80000, "IT");
        e.increaseSalary(pct);
        m.increaseSalary(pct);
        System.out.println("Employee: " + e.getName() + ", New Salary: " + e.getSalary());
        System.out.println("Manager : " + m.getName() + ", Dept: " + m.department + ", New Salary: " + m.getSalary());
        System.out.println("My name is Rahul Mankani, SAP ID- 590014725");
    }
}
//oop and dcn