package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Utilitaire {
	
	/**
	 * Converts an array into a String. Each element of the array is separated by the separator param
	 * @param separator
	 * @param data
	 * @return
	 */
	public static String implode(String separator, List<String> data) {
		
		String s = "";
		for(int i = 0; i < data.size(); i++)
			s += data.get(i) + separator;
		
		return s.substring(0, s.length() - 1);
	}
	
	/**
	 * Converts a boolean into a String
	 */
	public static String booleanToString(boolean bool) {
		return bool ? "1" : "0";
	}
	
	/**
	 * 
	 * @param filepath
	 * @return
	 */
	public static Properties getPropertiesFromFile(String filepath) {
		
		Properties prop = new Properties();
		InputStream file = null;
		try {
			file = new FileInputStream(filepath);
			
			// load a properties file
			prop.load(file);
			
			return prop;
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
}
