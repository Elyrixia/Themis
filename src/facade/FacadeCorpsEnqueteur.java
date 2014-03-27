package facade;

import java.util.ArrayList;
import java.util.HashMap;

import business.CorpsEnqueteur;
import business.CorpsEnqueteurManager;
import business.ServiceEnqueteur;
import persistence.DBFactory;
import persistence.Factory;

public class FacadeCorpsEnqueteur {

	// ATTRIBUTES
	
	/**
	 * Manager to load entities
	 */
	private CorpsEnqueteurManager ceMng;
	
	// CONSTRUCTOR
	
	public FacadeCorpsEnqueteur() {}
	
	// METHODS
	
	/**
	 * Add a new CorpsEnqueteur
	 * @param: libelle: "libelle" of this new CorpsEnqueteur
	 * @param: services: List of "services" to add to this new CorpsEnqueteur
	 */
	public void ajouterCorpsEnqueteur(String libelle, ArrayList<ServiceEnqueteur> services) throws Exception {
		try {
			Factory fac = DBFactory.getInstance();
			CorpsEnqueteur newCorps = fac.createCorpsEnqueteur();
			
			newCorps.setLibelle(libelle);
			newCorps.setListeServices(services);
			
			newCorps.create();
		} catch(Exception e) {
			throw e;
		}
		
	}
	/**
	 * Edit a CorpsEnqueteur
	 * @param: corps: Entity to edit
	 * @param: libelle: new "libelle" of this CorpsEnqueteur
	 */
	public void modifierCorpsEnqueteur(CorpsEnqueteur corps, String libelle) throws Exception {
		try {
			corps.setLibelle(libelle);
			
			corps.update();
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * Delete a CorpsEnqueteur
	 * @param: corps: Entity to delete
	 */
	public void supprimerCorpsEnqueteur(CorpsEnqueteur corps) throws Exception {
		try {
			corps.delete();
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * Get HashMap containing data of a specific CorpsEnqueteur
	 * @param: corps: Entity to consult
	 */
	public HashMap<String,Object> consulterCorpsEnqueteur(CorpsEnqueteur corps) {
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(":id", corps.getId());
		result.put(":listeServices",corps.getListeServices());
		result.put(":libelle",corps.getLibelle());
		return result;
	}
	
	/**
	 * Load an ArrayList of CorpsEnqueteur using a filter
	 * @param: filter: condition to respect in the query
	 */
	public ArrayList<CorpsEnqueteur> chargerCorpsEnqueteur(HashMap<String,String> filter) {
		ceMng = new CorpsEnqueteurManager();
		ceMng.loadCorpsEnqueteur(filter);
		return ceMng.getListeCorps();
	}
	
}
