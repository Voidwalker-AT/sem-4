//program to analyze a log file and count ERROR, WARNING, and INFO messages
import java.io.*;
class exe8_10
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=null;
		try
		{
			FileWriter fw=new FileWriter("e:\\cllg\\sem4\\OOPS\\exe8\\log_file.txt");
			fw.write("[INFO] Application started\n");
			fw.write("[ERROR] Database connection failed\n");
			fw.write("[WARNING] Low memory detected\n");
			fw.write("[INFO] User login successful\n");
			fw.write("[ERROR] Invalid user credentials\n");
			fw.write("[WARNING] Cache full, clearing old data\n");
			fw.write("[INFO] File uploaded successfully\n");
			fw.write("[ERROR] Network timeout\n");
			fw.write("[WARNING] Disk space low\n");
			fw.close();
			br=new BufferedReader(new FileReader("e:\\cllg\\sem4\\OOPS\\exe8\\log_file.txt"));
			int errorCount=0;
			int warningCount=0;
			int infoCount=0;
			String line;
			while((line=br.readLine())!=null)
			{
				if(line.contains("[ERROR]"))
				{
					errorCount++;
					System.out.println(line);
				}
				else if(line.contains("[WARNING]"))
				{
					warningCount++;
					System.out.println(line);
				}
				else if(line.contains("[INFO]"))
				{
					infoCount++;
				}
			}
			System.out.println("INFO messages: "+infoCount);
			System.out.println("WARNING messages: "+warningCount);
			System.out.println("ERROR messages: "+errorCount);
			System.out.println("Total messages: "+(errorCount+warningCount+infoCount));
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
		}
	}
}
//Observation: The program creates a log file with sample log messages categorized as INFO, WARNING, and ERROR. It then reads the file line by line, counts the occurrences of each type of message, and prints the messages along with the counts. The use of try-catch-finally ensures that resources are properly managed and exceptions are handled gracefully during file operations.