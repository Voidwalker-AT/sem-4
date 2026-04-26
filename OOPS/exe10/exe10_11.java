// Experiment 19: Wrapper Classes
// 3. Create a program combining collections + wrapper classes.
import java.util.ArrayList;
import java.util.Scanner;

public class exe10_11
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Double> marks = new ArrayList<>();
        ArrayList<Boolean> attendance = new ArrayList<>();
        
        System.out.println("===== Collections with Wrapper Classes =====\n");
        
        // Working with Integer ArrayList
        System.out.print("Enter number of integers: ");
        int n = sc.nextInt();
        
        System.out.println("Enter " + n + " integers:");
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            Integer num = sc.nextInt();  // Autoboxing
            numbers.add(num);
            sum += num;  // Unboxing
        }
        
        System.out.println("Integers: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (double)sum / numbers.size());
        System.out.println("Maximum: " + numbers.stream().max(Integer::compare).orElse(0));
        System.out.println("Minimum: " + numbers.stream().min(Integer::compare).orElse(0));
        
        // Working with Double ArrayList for marks
        System.out.print("\nEnter number of students: ");
        int students = sc.nextInt();
        
        System.out.println("Enter marks for each student:");
        double totalMarks = 0;
        for(int i = 0; i < students; i++)
        {
            Double mark = sc.nextDouble();  // Autoboxing
            marks.add(mark);
            totalMarks += mark;  // Unboxing
        }
        
        System.out.println("Marks: " + marks);
        System.out.println("Average Marks: " + (totalMarks / marks.size()));
        System.out.println("Highest Marks: " + marks.stream().max(Double::compare).orElse(0.0));
        System.out.println("Lowest Marks: " + marks.stream().min(Double::compare).orElse(0.0));
        
        // Working with Boolean ArrayList for attendance
        System.out.print("\nEnter attendance status for " + students + " students (true/false):");
        int presentCount = 0;
        for(int i = 0; i < students; i++)
        {
            Boolean present = sc.nextBoolean();  // Autoboxing
            attendance.add(present);
            if(present)  // Unboxing
                presentCount++;
        }
        
        System.out.println("Attendance: " + attendance);
        System.out.println("Present: " + presentCount + " out of " + students);
        System.out.println("Attendance %: " + ((double)presentCount / students * 100) + "%");
        
        // Searching and modifying
        System.out.print("\nEnter integer to search: ");
        int searchNum = sc.nextInt();
        if(numbers.contains(searchNum))  // Autoboxing
            System.out.println(searchNum + " found at index: " + numbers.indexOf(searchNum));
        else
            System.out.println(searchNum + " not found!");
        
        sc.close();
    }
}
//Observation: This program combines collections (ArrayList) with wrapper classes (Integer, Double, Boolean). It demonstrates autoboxing when adding wrapper objects to ArrayList and unboxing when retrieving them. It performs operations like sum, average, max, min, search, and percentage calculations on wrapper objects stored in collections.
