// Create a class where constructor calls an instance method.
// Instance method reads input using BufferedReader and adds value to instance
// variable.
// Create object from main() and observe execution
import java.io.*;
class Constructor
{
    int a;
    Constructor()
    {
        readValue();
    }
    void readValue()
    {
        {
            try
            {
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter value: ");
                int x=Integer.parseInt(br.readLine());
                a=a+x;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
}
public class exe5_8
{
    public static void main(String args[])
    {
        Constructor obj=new Constructor();
        System.out.println("Value of a: "+obj.a);
    }
}
//Observation: When the object of the Constructor class is created, the constructor is called, which in turn calls the instance method readValue(). The readValue() method prompts the user to enter a value, reads it from the console, and adds it to the instance variable 'a'. Finally, the value of 'a' is displayed in the main method.