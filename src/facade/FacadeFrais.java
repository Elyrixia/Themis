package facade;

import java.util.ArrayList;
import java.util.HashMap;

import persistence.DBFactory;
import persistence.Factory;
import business.affaire.Affaire;
import business.affaire.Frais;
import business.affaire.FraisManager;
import business.affaire.FraisManagerDB;

public class FacadeFrais extends FacadeAbstraite {

	//ATTRIBUTES

	/**
	 * Manager to load entities
	 */
	private FraisManager	fMng;

	// CONSTRUCTOR

	public FacadeFrais() {}

	// METHODS
	/**
	 * Add a new Frais
	 * @param: Frais attributes
	 */
	public Frais ajouterFrais(String libelle, int prix, Affaire affaire) throws Exception {
		Factory fac = DBFactory.getInstance();
		Frais newFrais = fac.createFrais();

		newFrais.setLibelle(libelle);
		newFrais.setPrix(prix);
		newFrais.setIdAffaire(affaire);
			
		newFrais.create();

		return newFrais;
	}
	
	/**
	 * Edit a Frais
	 * @param: Frais attributes
	 */
	public void modifierFrais(Frais frais, String libelle, int prix, Affaire affaire) throws Exception {
		frais.setLibelle(libelle);
		frais.setPrix(prix);
		frais.setIdAffaire(affaire);
		
		frais.update();
	}
	
	/**
	 * Delete a Frais
	 * 
	 * @param: frais: Entity to delete
	 */
	public void supprimerFrais(Frais frais) throws Exception {
		frais.delete();
	}
	
	/**
	 * Get HashMap containing data of a specific Frais
	 * 
	 * @param: frais: Entity to consult
	 */
	public HashMap<String, Object> consulterFrais(Frais frais) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		result.put("id", frais.getId());
		result.put("libelle", frais.getLibelle());
		result.put("prix", frais.getPrix());
		result.put("id_affaire", frais.getIdAffaire());
		
		return result;
	}
	
	/**
	 * Load an ArrayList of Frais using a filter
	 * 
	 * @param: filter: condition to respect in the query
	 */
	public ArrayList<Frais> chargerFrais(HashMap<String, String> filter) {
		fMng = new FraisManagerDB();
		fMng.loadFrais(filter);
		return fMng.getListeFrais();
	}
	
}
