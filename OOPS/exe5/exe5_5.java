// Write a program containing:
// - Static block
// - Instance block
// - Constructor
// - main() method
// Print statements in each block and observe execution order.
class exe5_5
{
    static
    {
        System.out.println("This is a static block.");
    }
    {
        System.out.println("This is an instance block.");
    }
    exe5_5()
    {
        System.out.println("This is a constructor.");
    }
    public static void main(String args[])
    {
        exe5_5 obj=new exe5_5();
        System.out.println("This is the main method.");
    }
}
//Observation: The execution order is as follows: First, the static block is executed when the class is loaded. Then, when an object of the class is created, the instance block is executed followed by the constructor. Finally, the main method is executed. Therefore, the output will be: