// Create a class demonstrating method overloading using different data types.
class Overloading
{
    void display(int a)
    {
        System.out.println("Integer: "+a);
    }
    void display(double b)
    {
        System.out.println("Double: "+b);
    }
    void display(String c)
    {
        System.out.println("String: "+c);
    }
}
public class exe5_14
{
    public static void main(String args[])
    {
        Overloading obj=new Overloading();
        obj.display(17);
        obj.display(3.14);
        obj.display("Hello");
    }
}
//Observation: The program defines a class Overloading with three overloaded methods named display() that accept different data types: int, double, and String. In the main method, we create an instance of the Overloading class and call the display() method with different types of arguments (an integer, a double, and a string). The appropriate overloaded method is called based on the type of argument passed, demonstrating method overloading in Java.