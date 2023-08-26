
package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties {

	public static void main(String[] args) throws IOException {
		//convert physical file to java readable object
				FileInputStream fis=new FileInputStream("./src/test/resources/data.properties");
				//step:2Create an instance for properties class
				Properties property=new Properties();
				//step:3 load all key-value pairs to properties object from fis
				property.load(fis);
				//step:4 fetch data from properties using key
				System.out.println(property.getProperty("url"));
				System.out.println(property.getProperty("browser"));
				System.out.println(property.getProperty("time"));
				

	}

}
