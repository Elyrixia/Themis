package business;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceEnqueteurManager {

	// ATTRIBUTES
	
	/**
	 * Loaded list of ServiceEnqueteur
	 */
	private ArrayList<ServiceEnqueteur> listeServicesEnqueteur;
		
	// CONSTRUCTOR
		
	public ServiceEnqueteurManager() {
		this.listeServicesEnqueteur = new ArrayList<ServiceEnqueteur>();
	}
		
	// METHODS
		
	/**
	 * Load ServiceEnqueteur list using a filter
	 * @param: filter: A DEFINIR
	 */
	public void loadServicesEnqueteur(HashMap<String,String> filter) {}
		
	// GETTERS
	
	public ArrayList<ServiceEnqueteur> getListeServicesEnqueteur() {
			return this.listeServicesEnqueteur;
		}
}
