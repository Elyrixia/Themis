package business;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class TitreEnqueteurManager
{

	// ATTRIBUTES

	/**
	 * Loaded list of TitreEnqueteur
	 */
	protected ArrayList<TitreEnqueteur>	listeTitres;

	// CONSTRUCTOR

	public TitreEnqueteurManager()
	{
		this.listeTitres = new ArrayList<TitreEnqueteur>();
	}

	// METHODS

	/**
	 * Load TitreEnqueteur list using a filter
	 * 
	 * @param: filter: A DEFINIR
	 */
	public abstract void loadTitresEnqueteur(HashMap<String, String> filter);

	// GETTERS

	public ArrayList<TitreEnqueteur> getListeTitresEnqueteur()
	{
		return this.listeTitres;
	}

}
