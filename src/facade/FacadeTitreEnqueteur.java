package facade;

import java.util.ArrayList;
import java.util.HashMap;

import persistence.DBFactory;
import persistence.Factory;
import business.TitreEnqueteur;
import business.TitreEnqueteurManager;
import business.TitreEnqueteurManagerDB;

public class FacadeTitreEnqueteur {

	// ATTRIBUTES
	
	/**
	 * Manager to load entities
	 */
	private TitreEnqueteurManager teMng;
		
	// CONSTRUCTOR
		
	public FacadeTitreEnqueteur() {}
		
	// METHODS
		
	/**
	 * Add a new TitreEnqueteur
	 * @param: Titre attributes
	 */
	public TitreEnqueteur ajouterTitreEnqueteur(String libelle) throws Exception {
		Factory fac = DBFactory.getInstance();
		TitreEnqueteur newTitre = fac.createTitreEnqueteur();
			
		newTitre.setLibelle(libelle);
			
		newTitre.create();
				
		return newTitre;
	}
		
	/**
	 * Edit a TitreEnqueteur
	 * @param: Titre attributes
	 */
	public void modifierTitreEnqueteur(TitreEnqueteur titre, String libelle) throws Exception {
		titre.setLibelle(libelle);
				
		titre.update();
	}
		
	/**
	 * Delete a TitreEnqueteur
	 * @param: titre: Entity to delete
	 */
	public void supprimerTitreEnqueteur(TitreEnqueteur titre) throws Exception {
		titre.delete();
	}
		
	/**
	 * Get HashMap containing data of a specific TitreEnqueteur
	 * @param: titre: Entity to consult
	 */
	public HashMap<String,Object> consulterTitreEnqueteur(TitreEnqueteur titre) {
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("id", titre.getId());
		result.put("libelle", titre.getLibelle());
		return result;
	}
		
	/**
	 * Load an ArrayList of TitreEnqueteur using a filter
	 * @param: filter: condition to respect in the query
	 */
	public ArrayList<TitreEnqueteur> chargerTitreEnqueteur(HashMap<String,String> filter) {
		teMng = new TitreEnqueteurManagerDB();
		teMng.loadTitresEnqueteur(filter);
		return teMng.getListeTitresEnqueteur();
	}
	
}
