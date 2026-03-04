// Create a class Student with name, roll number and static variable totalStudents.
// Overload constructors (default and parameterized).
// Each time object is created, increment totalStudents.
// Display total number of students created.
class Student
{
    String name;
    int rollno;
    static int totalStudents;
    Student()
    {
        totalStudents++;
    }
    Student(String name, int rollno)
    {
        this.name=name;
        this.rollno=rollno;
        totalStudents++;
    }
}
public class exe5_10
{
    public static void main(String args[])
    {
        Student s1=new Student();
        Student s2=new Student("Alice", 1);
        Student s3=new Student("Bob", 2);
        System.out.println("Total students created: "+Student.totalStudents);
    }
}
//Observation: In this program, we have a Student class with two constructors: a default constructor and a parameterized constructor. Each time an object of the Student class is created, the static variable totalStudents is incremented. In the main method, we create three Student objects, which results in totalStudents being incremented three times. Finally, we display the total number of students created, which will output "Total students created: 3".