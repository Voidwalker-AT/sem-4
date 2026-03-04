// Create a class to overload method area() for circle, rectangle, and triangle.
import java.util.*;
class Area
{
    double area(double r)
    {
        return 3.14*r*r;
    }
    double area(double l,double b)
    {
        return l*b;
    }
    double area(double a,double b,double c)
    {
        double s=(a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}
public class exe5_11
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Area obj=new Area();
        System.out.println("Enter radius of circle: ");
        double r=sc.nextDouble();
        System.out.println("Area of circle: "+obj.area(r));
        System.out.println("Enter length and breadth of rectangle: ");
        double l=sc.nextDouble();
        double b=sc.nextDouble();
        System.out.println("Area of rectangle: "+obj.area(l,b));
        System.out.println("Enter sides of triangle: ");
        double x=sc.nextDouble();
        double y=sc.nextDouble();
        double z=sc.nextDouble();
        System.out.println("Area of triangle: "+obj.area(x,y,z));
    }
}
//Observation: The program defines a class Area with three overloaded methods named area() to calculate the area of a circle, rectangle, and triangle. The main method prompts the user to input the necessary dimensions for each shape, calls the appropriate area() method based on the input, and displays the calculated area for each shape.