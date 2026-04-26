// Experiment 18: Collections Framework
// 4. Iterate collections using Iterator and for-each loop.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class exe10_8
{
    public static void main(String args[])
    {
        // ArrayList iteration
        System.out.println("===== ArrayList Iteration =====");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(50);
        
        System.out.println("Using Iterator:");
        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println();
        
        System.out.println("Using for-each loop:");
        for(Integer num : arrayList)
            System.out.print(num + " ");
        System.out.println("\n");
        
        // HashSet iteration
        System.out.println("===== HashSet Iteration =====");
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Date");
        
        System.out.println("Using Iterator:");
        Iterator<String> setIterator = hashSet.iterator();
        while(setIterator.hasNext())
            System.out.print(setIterator.next() + " ");
        System.out.println();
        
        System.out.println("Using for-each loop:");
        for(String fruit : hashSet)
            System.out.print(fruit + " ");
        System.out.println("\n");
        
        // HashMap iteration
        System.out.println("===== HashMap Iteration =====");
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.put(4, "Four");
        
        System.out.println("Using Iterator with entrySet():");
        Iterator<java.util.Map.Entry<Integer, String>> mapIterator = hashMap.entrySet().iterator();
        while(mapIterator.hasNext())
        {
            java.util.Map.Entry<Integer, String> entry = mapIterator.next();
            System.out.print(entry.getKey() + "-" + entry.getValue() + " ");
        }
        System.out.println();
        
        System.out.println("Using for-each loop on entrySet():");
        for(java.util.Map.Entry<Integer, String> entry : hashMap.entrySet())
            System.out.print(entry.getKey() + "-" + entry.getValue() + " ");
        System.out.println();
        
        System.out.println("Using for-each loop on keySet():");
        for(Integer key : hashMap.keySet())
            System.out.print(key + " ");
        System.out.println();
        
        System.out.println("Using for-each loop on values():");
        for(String value : hashMap.values())
            System.out.print(value + " ");
        System.out.println();
    }
}
//Observation: This program demonstrates different ways to iterate through collections - ArrayList, HashSet, and HashMap using Iterator interface and for-each loop. It shows iterator methods like hasNext() and next(), and for-each loop as a convenient alternative for collection traversal.
