// Create a Java program that simulates multiple tasks running at the same time.
// Tasks to Perform:
// 1.	Create a class that implements Runnable (or extends Thread).
// 2.	In the run() method:
//      o	Print a message (e.g., "Task 1 running" with the thread id)
//      o	Use a loop (e.g., print 1 to 20)
//      o	Add a delay using Thread.sleep()
//      o	Check what happens if the delay is too long.
// 3.	Create at least five thread objects:
//      o	Assign different tasks/messages to each thread
// 4.	Start both threads using start()
// 5.	Observe the output:
//      o	Notice how execution is interleaved (not sequential)
// Additional: If possible try to synchronize your code.
// Expected Output:
// Task 1: 1
// Task 2: 1
// Task 1: 2
// Task 3: 2
// Task 5: 3
// Task 4: 3
// ...
// (Order may vary — that’s the point!)

import java.util.*;
class Task implements Runnable
{
    String name;
    int mode;
    Task(String name, int mode)
    {
        this.name=name;
        this.mode=mode;
    }
    public void run()
    {
        switch(mode)
        {
            case 1:
                nonSync();
                break;
            case 2:
                sync();
                break;
        }
    }
    void nonSync()
    {
        for(int i=1;i<=20;i++)
        {
            System.out.println(name+":"+i);
            try
            {
                Thread.sleep(200);
            }
            catch(Exception e)
            {
                System.err.println(e);
            }
        }
    }
    void sync()
    {
        synchronized(Task.class)
        {
            for(int i=1;i<=20;i++)
            {
                System.out.println(name + ": " + i);
                try
                {
                    Thread.sleep(200);
                }
                catch(Exception e)
                {
                    System.err.println(e);
                }
            }
        }
    }
}
public class exe7_1
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Non-Synchronized");
        System.out.println("2. Synchronized");
        System.out.print("Enter choice: ");
        int ch = sc.nextInt();
        Thread t1 = new Thread(new Task("Task 1",ch));
        Thread t2 = new Thread(new Task("Task 2",ch));
        Thread t3 = new Thread(new Task("Task 3",ch));
        Thread t4 = new Thread(new Task("Task 4",ch));
        Thread t5 = new Thread(new Task("Task 5",ch));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
//Observations:
// 1. In non-synchronized mode, the output from different threads is interleaved, demonstrating concurrent execution.
// 2. In synchronized mode, the output from each thread is grouped together, showing that one thread completes its entire task before another thread starts, thus preventing interleaving.
// 3. The delay introduced by Thread.sleep() allows us to observe the interleaving more clearly, and if the delay is too long, it can cause significant waiting time for other threads, especially in non-synchronized mode.
// 4. Synchronization ensures that shared resources are accessed by only one thread at a time, which can prevent issues like race conditions but may lead to reduced concurrency and potential deadlocks if not used carefully.
// 5. The choice between synchronized and non-synchronized modes depends on the specific requirements of the application, such as whether thread safety is a concern and whether performance is a priority.
// Note: The actual output may vary each time you run the program due to the nature of thread scheduling.