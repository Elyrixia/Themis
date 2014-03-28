package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import persistence.SQLManager;

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
	
	/*
	 * Create where condition using the filter
	 */
	public static String getWhere(HashMap<String, String> filter) {
		String where = SQLManager.NO_WHERE;
		
		// Si on a fourni un filtre il va falloir specifier le where
		if (filter.size() > 0) {
			where = "";
			
			Iterator<String> keySetIterator = filter.keySet().iterator();

			// Premiere condition
			String key = keySetIterator.next();
			where += key + filter.get(key);

			// S'il y en a d'autres
			while (keySetIterator.hasNext())
			{
				where += " OR ";
				key = keySetIterator.next();
				where += key + filter.get(key);
			}
		}
		
		return where;
	}
}
