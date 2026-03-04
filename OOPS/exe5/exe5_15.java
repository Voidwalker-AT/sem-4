// Write a program showing constructor chaining.
class Student
{
    String name;
    int rollno;
    Student()
    {
        this("Rahul",35);
    }
    Student(String name,int rollno)
    {
        this.name=name;
        this.rollno=rollno;
    }
}
public class exe5_15
{
    public static void main(String args[])
    {
        Student s1=new Student();
        Student s2=new Student("Anmol",37);
        System.out.println("Student 1: Name="+s1.name+",Roll="+s1.rollno);
        System.out.println("Student 2: Name="+s2.name+",Roll="+s2.rollno);
    }
}
//Observation: The program demonstrates constructor chaining in the Student class. The default constructor calls the parameterized constructor using the 'this' keyword, passing fixed values for name and roll number. When we create an object using the default constructor, it initializes the name and roll number with the values specified in the parameterized constructor. When we create an object using the parameterized constructor, it initializes the name and roll number with the user-provided values. Finally, we display the details of both students to verify that the constructor chaining works as expected.