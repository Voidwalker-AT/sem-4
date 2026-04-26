// Experiment 19: Wrapper Classes
// 1. Demonstrate autoboxing and unboxing.
public class exe10_9
{
    public static void main(String args[])
    {
        System.out.println("===== Autoboxing and Unboxing =====\n");
        
        // Autoboxing: Converting primitive to wrapper class
        System.out.println("Autoboxing Examples:");
        int intValue = 50;
        Integer intWrapper = intValue;  // Autoboxing
        System.out.println("int " + intValue + " converted to Integer wrapper: " + intWrapper);
        
        double doubleValue = 3.14;
        Double doubleWrapper = doubleValue;  // Autoboxing
        System.out.println("double " + doubleValue + " converted to Double wrapper: " + doubleWrapper);
        
        boolean boolValue = true;
        Boolean boolWrapper = boolValue;  // Autoboxing
        System.out.println("boolean " + boolValue + " converted to Boolean wrapper: " + boolWrapper);
        
        char charValue = 'A';
        Character charWrapper = charValue;  // Autoboxing
        System.out.println("char " + charValue + " converted to Character wrapper: " + charWrapper);
        
        // Unboxing: Converting wrapper class to primitive
        System.out.println("\nUnboxing Examples:");
        Integer wrappedInt = 100;
        int primitiveInt = wrappedInt;  // Unboxing
        System.out.println("Integer wrapper " + wrappedInt + " converted to int: " + primitiveInt);
        
        Double wrappedDouble = 2.71;
        double primitiveDouble = wrappedDouble;  // Unboxing
        System.out.println("Double wrapper " + wrappedDouble + " converted to double: " + primitiveDouble);
        
        Boolean wrappedBool = false;
        boolean primitiveBool = wrappedBool;  // Unboxing
        System.out.println("Boolean wrapper " + wrappedBool + " converted to boolean: " + primitiveBool);
        
        // Arithmetic operations with autoboxing/unboxing
        System.out.println("\nArithmetic Operations with Autoboxing/Unboxing:");
        Integer a = 20;  // Autoboxing
        Integer b = 30;  // Autoboxing
        int result = a + b;  // Unboxing during addition
        System.out.println(a + " + " + b + " = " + result);
        
        // Comparison
        System.out.println("\nComparison:");
        Integer x = 50;
        Integer y = 50;
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x == y: " + (x == y));
        System.out.println("x.equals(y): " + x.equals(y));
    }
}
//Observation: This program demonstrates autoboxing (automatic conversion from primitive to wrapper class) and unboxing (automatic conversion from wrapper class to primitive). It shows examples with Integer, Double, Boolean, and Character wrapper classes with arithmetic and comparison operations.
