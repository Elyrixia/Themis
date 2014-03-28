package facade;

import java.util.ArrayList;
import java.util.HashMap;

import persistence.DBFactory;
import persistence.Factory;
import business.affaire.TypeObjet;
import business.affaire.TypeObjetManager;
import business.affaire.TypeObjetManagerDB;

public class FacadeTypeObjet {

	// ATTRIBUTES

	/**
	 * Manager to load entities
	 */
	private TypeObjetManager	toMng;

	// CONSTRUCTOR

	public FacadeTypeObjet() {}

	// METHODS

	/**
	 * Add a new TypeObjet
	 * 
	 * @param: TypeObjet attributes
	 */
	public TypeObjet ajouterTypeObjet(String libelle) throws Exception {
		Factory fac = DBFactory.getInstance();
		TypeObjet newTypeObjet = fac.createTypeObjet();

		newTypeObjet.setLibelle(libelle);

		newTypeObjet.create();

		return newTypeObjet;
	}

	/**
	 * Edit a TypeObjet
	 * 
	 * @param: TypeObjet attributes
	 */
	public void modifierTypeObjet(TypeObjet typeObjet, String libelle) throws Exception {
		typeObjet.setLibelle(libelle);

		typeObjet.update();
	}

	/**
	 * Delete a TypeObjet
	 * 
	 * @param: typeObjet: Entity to delete
	 */
	public void supprimerTypeObjet(TypeObjet typeObjet) throws Exception {
		typeObjet.delete();
	}

	/**
	 * Get HashMap containing data of a specific TypeObjet
	 * 
	 * @param: corps: Entity to consult
	 */
	public HashMap<String, Object> consulterTypeObjet(TypeObjet typeObjet) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("id", typeObjet.getId());
		result.put("libelle", typeObjet.getLibelle());
		return result;
	}

	/**
	 * Load an ArrayList of CorpsEnqueteur using a filter
	 * 
	 * @param: filter: condition to respect in the query
	 */
	public ArrayList<TypeObjet> chargerTypeObjet(HashMap<String, String> filter) {
		toMng = new TypeObjetManagerDB();
		toMng.loadTypeObjet(filter);
		return toMng.getListeTypesObjet();
	}
	
}
