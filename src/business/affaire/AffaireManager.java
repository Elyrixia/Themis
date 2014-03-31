/**
 * @author Alexandre Laffaille, Nathan Marin, Benoit Ruiz, Tristan Sallé
 */

package business.affaire;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AffaireManager {

	// ATTRIBUTES

	/**
	 * Loaded list of Affaires
	 */
	protected ArrayList<Affaire>	listeAffaires;

	// CONSTRUCTOR

	public AffaireManager()
	{
		this.listeAffaires = new ArrayList<Affaire>();
	}

	// METHODS

	/**
	 * Load Affaire list using a filter
	 * 
	 * @param: filter: A DEFINIR
	 */
	public abstract void loadAffaire(HashMap<String, String> filter);

	// GETTERS

	public ArrayList<Affaire> getListeAffaires()
	{
		return this.listeAffaires;
	}
	
}
