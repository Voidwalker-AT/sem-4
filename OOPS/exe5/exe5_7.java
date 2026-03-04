// Create a class with two instance variables and one static variable.
// Modify all variables from main() using object reference.
// Create two objects and observe the changes.
// Explain why static variable changes affect all objects
class ex
{
    int v1;
    int v2;
    static int sv;
    void modify(int var1,int var2,int stvar)
    {
        v1=var1;
        v2=var2;
        sv=stvar;
    }
    void display()
    {
        System.out.println("Instance Variable 1: "+v1);
        System.out.println("Instance Variable 2: "+v2);
        System.out.println("Static Variable: "+sv);
    }
}
public class exe5_7
{
    public static void main(String args[])
    {
        ex obj1=new ex();
        ex obj2=new ex();
        obj1.modify(3,7,17);
        obj2.modify(96,25,19);
        System.out.println("Object 1:");
        obj1.display();
        System.out.println("Object 2:");
        obj2.display();
    }
}
//Observation: The static variable 'sv' is shared among all instances of the class 'ex'. When we modify 'sv' using one object (obj1), it changes for all objects of the class, including obj2. This is because static variables belong to the class rather than any specific instance, so they are shared across all instances. Therefore, when obj2 modifies 'sv', it overwrites the value set by obj1, and both obj1 and obj2 will reflect the latest value of 'sv'.