//program to search for a keyword in a file and display line numbers and total occurrences
import java.io.*;
import java.util.Scanner;
class exe8_6
{
	static boolean isWordCharacter(char ch)
	{
		if(Character.isLetterOrDigit(ch) || ch=='_')
		{
			return true;
		}
		return false;
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=null;
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.print("Enter the keyword to search: ");
			String keyword=sc.nextLine();
			if(keyword.isEmpty())
			{
				System.out.println("Enter a valid word");
				return;
			}
			br=new BufferedReader(new FileReader("e:\\cllg\\sem4\\OOPS\\exe8\\source.txt"));
			String line;
			int lineNumber=0;
			int totalOccurrences=0;
			StringBuilder result=new StringBuilder();
			while((line=br.readLine())!=null)
			{
				lineNumber++;
				boolean foundInLine=false;
				int start=0;
				int index;
				while((index=line.indexOf(keyword,start))!=-1)
				{
					boolean validStart=false;
					boolean validEnd=false;
					if(index==0 || !isWordCharacter(line.charAt(index-1)))
					{
						validStart=true;
					}
					int end=index+keyword.length();
					if(end==line.length() || !isWordCharacter(line.charAt(end)))
					{
						validEnd=true;
					}
					if(validStart && validEnd)
					{
						totalOccurrences++;
						foundInLine=true;
					}
					start=end;
				}
				if(foundInLine)
				{
					result.append(lineNumber).append(": ").append(line).append("\n");
				}
			}
			if(totalOccurrences==0)
			{
				System.out.println("Word not present in the file");
				return;
			}
			System.out.println("Word present in the file");
			System.out.print(result.toString());
			System.out.println("Total occurrences: "+totalOccurrences);
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
			sc.close();
		}
	}
}
//Observation: The program reads a keyword from the user input using BufferedReader and then searches for it in the file. It displays the line numbers and total occurrences of the keyword in the file.