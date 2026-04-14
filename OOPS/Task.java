import java.io.*;
class NumberPrinter implements Runnable
{
    public void run()
    {
        try
        {
            for(int i=1;i<=10;i++)
            {
                System.out.println(i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
public class Task
{
    public static void main(String args[])
    {
        NumberPrinter obj=new NumberPrinter();
        Thread t1=new Thread(obj);
        Thread t2=new Thread(obj);
        t1.start();
        t2.start();
        try
        {
            t1.join();
            t2.join();
        }
        catch(InterruptedException e)
        {
            System.out.println("Error occured: "+e.getMessage());
        }
        try
        {
            FileWriter fw=new FileWriter("Status.txt");
            fw.write("All threads completed successfully");
            fw.close();
        }
        catch(IOException e)
        {
            System.out.println("error occured:"+e.getMessage());
        }
    }
}