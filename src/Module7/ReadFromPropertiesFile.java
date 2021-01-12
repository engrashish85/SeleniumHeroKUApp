package Module7;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Retrieve the current project directory
		System.out.println(System.getProperty("user.dir"));
		Properties prop = new Properties();
		FileInputStream readFile = new FileInputStream ("C:\\ashish\\Training\\Selenium\\Web Driver\\SeleniumTraining_AshishThakur\\src\\Module7\\Config\\Employee.properties");
		prop.load(readFile);
		System.out.println(prop.getProperty("Emp_ID"));
		System.out.println(prop.getProperty("Emp_Company"));
		System.out.println(prop.getProperty("Emp_Duration"));
		System.out.println(prop.getProperty("Emp_Favorite_Company"));
	}
}
