package datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataToproperties {

	public static void main(String[] args) throws IOException {
		//convert physical file to java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/data.properties");
		//step:2Create an instance for properties class
		Properties property=new Properties();
		//step:3 load all key-value pairs to properties object from fis
		property.load(fis);
		//step:4 write data into properties
		property.put("username2","trainee");
		property.put("password","trainee");
		//step:5 save properties
		FileOutputStream fos=new FileOutputStream("./src/test/resources/data.properties");
		property.store(fos, "updated file successfully");
		
	}

}
