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

class exe7_1_run implements Runnable
{
    String name;
    exe7_1_run(String name)
    {
        this.name = name;
    }
    public void run()
    {
        for(int i=1;i<=20;i++)
        {
            System.out.println(name+": "+i);
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
class exe7_1
{
    public static void main(String[] args)
    {
        Thread t1=new Thread(new exe7_1_run("Task 1"));
        Thread t2=new Thread(new exe7_1_run("Task 2"));
        Thread t3=new Thread(new exe7_1_run("Task 3"));
        Thread t4=new Thread(new exe7_1_run("Task 4"));
        Thread t5=new Thread(new exe7_1_run("Task 5"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
    }
}
