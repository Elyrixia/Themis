package business;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ScelleManager {

	// ATTRIBUTES

	/**
	 * Loaded list of Scelles
	 */
	protected ArrayList<Scelle>	listeScelles;

	// CONSTRUCTOR

	public ScelleManager()
	{
		this.listeScelles = new ArrayList<Scelle>();
	}

	// METHODS

	/**
	 * Load Scelles list using a filter
	 * 
	 * @param: filter: A DEFINIR
	 */
	public abstract void loadScelle(HashMap<String, String> filter);

	// GETTERS

	public ArrayList<Scelle> getListeScelles()
	{
		return this.listeScelles;
	}
		
}
