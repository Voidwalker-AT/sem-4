//program to merge the contents of two or more files into a single file
import java.io.*;
class exe8_5
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br1=null;
		BufferedReader br2=null;
		FileWriter fw=null;
		try
		{
			br1=new BufferedReader(new FileReader("e:\\cllg\\sem4\\OOPS\\exe8\\source.txt"));
			br2=new BufferedReader(new FileReader("e:\\cllg\\sem4\\OOPS\\exe8\\source.txt"));
			fw=new FileWriter("e:\\cllg\\sem4\\OOPS\\exe8\\merged_output.txt");
			String line;
			while((line=br1.readLine())!=null)
			{
				fw.write(line+"\n");
			}
			while((line=br2.readLine())!=null)
			{
				fw.write(line+"\n");
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
			if(br1!=null)
			{
				br1.close();
			}
			if(br2!=null)
			{
				br2.close();
			}
			if(fw!=null)
			{
				fw.close();
			}
		}
	}
}
//Observation: The program uses two BufferedReader objects to read from two source files and a FileWriter to write to the merged output file. It reads each line from both source files and writes them to the output file, effectively merging their contents. The use of try-catch-finally ensures that resources are properly closed even if exceptions occur during file operations.