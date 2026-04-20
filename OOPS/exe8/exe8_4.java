//program to remove extra spaces, leading spaces, and trailing spaces from a file
import java.io.*;
class exe8_4
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=null;
		FileWriter fw=null;
		try
		{
			br=new BufferedReader(new FileReader("e:\\cllg\\sem4\\OOPS\\exe8\\source.txt"));
			fw=new FileWriter("e:\\cllg\\sem4\\OOPS\\exe8\\cleaned_output.txt");			
			String line;
			int lineCount=0;
			while((line=br.readLine())!=null)
			{
				lineCount++;
				String trimmed=line.trim();
				
				String cleaned=trimmed.replaceAll("\\s+"," ");
				if(!cleaned.isEmpty())
				{
					fw.write(cleaned +"\n");
				}
			}
			System.out.println("Cleaning completed");
			System.out.println("Total lines processed: "+lineCount);
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
		}
	}
}
//Observation: The program reads the file line by line and uses trim() to remove leading and trailing spaces from each line. The replaceAll("\\s+", " ") method replaces multiple consecutive spaces with a single space. Empty lines are skipped. This demonstrates string manipulation techniques for cleaning text data.