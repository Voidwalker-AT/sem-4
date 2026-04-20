import java.io.*;
import java.util.Scanner;

class exe8_12
{
    static String encryptPassword(String password)
    {
        String encrypted="";
        for(int i=0;i<password.length();i++)
        {
            char c=password.charAt(i);
            c=(char)(c+5);
            encrypted+=c;
        }
        return encrypted;
    }
    
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        BufferedReader br=null;
        FileWriter fw=null;
        try
        {
            System.out.println("1. Register New User");
            System.out.println("2. Login");
            System.out.print("Choose an option: ");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                {
                    fw=new FileWriter("e:\\cllg\\sem4\\OOPS\\exe8\\users.txt",true);
                    System.out.print("Enter username: ");
                    String username=sc.nextLine();
                    System.out.print("Enter password: ");
                    String password=sc.nextLine();
                    if(username.isEmpty() || password.isEmpty())
                    {
                        System.out.println("Enter valid username and password");
                        return;
                    }
                    String encryptedPassword=encryptPassword(password);
                    fw.write(username+":"+encryptedPassword+"\n");
                    System.out.println("User stored successfully");
                    break;
                }
                case 2:
                {
                    System.out.print("Enter username: ");
                    String username=sc.nextLine();
                    System.out.print("Enter password: ");
                    String password=sc.nextLine();
                    if(username.isEmpty() || password.isEmpty())
                    {
                        System.out.println("Enter valid username and password");
                        return;
                    }
                    br=new BufferedReader(new FileReader("e:\\cllg\\sem4\\OOPS\\exe8\\users.txt"));
                    String line;
                    boolean found=false;
                    String encryptedPassword=encryptPassword(password);
                    while((line=br.readLine())!=null)
                    {
                        String[] parts=line.split(":",2);
                        if(parts.length==2)
                        {
                            String storedUsername=parts[0];
                            String storedPassword=parts[1];
                            if(storedUsername.equals(username))
                            {
                                if(storedPassword.equals(encryptedPassword))
                                {
                                    System.out.println("Login successful");
                                    found=true;
                                    break;
                                }
                                else
                                {
                                    System.out.println("Invalid password");
                                    found=true;
                                    break;
                                }
                            }
                        }
                    }
                    if(!found)
                    {
                        System.out.println("User not found");
                    }
                    break;
                }
                default:
                {
                    System.out.println("Invalid option");
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found: "+e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println("IO Exception occurred: "+e.getMessage());
        }
        finally
        {
            if(br!=null)
            {
                br.close();
            }
            if(fw!=null)
            {
                fw.close();
            }
            sc.close();
        }
    }
}
//Observation: The program implements a simple user registration and login system. It allows users to register by entering a username and password, which are then encrypted using a basic character shift method and stored in a file. During login, the program reads the stored credentials, encrypts the entered password, and compares it with the stored encrypted password to authenticate the user. The program includes error handling for file operations and ensures resources are properly closed in the finally block.