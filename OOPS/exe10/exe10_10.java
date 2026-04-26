// Experiment 19: Wrapper Classes
// 2. Convert string inputs into numeric types using wrapper classes.
import java.util.Scanner;

public class exe10_10
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("===== String to Numeric Conversion =====\n");
        
        // Converting String to Integer
        System.out.print("Enter an integer value: ");
        String intStr = sc.nextLine();
        try
        {
            Integer intValue = Integer.parseInt(intStr);
            System.out.println("String '" + intStr + "' converted to Integer: " + intValue);
            System.out.println("Type: " + intValue.getClass().getName());
            System.out.println("Value doubled: " + (intValue * 2));
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: Invalid integer format!");
        }
        
        // Converting String to Double
        System.out.print("\nEnter a double value: ");
        String doubleStr = sc.nextLine();
        try
        {
            Double doubleValue = Double.parseDouble(doubleStr);
            System.out.println("String '" + doubleStr + "' converted to Double: " + doubleValue);
            System.out.println("Type: " + doubleValue.getClass().getName());
            System.out.println("Square root: " + Math.sqrt(doubleValue));
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: Invalid double format!");
        }
        
        // Converting String to Float
        System.out.print("\nEnter a float value: ");
        String floatStr = sc.nextLine();
        try
        {
            Float floatValue = Float.parseFloat(floatStr);
            System.out.println("String '" + floatStr + "' converted to Float: " + floatValue);
            System.out.println("Type: " + floatValue.getClass().getName());
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: Invalid float format!");
        }
        
        // Converting String to Long
        System.out.print("\nEnter a long value: ");
        String longStr = sc.nextLine();
        try
        {
            Long longValue = Long.parseLong(longStr);
            System.out.println("String '" + longStr + "' converted to Long: " + longValue);
            System.out.println("Type: " + longValue.getClass().getName());
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: Invalid long format!");
        }
        
        // Converting String to Boolean
        System.out.print("\nEnter a boolean value (true/false): ");
        String boolStr = sc.nextLine();
        Boolean boolValue = Boolean.parseBoolean(boolStr);
        System.out.println("String '" + boolStr + "' converted to Boolean: " + boolValue);
        System.out.println("Type: " + boolValue.getClass().getName());
        
        // Reverse conversion: Numeric to String
        System.out.println("\n===== Numeric to String Conversion =====");
        int num = 42;
        String numStr = Integer.toString(num);
        System.out.println("Integer " + num + " converted to String: '" + numStr + "'");
        System.out.println("Type: " + numStr.getClass().getName());
        
        double decimal = 3.14159;
        String decimalStr = Double.toString(decimal);
        System.out.println("Double " + decimal + " converted to String: '" + decimalStr + "'");
        
        sc.close();
    }
}
//Observation: This program demonstrates converting string inputs into numeric types using wrapper class methods like Integer.parseInt(), Double.parseDouble(), Float.parseFloat(), Long.parseLong(), and Boolean.parseBoolean(). It also shows reverse conversion from numeric types to strings and includes proper error handling.
