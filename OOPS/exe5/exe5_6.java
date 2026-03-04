// Write a program with:
// void display(int a, float b)
// void display(float a, int b)
// Call display(10, 10);
// Does it compile? Explain why ambiguity occurs.
class Ambiguity
{
    void display(int a,float b)
    {
        System.out.println("Method with int and float parameters called: "+a+", "+b);
    }
    void display(float a,int b)
    {
        System.out.println("Method with float and int parameters called: "+a+", "+b);
    }
}
public class exe5_6
{
    public static void main(String args[])
    {        Ambiguity obj=new Ambiguity();
        //obj.display(10, 10); // This line will cause a compilation error due to ambiguity
        obj.display(10.6f,10);
        obj.display(10,10.8f);
        System.out.println("The call obj.display(10, 10) is ambiguous because both methods can be called with the given arguments. The compiler cannot determine which method to call since both methods can accept the arguments (10 can be treated as an int or a float). To resolve this ambiguity, you can either cast the arguments to the desired types or provide different argument values that clearly match one of the method signatures.");
    }
}
//Observation: The call obj.display(10, 10) is ambiguous because both methods can be called with the given arguments. The compiler cannot determine which method to call since both methods can accept the arguments (10 can be treated as an int or a float). To resolve this ambiguity, you can either cast the arguments to the desired types or provide different argument values that clearly match one of the method signatures.