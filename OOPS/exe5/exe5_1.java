//Write a Java program that overloads a method calculate() to perform:
//- Sum of two integers
//- Sum of three integers
//- Sum of two double values
//- Concatenation of two strings
//Display the result of each method call from main().

class Overload
{
    void calculate(int a,int b)
    {
        System.out.println("Sum of two integers: "+(a+b));
    }
    void calculate(int a,int b,int c)
    {
        System.out.println("Sum of three integers: "+(a+b+c));
    }
    void calculate(double a, double b)
    {
        System.out.println("Sum of two double values: " +(a+b));
    }
    void calculate(String str1, String str2)
    {
        System.out.println("Concatenation of two strings: "+str1+str2);
    }
}

public class exe5_1
{
    public static void main(String args[])
    {
        Overload obj=new Overload();
        obj.calculate(17,19);
        obj.calculate(5,7,11);
        obj.calculate(2.96,5.67);
        obj.calculate("hell","o");
    }
}
//Observation: The program demonstrates the use of overloaded methods to perform various arithmetic operations and string concatenation on different data types.