//list
import java.lang.reflect.Array;
import java.util.*;
public class cl1
{
    public static void main(String[] args)
    {
        Object[] arr= {10,20,30,"babu","Anmol","Mishu"};

        Vector v1=new Vector(Arrays.asList(arr));
        // sum+=(Integer) v1.get(i);
        // }
        // System.out.println("Sum of elements in v1: "+sum);
        // v1.add("babu");
        // v1.add("Anmol");
        // v1.add("Mishu");

        // Vector<Integer> v1=new Vector<>();
        v1.add(10);
        v1.add(20);
        v1.add(30);
        v1.add(0,5); // adding element at index 0
        v1.add(2,15); // adding element at index 2
        v1.add(4,25); // adding element at index 4
        v1.add(6,35); // adding element at index 6
        v1.add(7,40); // adding element at index 8
        v1.add(8,45); // adding element at index 10
        v1.add(9,50); // adding element at index 12
        v1.add(10,55); // adding element at index 14
        v1.add(0,5); // adding element at index 0
        v1.add(2,15); // adding element at index 2
        v1.add(4,25); // adding element at index 4
        v1.add(6,35); // adding element at index 6
        v1.add(7,40); // adding element at index 8
        v1.add(8,45); // adding element at index 10
        v1.add(9,50); // adding element at index 12
        v1.add(10,55); // adding element at index 14
        v1.add(0,5); // adding element at index 0
        v1.add(2,15); // adding element at index 2
        v1.add(4,25); // adding element at index 4
        v1.add(6,35); // adding element at index 6
        v1.add(7,40); // adding element at index 8
        v1.add(8,45); // adding element at index 10
        v1.add(9,50); // adding element at index 12
        v1.add(10,55); // adding element at index 14
        v1.add(10);
        v1.add(20);
        v1.add(30);
        v1.add(0,5); // adding element at index 0
        v1.add(2,15); // adding element at index 2
        v1.add(4,25); // adding element at index 4
        v1.add(6,35); // adding element at index 6
        v1.add(7,40); // adding element at index 8
        v1.add(8,45); // adding element at index 10
        v1.add(9,50); // adding element at index 12
        v1.add(10,55); // adding element at index 14
        v1.add(0,5); // adding element at index 0
        v1.add(2,15); // adding element at index 2
        v1.add(4,25); // adding element at index 4
        v1.add(6,35); // adding element at index 6
        v1.add(7,40); // adding element at index 8
        v1.add(8,45); // adding element at index 10
        v1.add(9,50); // adding element at index 12
        v1.add(10,55); // adding element at index 14
        v1.add(0,5); // adding element at index 0
        v1.add(2,15); // adding element at index 2
        v1.add(4,25); // adding element at index 4
        v1.add(6,35); // adding element at index 6
        v1.add(7,40); // adding element at index 8
        v1.add(8,45); // adding element at index 10
        v1.add(9,null); // adding element at index 12
        v1.add(10,55); // adding element at index 14

        Vector<Integer> v2=new Vector<>();
        v2.add(100);
        v2.add(200);
        v2.add(300);

        // for(int i=0; i<v2.size(); i++)
        // {
        //     v1.add(v2.get(i));
        //     System.out.println(v2.get(i));
        // }
        v1.addAll(v2);
        v1.remove(3); // removing element at index 3
        v1.remove(5); // removing element at index 5
        v1.remove(Integer.valueOf(25)); // removing element with value 25
        // v1.removeAll(v2); // removing all elements of v2 from v1
        // v1.clear(); // removing all elements from v1

        // System.out.println("Elements in v1 after adding v2: "+v1);
        System.out.println(v1);
        System.out.println(v1.capacity());
        System.out.println(v1.size());
        System.out.println(v1.isEmpty());
        System.out.println(v1.contains(10));
        System.out.println(v1.contains(100));
        System.out.println(v1.containsAll(v2));
    }
}