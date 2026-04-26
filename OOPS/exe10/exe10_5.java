// Experiment 18: Collections Framework
// 1. Implement student management using ArrayList.
import java.util.ArrayList;
import java.util.Scanner;

class Student
{
    int rollNo;
    String name;
    String course;
    
    Student(int rollNo, String name, String course)
    {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }
    
    public String toString()
    {
        return "Roll No: " + rollNo + ", Name: " + name + ", Course: " + course;
    }
}

public class exe10_5
{
    public static void main(String args[])
    {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do
        {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    students.add(new Student(rollNo, name, course));
                    System.out.println("Student added successfully!");
                    break;
                    
                case 2:
                    if(students.isEmpty())
                        System.out.println("No students found!");
                    else
                    {
                        System.out.println("\nAll Students:");
                        for(Student s : students)
                            System.out.println(s);
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter Roll No to search: ");
                    int searchRoll = sc.nextInt();
                    boolean found = false;
                    for(Student s : students)
                    {
                        if(s.rollNo == searchRoll)
                        {
                            System.out.println("Found: " + s);
                            found = true;
                            break;
                        }
                    }
                    if(!found)
                        System.out.println("Student not found!");
                    break;
                    
                case 4:
                    System.out.print("Enter Roll No to remove: ");
                    int removeRoll = sc.nextInt();
                    for(int i = 0; i < students.size(); i++)
                    {
                        if(students.get(i).rollNo == removeRoll)
                        {
                            students.remove(i);
                            System.out.println("Student removed successfully!");
                            break;
                        }
                    }
                    break;
                    
                case 5:
                    System.out.println("Thank you!");
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 5);
        
        sc.close();
    }
}
//Observation: This program implements a student management system using ArrayList. It provides options to add students, display all students, search for a specific student by roll number, and remove students from the list. Uses Iterator pattern with for-each loop.
