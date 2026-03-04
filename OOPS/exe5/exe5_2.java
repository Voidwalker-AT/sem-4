// Create a class Employee with instance variables: name, id, salary.
// - Default constructor initializes with fixed values.
// - Parameterized constructor initializes with user-provided values.
// Create two objects and display employee details.
class employee
{
    String name;
    int id,salary;
    employee()
    {
        name="Rahul";
        id=590014725;
        salary=80000;
    }
    employee(String name,int id,int salary)
    {
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
    void display()
    {
        System.out.println("Employee Name: "+name);
        System.out.println("Employee ID: "+id);
        System.out.println("Employee Salary: "+salary); 
    }
}
public class exe5_2
{
    public static void main(String args[])
    {
        employee e1=new employee();
        employee e2=new employee("Anmol Thapliyal",590011794,85000);
        e1.display();
        e2.display();
    }
}
//Observation: The program demonstrates the use of constructors to initialize object properties and display employee details using a method.