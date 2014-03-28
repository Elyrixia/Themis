package business;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ServiceEnqueteurManager
{

	// ATTRIBUTES

	/**
	 * Loaded list of ServiceEnqueteur
	 */
	protected ArrayList<ServiceEnqueteur>	listeServices;

	// CONSTRUCTOR

	public ServiceEnqueteurManager()
	{
		this.listeServices = new ArrayList<ServiceEnqueteur>();
	}

	// METHODS

	/**
	 * Load ServiceEnqueteur list using a filter
	 * 
	 * @param: filter: A DEFINIR
	 */
	public abstract void loadServicesEnqueteur(HashMap<String, String> filter);

	// GETTERS

	public ArrayList<ServiceEnqueteur> getListeServicesEnqueteur()
	{
		return this.listeServices;
	}
}
