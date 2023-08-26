

package genericliraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	private Properties property;
/**
 * this method is used to initialise the properties file
 * @param filePath
 */
	public void propertiesInitialization(String filePath)
	{
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		 property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to read read data from properties file
	 * @param key
	 * @return
	 */
	public String readFromProperties(String key)
	{
	return property.getProperty(key);
	}
}
	



