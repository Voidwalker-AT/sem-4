// Experiment 18: Collections Framework
// 2. Use HashSet and TreeSet to remove duplicates and sort data.
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class exe10_6
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("===== Data Collection and Sorting =====");
        System.out.print("Enter number of integers: ");
        int n = sc.nextInt();
        
        HashSet<Integer> hashSet = new HashSet<>();
        
        System.out.println("Enter " + n + " integers:");
        for(int i = 0; i < n; i++)
        {
            int num = sc.nextInt();
            hashSet.add(num);
        }
        
        System.out.println("\nHashSet (removes duplicates, unordered):");
        System.out.println(hashSet);
        System.out.println("Size: " + hashSet.size());
        
        // Convert HashSet to TreeSet for sorting
        TreeSet<Integer> treeSet = new TreeSet<>(hashSet);
        
        System.out.println("\nTreeSet (removes duplicates, sorted in ascending order):");
        System.out.println(treeSet);
        System.out.println("Size: " + treeSet.size());
        
        System.out.println("\nTreeSet in descending order:");
        TreeSet<Integer> descendingSet = new TreeSet<>((a, b) -> b.compareTo(a));
        descendingSet.addAll(hashSet);
        System.out.println(descendingSet);
        
        System.out.println("\nString Collection with HashSet and TreeSet:");
        System.out.print("Enter number of strings: ");
        int m = sc.nextInt();
        sc.nextLine();
        
        HashSet<String> stringHashSet = new HashSet<>();
        System.out.println("Enter " + m + " strings:");
        for(int i = 0; i < m; i++)
        {
            String str = sc.nextLine();
            stringHashSet.add(str);
        }
        
        System.out.println("\nString HashSet (removes duplicates):");
        System.out.println(stringHashSet);
        
        TreeSet<String> stringTreeSet = new TreeSet<>(stringHashSet);
        System.out.println("\nString TreeSet (sorted alphabetically):");
        System.out.println(stringTreeSet);
        
        sc.close();
    }
}
//Observation: This program demonstrates the use of HashSet to remove duplicates and TreeSet to sort data in ascending order. It shows how HashSet stores elements without duplicates but unordered, while TreeSet maintains elements in sorted order. It handles both integers and strings.
