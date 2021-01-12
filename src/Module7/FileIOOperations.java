package Module7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOOperations {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File ("C:\\Ashish\\study material\\Selenium\\Module7\\temp.txt");
		f.createNewFile();
		
		//Writing the file
		FileWriter w = new FileWriter ("C:\\Ashish\\study material\\Selenium\\Module7\\temp.txt");
		@SuppressWarnings("resource")
		BufferedWriter bufferWriter = new BufferedWriter (w);
		bufferWriter.write("This is a test");
		bufferWriter.newLine();
		bufferWriter.write("This is a second line");
		bufferWriter.newLine();
		bufferWriter.write("This is a third line");
		bufferWriter.newLine();
		bufferWriter.write("This is a fourth line");
		bufferWriter.flush();
		
		//Reading the File
		FileReader r = new FileReader ("C:\\Ashish\\study material\\Selenium\\Module7\\temp.txt");
		@SuppressWarnings("resource")
		BufferedReader bufferReader = new BufferedReader (r);
		String temp = bufferReader.readLine();
		String x = "";
		System.out.println(temp);
		while ((x = bufferReader.readLine())!= null)
		{
			System.out.println(x);
		}
		
	}

}
