package co.uk.amazon.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	public Properties properties = null;
	
	public PropertiesUtil(String file) throws IOException, FileNotFoundException{
		properties = new Properties();
		properties.load(new FileInputStream(new File(file)));
	}
	
	public String getValue(String propertyKey) {
		return properties.getProperty(propertyKey);
	}
}
