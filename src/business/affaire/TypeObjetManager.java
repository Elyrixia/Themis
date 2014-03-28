package business.affaire;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class TypeObjetManager {

	// ATTRIBUTES

	/**
	 * Loaded list of TypesObjet
	 */
	protected ArrayList<TypeObjet>	listeTypesObjet;

	// CONSTRUCTOR

	public TypeObjetManager() {
		this.listeTypesObjet = new ArrayList<TypeObjet>();
	}

	// METHODS

	/**
	 * Load TypeObjet list using a filter
	 * 
	 * @param: filter: A DEFINIR
	 */
	public abstract void loadTypeObjet(HashMap<String, String> filter);

	// GETTERS

	public ArrayList<TypeObjet> getListeTypesObjet() {
		return this.listeTypesObjet;
	}
	
}
