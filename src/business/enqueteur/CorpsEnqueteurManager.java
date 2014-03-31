/**
 * @author Nathan Marin
 */

package business.enqueteur;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class CorpsEnqueteurManager
{

	// ATTRIBUTES

	/**
	 * Loaded list of CorpsEnqueteur
	 */
	protected ArrayList<CorpsEnqueteur>	listeCorps;

	// CONSTRUCTOR

	public CorpsEnqueteurManager()
	{
		this.listeCorps = new ArrayList<CorpsEnqueteur>();
	}

	// METHODS

	/**
	 * Load CorpsEnqueteur list using a filter
	 * 
	 * @param: filter: A DEFINIR
	 */
	public abstract void loadCorpsEnqueteur(HashMap<String, String> filter);

	// GETTERS

	public ArrayList<CorpsEnqueteur> getListeCorpsEnqueteur()
	{
		return this.listeCorps;
	}

}
