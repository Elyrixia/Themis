package common;

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
}
