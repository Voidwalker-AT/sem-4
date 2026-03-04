// Create a class that has one instance variable and one static variable.
// Create a static method trying to access both variables.
// Observe and fix the compilation error.
// Explain why static methods cannot access instance variables.
class issta
{
    int a;
    static int b;
    static void display()
    {
        //System.out.println("Instance variable a = "+a); // This line would cause a compilation error
        System.out.println("Static variable b="+b);

    }
    void view()
    {
        System.out.println("Instance variable a="+a);
        System.out.println("Static variable b="+b);
    }
}
public class exe5_4
{
    public static void main(String args[])
    {
        issta.display();
        issta obj=new issta();
        obj.view();
    }
}
//Observation: Static methods cannot access instance variables because they belong to the class rather than any specific instance. Instance variables require an object of the class to be accessed, while static methods can be called without creating an object. Therefore, static methods can only directly access static variables and cannot reference instance variables without an object.