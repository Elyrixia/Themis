/**
 * @author Tristan Sallé
 */

package business.affaire;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ObjetManager {

	// ATTRIBUTES

	/**
	 * Loaded list of Objets
	 */
	protected ArrayList<Objet>	listeObjets;

	// CONSTRUCTOR

	public ObjetManager() {
		this.listeObjets = new ArrayList<Objet>();
	}

	// METHODS

	/**
	 * Load Objet list using a filter
	 * 
	 * @param: filter: A DEFINIR
	 */
	public abstract void loadObjet(HashMap<String, String> filter);

	// GETTERS

	public ArrayList<Objet> getListeObjets() {
		return this.listeObjets;
	}
	
}
