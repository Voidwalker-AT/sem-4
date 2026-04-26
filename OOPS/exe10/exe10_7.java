// Experiment 18: Collections Framework
// 3. Create a Map-based phone directory system.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exe10_7
{
    public static void main(String args[])
    {
        HashMap<String, String> phoneDirectory = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do
        {
            System.out.println("\n===== Phone Directory System =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();
                    phoneDirectory.put(name, phone);
                    System.out.println("Contact added successfully!");
                    break;
                    
                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    if(phoneDirectory.containsKey(searchName))
                        System.out.println(searchName + ": " + phoneDirectory.get(searchName));
                    else
                        System.out.println("Contact not found!");
                    break;
                    
                case 3:
                    System.out.print("Enter name to update: ");
                    String updateName = sc.nextLine();
                    if(phoneDirectory.containsKey(updateName))
                    {
                        System.out.print("Enter new phone number: ");
                        String newPhone = sc.nextLine();
                        phoneDirectory.put(updateName, newPhone);
                        System.out.println("Contact updated successfully!");
                    }
                    else
                        System.out.println("Contact not found!");
                    break;
                    
                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = sc.nextLine();
                    if(phoneDirectory.containsKey(deleteName))
                    {
                        phoneDirectory.remove(deleteName);
                        System.out.println("Contact deleted successfully!");
                    }
                    else
                        System.out.println("Contact not found!");
                    break;
                    
                case 5:
                    if(phoneDirectory.isEmpty())
                        System.out.println("Phone directory is empty!");
                    else
                    {
                        System.out.println("\n===== All Contacts =====");
                        for(Map.Entry<String, String> entry : phoneDirectory.entrySet())
                            System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                    break;
                    
                case 6:
                    System.out.println("Thank you!");
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        } 
        while(choice != 6);
        {
        sc.close();
        }
    }
}
//Observation: This program creates a phone directory system using HashMap where the key is the name and value is the phone number. It provides functionality to add, search, update, delete, and display all contacts. It demonstrates HashMap operations like put(), get(), containsKey(), remove(), and entrySet().
