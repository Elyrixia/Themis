package common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
		return bool?"1":"0";
	}
	
	/**
	 * Create where condition using the filter
	 */
	public static String getWhere(HashMap<String, String> filter) {
		String where = "";
		
		// Si on a fourni un filtre il va falloir specifier le where
		if (filter.size() > 0) {
			Iterator<String> keySetIterator = filter.keySet().iterator();

			// Premiere condition
			String key = keySetIterator.next();
			where += key + filter.get(key);

			// S'il y en a d'autres
			while (keySetIterator.hasNext())
			{
				where += " AND ";
				key = keySetIterator.next();
				where += key + filter.get(key);
			}
		}
		
		return where;
	}
	
	
}
