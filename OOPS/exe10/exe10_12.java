// Experiment 19: Wrapper Classes
// 4. Handle NumberFormatException in wrapper usage.
import java.util.Scanner;

public class exe10_12
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("===== Number Format Exception Handling =====\n");
        
        // Handling Integer.parseInt() exception
        System.out.println("Test 1: Integer.parseInt()");
        System.out.print("Enter an integer: ");
        String intInput = sc.nextLine();
        try
        {
            Integer intValue = Integer.parseInt(intInput);
            System.out.println("Successfully converted to Integer: " + intValue);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: '" + intInput + "' is not a valid integer!");
            System.out.println("Exception: " + e.getMessage());
        }
        
        // Handling Double.parseDouble() exception
        System.out.println("\nTest 2: Double.parseDouble()");
        System.out.print("Enter a double value: ");
        String doubleInput = sc.nextLine();
        try
        {
            Double doubleValue = Double.parseDouble(doubleInput);
            System.out.println("Successfully converted to Double: " + doubleValue);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: '" + doubleInput + "' is not a valid double!");
            System.out.println("Exception: " + e.getMessage());
        }
        
        // Handling Float.parseFloat() exception
        System.out.println("\nTest 3: Float.parseFloat()");
        System.out.print("Enter a float value: ");
        String floatInput = sc.nextLine();
        try
        {
            Float floatValue = Float.parseFloat(floatInput);
            System.out.println("Successfully converted to Float: " + floatValue);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: '" + floatInput + "' is not a valid float!");
            System.out.println("Exception: " + e.getMessage());
        }
        
        // Handling Long.parseLong() exception
        System.out.println("\nTest 4: Long.parseLong()");
        System.out.print("Enter a long value: ");
        String longInput = sc.nextLine();
        try
        {
            Long longValue = Long.parseLong(longInput);
            System.out.println("Successfully converted to Long: " + longValue);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: '" + longInput + "' is not a valid long!");
            System.out.println("Exception: " + e.getMessage());
        }
        
        // Handling with default values
        System.out.println("\nTest 5: Using default values on exception");
        System.out.print("Enter a number (default 0): ");
        String numInput = sc.nextLine();
        
        Integer result = 0;
        try
        {
            result = Integer.parseInt(numInput);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Invalid input! Using default value: 0");
        }
        System.out.println("Final value: " + result);
        
        // Multiple parsing with exception handling
        System.out.println("\nTest 6: Multiple conversions with validation");
        int validCount = 0;
        int[] numbers = new int[3];
        
        System.out.println("Enter 3 numbers:");
        for(int i = 0; i < 3; i++)
        {
            System.out.print("Number " + (i + 1) + ": ");
            String input = sc.nextLine();
            try
            {
                numbers[i] = Integer.parseInt(input);
                validCount++;
                System.out.println("Valid: " + numbers[i]);
            }
            catch(NumberFormatException e)
            {
                System.out.println("Invalid input: '" + input + "' skipped");
                numbers[i] = 0;
            }
        }
        
        System.out.println("Valid entries: " + validCount + " out of 3");
        System.out.print("Numbers entered: ");
        for(int num : numbers)
            System.out.print(num + " ");
        System.out.println();
        
        sc.close();
    }
}
//Observation: This program demonstrates comprehensive exception handling for NumberFormatException when using wrapper class conversion methods like Integer.parseInt(), Double.parseDouble(), Float.parseFloat(), and Long.parseLong(). It shows try-catch blocks, exception messages, default values, and validation techniques for handling invalid numeric inputs.
