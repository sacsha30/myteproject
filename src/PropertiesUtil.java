package accentureutils.myte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	private static Properties getPropertiesFile() {
		Properties properties = new Properties();
		FileInputStream fip = null;
		try {
			fip = new FileInputStream(new File("myte.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(fip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}
	
	public static String getProperty(String propertyName) {
		return getPropertiesFile().getProperty(propertyName);
	}

}
