//program to replace all occurrences of a word in a file with another word
import java.io.*;
import java.util.Scanner;
class exe8_7
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
		FileWriter fw=null;
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.print("Enter the word to find: ");
			String findWord=sc.nextLine();
			System.out.print("Enter the word to replace with: ");
			String replaceWord=sc.nextLine();
			if(findWord.isEmpty())
			{
				System.out.println("Enter a valid word");
				return;
			}
			br=new BufferedReader(new FileReader("e:\\cllg\\sem4\\OOPS\\exe8\\source.txt"));
			String line;
			int totalReplacements=0;
			StringBuilder output=new StringBuilder();
			while((line=br.readLine())!=null)
			{
				StringBuilder modifiedLine=new StringBuilder();
				int start=0;
				int index;
				while((index=line.indexOf(findWord,start))!=-1)
				{
					boolean validStart=false;
					boolean validEnd=false;
					if(index==0 || !isWordCharacter(line.charAt(index-1)))
					{
						validStart=true;
					}
					int end=index+findWord.length();
					if(end==line.length() || !isWordCharacter(line.charAt(end)))
					{
						validEnd=true;
					}
					if(validStart && validEnd)
					{
						modifiedLine.append(line.substring(start,index));
						modifiedLine.append(replaceWord);
						totalReplacements++;
						start=end;
					}
					else
					{
						modifiedLine.append(line.substring(start,end));
						start=end;
					}
				}
				modifiedLine.append(line.substring(start));
				output.append(modifiedLine).append("\n");
			}
			if(totalReplacements==0)
			{
				System.out.println("Word not present in the file");
				return;
			}
			System.out.println("Word present in the file");
			fw=new FileWriter("e:\\cllg\\sem4\\OOPS\\exe8\\replaced_output.txt");
			fw.write(output.toString());
			System.out.println("Total replacements made: "+totalReplacements);
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
//Observations:the program reads a source file line by line, checks for occurrences of the specified word, and replaces it with the new word only if it is a standalone word (not part of another word). It keeps track of the total replacements made and writes the modified content to a new file. The program also handles exceptions related to file operations and ensures resources are closed properly in the finally block.