// program to simulate a smart task processing system using generics, multithreading and lambdas
class TaskData<T>
{
    T value;
    
    TaskData(T v)
    {
        value=v;
    }
    
    void display()
    {
        System.out.println("Value: "+value);
    }
}

class NumberTask implements Runnable
{
    public void run()
    {
        System.out.println("Thread 1 (Numbers):");
        for(int i=1;i<=5;i++)
        {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

class MessageTask implements Runnable
{
    public void run()
    {
        System.out.println("Thread 2 (Message):");
        System.out.println("Processing Task...");
    }
}

public class exe9_2
{
    public static void main(String args[])
    {
        System.out.println("Task Data:");
        TaskData<Integer> numData=new TaskData<Integer>(10);
        TaskData<String> msgData=new TaskData<String>("Hello");
        numData.display();
        msgData.display();
        
        NumberTask nt=new NumberTask();
        Thread t1=new Thread(nt);
        
        MessageTask mt=new MessageTask();
        Thread t2=new Thread(mt);
        
        Thread t3=new Thread(() -> 
        {
            System.out.println("Thread 3 (Lambda Task):");
            System.out.println("Lambda Running...");
        });
        
        t1.start();
        t2.start();
        t3.start();
    }
}
//Observation: The program creates a generic class TaskData to store and display arbitrary data types. It uses the Runnable interface for NumberTask and MessageTask to define thread behaviors. A lambda expression is used to instantiate and run a third concurrent task. All threads execute concurrently in the main method alongside the generic data outputs.