//program to read data from one file and write it into another file using FileReader and FileWriter
import java.io.*;
class exe8_1
{
	public static void main(String args[]) throws IOException
	{
		FileReader fr=null;
		FileWriter fw=null;
		try
		{
			fr=new FileReader("e:\\cllg\\sem4\\OOPS\\exe8\\source.txt");
			fw=new FileWriter("e:\\cllg\\sem4\\OOPS\\exe8\\destination.txt");
			
			int ch;
			int charCount=0;
			while((ch=fr.read())!=-1)
			{
				fw.write(ch);
				charCount++;
			}
			System.out.println("Total characters copied: "+charCount);
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
//Observation: The program opens a source file using FileReader and destination file using FileWriter. It reads text from source file character by character using the read() method which returns -1 when end of file is reached. Each character is written to destination file using write() method. Both files are properly closed in the finally block to ensure resources are released. Exception handling is used to catch FileNotFoundException and IOException. A character counter tracks the total characters copied.