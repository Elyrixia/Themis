/**
 * @author Tristan Sallé
 */

package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import persistence.DBFactory;
import persistence.Factory;
import business.affaire.Objet;
import business.affaire.ObjetManager;
import business.affaire.ObjetManagerDB;
import business.affaire.Scelle;
import business.affaire.TypeObjet;

public class FacadeObjet extends FacadeAbstraite {

	// ATTRIBUTES
	
	/**
	 * Manager to load entitites
	 */
	private ObjetManager oMng;
		
	// CONSTRUCTOR
		
	public FacadeObjet() {}
		
	// METHODS
		
	/**
	 * Add a new Scelle
	 * @param: Scelle attributes
	 */
	public Objet ajouterObjet(String libelle, String comment, Scelle idScelle, TypeObjet idType, Objet idObjet) {
			
		Factory fac = DBFactory.getInstance();
		Objet newObjet = fac.createObjet();
			
		newObjet.setLibelle(libelle);
		newObjet.setComment(comment);
		newObjet.setIdScelle(idScelle);
		newObjet.setIdType(idType);
		newObjet.setIdObjet(idObjet);
			
		newObjet.create();
			
		return newObjet;
			
	}
		
	/**
	 * Edit an Objet
	 * @param: Objet attributes
	 */
	public void modifierObjet(Objet objet, String libelle, String comment, Scelle idScelle, TypeObjet idType, Objet idObjet) {
			
		objet.setLibelle(libelle);
		objet.setComment(comment);
		objet.setIdScelle(idScelle);
		objet.setIdType(idType);
		objet.setIdObjet(idObjet);
			
		objet.update();
			
	}
		
	/**
	 * Delete an Objet
	 * @param: objet: Entity to delete
	 */
	public void supprimerObjet(Objet objet) throws Exception {
		objet.delete();
	}
		
	/**
	 * Get HashMap containing data of a specific Objet
	 * @param: objet: Entity to consult
	 */
	public HashMap<String, Object> consulterObjet(Objet objet) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("id", objet.getId());
		result.put("libelle", objet.getLibelle());
		result.put("comment", objet.getComment());
		result.put("id_scelle", objet.getIdScelle());
		result.put("id_type", objet.getIdType());
		if(objet.getIdObjet() == null)
			result.put("id_objet", "Aucun");
		else
			result.put("id_objet", objet.getIdObjet());
		
		return result;
	}

	/**
	 * Get ArrayList<String> containing a toString for each Objet
	 * 
	 * @param: listeObjet: ArrayList to read
	 */
	public ArrayList<String> getApercu(ArrayList<Objet> listeObjets) {
			
		ArrayList<String> listeApercus = new ArrayList<String>();
		Iterator<Objet> it = listeObjets.iterator();
			
		while(it.hasNext()) {
			listeApercus.add(it.next().toString());
		}
			
		return listeApercus;
		
	}
		
	/**
	 * Load an ArrayList of Objet using a filter
	 * 
	 * @param: filter: condition to respect in the query
	 */
	public ArrayList<Objet> chargerObjet(HashMap<String, String> filter)
	{
		oMng = new ObjetManagerDB();
		oMng.loadObjet(filter);
		return oMng.getListeObjets();
	}
	
}
