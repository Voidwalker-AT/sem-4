//program to read a CSV file, extract specific columns, and write filtered data to another file
import java.io.*;
import java.util.Scanner;
public class exe8_11
{
	private static final String INPUT_FILE="data.csv";
	private static final String OUTPUT_FILE="filtered_data.csv";

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		try
		(
			BufferedReader br=new BufferedReader(new FileReader(INPUT_FILE))
		)
		{
			String header=br.readLine();
			if(header==null)
			{
				System.out.println("Input file is empty.");
				return;
			}
			String[] headerColumns=header.split(",");
			System.out.print("Enter number of columns to extract: ");
			if(!sc.hasNextInt())
			{
				System.out.println("Invalid number of columns");
				return;
			}
			int count=sc.nextInt();
			sc.nextLine();
			if(count<=0 || count>headerColumns.length)
			{
				System.out.println("Invalid number of columns");
				return;
			}
			int[] selectedIndexes=new int[count];
			String[] selectedColumns=new String[count];
			for(int i=0;i<count;i++)
			{
				System.out.print("Enter column name "+(i+1)+": ");
				String columnName=sc.nextLine();
				int index=-1;
				for(int j=0;j<headerColumns.length;j++)
				{
					if(headerColumns[j].equalsIgnoreCase(columnName))
					{
						index=j;
						selectedColumns[i]=headerColumns[j];
						break;
					}
				}
				if(index==-1)
				{
					System.out.println("Invalid column name");
					return;
				}
				selectedIndexes[i]=index;
			}
			try
			(
				FileWriter fw=new FileWriter(OUTPUT_FILE)
			)
			{
				for(int i=0;i<count;i++)
				{
					fw.write(selectedColumns[i]);
					if(i<count-1)
					{
						fw.write(",");
					}
				}
				fw.write("\n");
				String line;
				while((line=br.readLine())!=null)
				{
					String[] columns=line.split(",");
					if(columns.length>=headerColumns.length)
					{
						String filteredLine="";
						for(int i=0;i<count;i++)
						{
							filteredLine+=columns[selectedIndexes[i]];
							if(i<count-1)
							{
								filteredLine+=",";
							}
						}
						fw.write(filteredLine+"\n");
					}
				}
			}
			System.out.println("Filtered data written to "+OUTPUT_FILE);
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
			sc.close();
		}
	}
}
//Observation: The program reads a CSV file, prompts the user to select specific columns by name, and writes the filtered data to a new CSV file. It handles various edge cases such as invalid column names and ensures proper resource management using try-with-resources for file handling and a finally block for closing the scanner. The program also includes error handling for file-related exceptions.