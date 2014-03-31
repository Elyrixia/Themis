/**
 * @author Alexandre Laffaille
 */

package business.enqueteur;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class EnqueteurManager
{

	// ATTRIBUTES

	/**
	 * Loaded list of Enqueteur
	 */
	protected ArrayList<Enqueteur>	listeEnqueteurs;

	// CONSTRUCTOR

	public EnqueteurManager()
	{
		this.listeEnqueteurs = new ArrayList<Enqueteur>();
	}

	// METHODS

	/**
	 * Load Enqueteur list using a filter
	 * 
	 * @param: filter: A DEFINIR
	 */
	public abstract void loadEnqueteurs(HashMap<String, String> filter);

	// GETTERS

	public ArrayList<Enqueteur> getListeEnqueteurs()
	{
		return this.listeEnqueteurs;
	}

}