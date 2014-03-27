package business;

import java.util.ArrayList;
import java.util.HashMap;

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
	 * Permet d'ajouter un nouveau corps d'enqueteur
	 * @libelle: Le libelle de ce corps
	 * @titres: La liste des titres lies a ce corps
	 */
	public void ajouterCorpsEnqueteur(String libelle, ArrayList<TitreEnqueteur> titres) throws Exception {
		try {
			Factory fac = DBFactory.getInstance();
			CorpsEnqueteur newCorps = fac.createCorpsEnqueteur();
			newCorps.create();
		} catch(Exception e) {
			throw e;
		}
		
	}
	/**
	 * Permet de modifier un corps d'enqueteur existant
	 * @corps: L'entite a modifier
	 * @libelle: Le nouveau libelle de ce corps
	 */
	public void modifierCorpsEnqueteur(CorpsEnqueteur corps, String libelle) throws Exception {
		try {
			corps.setLibelle(libelle);
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * Permet de supprimer un corps d'enqueteur existant
	 * @corps: L'entite a supprimer
	 */
	public void supprimerCorpsEnqueteur(CorpsEnqueteur corps) throws Exception {
		try {
			corps.delete();
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * ?
	 */
	public HashMap<String,Object> consulterCorpsEnqueteur(CorpsEnqueteur corps) {
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(":libelle",corps.getLibelle());
		return result;
	}
	
	/**
	 * Permet de charger les corps d'enqueteur souhaites en fonction du filtre a appliquer
	 * @filter: Le filtre a appliquer
	 */
	public ArrayList<CorpsEnqueteur> chargerCorpsEnqueteur(HashMap filter) {
		ceMng = new CorpsEnqueteurManager();
		ceMng.loadCorpsEnqueteur(filter);
		return ceMng.getListeCorps();
	}
	
}
