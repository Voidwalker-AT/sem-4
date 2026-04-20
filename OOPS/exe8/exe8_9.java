//program to encrypt and decrypt file data using a simple technique
import java.io.*;
import java.util.Scanner;
class exe8_9
{
	public static void main(String args[]) throws IOException
	{
		FileReader fr=null;
		FileWriter fw=null;
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.println("1. Encrypt File");
			System.out.println("2. Decrypt File");
			System.out.print("Choose an option: ");
			int choice=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter encryption key (number): ");
			int key=sc.nextInt();
			switch(choice)
			{
				case 1:
					fr=new FileReader("e:\\cllg\\sem4\\OOPS\\exe8\\source.txt");
					fw=new FileWriter("e:\\cllg\\sem4\\OOPS\\exe8\\encrypted_output.txt");
					int ch;
					int encryptCount=0;
					while((ch=fr.read())!=-1)
					{
						char c=(char)ch;
						if(Character.isLetter(c))
						{
							c=(char)(c+key);
							encryptCount++;
						}
						fw.write(c);
					}
					System.out.println("Total characters encrypted: "+encryptCount);
					break;
				case 2:
					fr=new FileReader("e:\\cllg\\sem4\\OOPS\\exe8\\encrypted_output.txt");
					fw=new FileWriter("e:\\cllg\\sem4\\OOPS\\exe8\\decrypted_output.txt");
					int ch1;
					int decryptCount=0;
					while((ch1=fr.read())!=-1)
					{
						char c=(char)ch1;
						if(c>'A' && c<'z')
						{
							c=(char)(c-key);
							decryptCount++;
						}
						fw.write(c);
					}
					System.out.println("Total characters decrypted: "+decryptCount);
					break;
				default:
					System.out.println("Invalid option");
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
			if(fr!=null)
			{
				fr.close();
			}
			if(fw!=null)
			{
				fw.close();
			}
			sc.close();
		}
	}
}
//Observation: The program provides a simple encryption and decryption mechanism using a user-defined key. It reads characters from the source file, checks if they are letters, and shifts their ASCII values by the key to encrypt or decrypt them. The encrypted or decrypted characters are written to new files. The program also counts the number of characters processed and includes error handling for file operations.