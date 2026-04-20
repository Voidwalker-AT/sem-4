//program to store and retrieve student records (ID, Name, Marks) using a file
import java.io.*;
import java.util.Scanner;
class exe8_8
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		BufferedReader br=null;
		FileWriter fw=null;
		try
		{
			System.out.println("1. Add Student Records");
			System.out.println("2. View Student Records");
			System.out.print("Choose an option: ");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
				case 1:
					System.out.print("Enter number of students: ");
					int n=sc.nextInt();
					sc.nextLine();
					if(n<=0)
					{
						System.out.println("Enter a valid number");
						return;
					}
					fw=new FileWriter("e:\\cllg\\sem4\\OOPS\\exe8\\students.txt",true);
					for(int i=0;i<n;i++)
					{
						System.out.println("Student "+(i+1)+":");
						System.out.print("ID: ");
						String id=sc.nextLine();
						System.out.print("Name: ");
						String name=sc.nextLine();
						System.out.print("Marks: ");
						String marks=sc.nextLine();
						fw.write(id+","+name+","+marks+"\n");
					}
					break;
				case 2:
					File file=new File("e:\\cllg\\sem4\\OOPS\\exe8\\students.txt");
					if(!file.exists() || file.length()==0)
					{
						System.out.println("No student records found");
						return;
					}
					br=new BufferedReader(new FileReader(file));
					System.out.println("ID\tName\tMarks");
					String line;
					while((line=br.readLine())!=null)
					{
						String[] parts=line.split(",");
						if(parts.length==3)
						{
							System.out.println(parts[0]+"\t"+parts[1]+"\t"+parts[2]);
						}
					}
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
//Observation: The program allows the user to either add student records or view existing records. When adding records, it prompts for the number of students and their details (ID, Name, Marks) and appends them to a file. When viewing records, it reads from the file and displays the contents in a tabular format. The program includes error handling for file operations and ensures resources are properly closed in the finally block.