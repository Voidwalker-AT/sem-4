//program to convert all lowercase characters in a file to uppercase and store the result in another file
import java.io.*;
class exe8_3
{
	public static void main(String args[]) throws IOException
	{
		FileReader fr=null;
		FileWriter fw=null;
		try
		{
			fr=new FileReader("e:\\cllg\\sem4\\OOPS\\exe8\\source.txt");
			fw=new FileWriter("e:\\cllg\\sem4\\OOPS\\exe8\\uppercase_output.txt");
			
			int ch;
			int convertCount=0;
			while((ch=fr.read())!=-1)
			{
				char c=(char)ch;
				if(Character.isLowerCase(c))
				{
					c=Character.toUpperCase(c);
					convertCount++;
				}
				fw.write(c);
			}
			System.out.println("Total characters converted: "+convertCount);
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
		}
	}
}
//Observation: The program reads each character from the source file and checks if it is lowercase using Character.isLowerCase(). If lowercase, it converts to uppercase using Character.toUpperCase() and increments a counter. All characters (converted or not) are written to the new file. This demonstrates character-by-character processing and type checking in Java.