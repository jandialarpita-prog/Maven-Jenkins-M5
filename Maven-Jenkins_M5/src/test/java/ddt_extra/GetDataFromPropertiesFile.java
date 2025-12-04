package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	
	public static void main(String[] args) throws IOException {
		//1. Get the Java Representation Object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		
		//2. Use the load() of properties class and load all the keys
		Properties pobj = new Properties();
		pobj.load(fis);
		
		//3. Use the get property() and pass the key and get the value in String format
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		
	}

}
