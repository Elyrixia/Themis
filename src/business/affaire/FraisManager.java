/**
 * @author Tristan Sallé
 */

package business.affaire;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class FraisManager {

	// ATTRIBUTES

	/**
	 * Loaded list of Frais
	 */
	protected ArrayList<Frais>	listeFrais;

	// CONSTRUCTOR

	public FraisManager() {
		this.listeFrais = new ArrayList<Frais>();
	}

	// METHODS

	/**
	 * Load Frais list using a filter
	 * 
	 * @param: filter: A DEFINIR
	 */
	public abstract void loadFrais(HashMap<String, String> filter);

	// GETTERS

	public ArrayList<Frais> getListeFrais() {
		return this.listeFrais;
	}
	
}
