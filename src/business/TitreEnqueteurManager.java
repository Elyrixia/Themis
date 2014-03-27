package business;

import java.util.ArrayList;
import java.util.HashMap;

public class TitreEnqueteurManager {

	// ATTRIBUTES
	
	/**
	 * Loaded list of TitreEnqueteur
	 */
	private ArrayList<TitreEnqueteur> listeTitresEnqueteur;
			
	// CONSTRUCTOR
			
	public TitreEnqueteurManager() {
		this.listeTitresEnqueteur = new ArrayList<TitreEnqueteur>();
	}
			
	// METHODS
			
	/**
	 * Load TitreEnqueteur list using a filter
	 * @param: filter: A DEFINIR
	 */
	public void loadTitresEnqueteur(HashMap<String,String> filter) {}
			
	// GETTERS
		
	public ArrayList<TitreEnqueteur> getListeTitresEnqueteur() {
			return this.listeTitresEnqueteur;
	}
	
}
