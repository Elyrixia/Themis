/**
 * @author Alexandre Laffaille
 */

package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import persistence.DBFactory;
import persistence.Factory;
import business.enqueteur.TitreEnqueteur;
import business.enqueteur.TitreEnqueteurManager;
import business.enqueteur.TitreEnqueteurManagerDB;

public class FacadeTitreEnqueteur extends FacadeAbstraite {

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
		result.put("nombre d'enqueteurs avec ce titre", titre.getNbEnqueteurs());
		return result;
	}
		
	/**
	 * Get ArrayList<String> containing a toString for each TitreEnqueteur
	 * 
	 * @param: listeTitresEnqueteur: ArrayList to read
	 */
	public ArrayList<String> getApercu(ArrayList<TitreEnqueteur> listeTitresEnqueteur) {
		
		ArrayList<String> listeApercus = new ArrayList<String>();
		Iterator<TitreEnqueteur> it = listeTitresEnqueteur.iterator();
		
		while(it.hasNext()) {
			listeApercus.add(it.next().toString());
		}
		
		return listeApercus;
		
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
