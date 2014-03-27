package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import persistence.SQLManager;

public class CorpsEnqueteurManager {

	// ATTRIBUTES
	
	/**
	 * La liste des corps charges
	 */
	private ArrayList<CorpsEnqueteur> listeCorps;
	
	// CONSTRUCTOR
	
	public CorpsEnqueteurManager() {
		this.listeCorps = new ArrayList<CorpsEnqueteur>();
	}
	
	// METHODS
	
	/**
	 * Permet de charger la liste des corps en fonction d'un filtre
	 * @filter: A DEFINIR
	 */
	public void loadCorpsEnqueteur(HashMap<String,String> filter) {
		SQLManager connect = SQLManager.getConnection();
		
		String query = "SELECT * FROM CorpsEnqueteur";
		
		// Si on a fourni un filtre il va falloir specifier le where
		if(filter.size() > 0) {
			query += " WHERE ";
			
			Iterator<String> keySetIterator = filter.keySet().iterator();
			
			// Premiere condition
			String key = keySetIterator.next();
			query += key + filter.get(key);
			
			// S'il y en a d'autres
			while(keySetIterator.hasNext()) {
				query += " AND ";
				key = keySetIterator.next();
				query += key + filter.get(key);
			}
		}
		
		System.out.println(query);
	}
	
	public ArrayList<CorpsEnqueteur> getListeCorps() {
		return this.listeCorps;
	}
	
}
