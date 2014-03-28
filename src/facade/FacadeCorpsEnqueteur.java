package facade;

import java.util.ArrayList;
import java.util.HashMap;

import persistence.DBFactory;
import persistence.Factory;
import business.enqueteur.CorpsEnqueteur;
import business.enqueteur.CorpsEnqueteurManager;
import business.enqueteur.CorpsEnqueteurManagerDB;

public class FacadeCorpsEnqueteur
{

	// ATTRIBUTES

	/**
	 * Manager to load entities
	 */
	private CorpsEnqueteurManager	ceMng;

	// CONSTRUCTOR

	public FacadeCorpsEnqueteur()
	{
	}

	// METHODS

	/**
	 * Add a new CorpsEnqueteur
	 * 
	 * @param: libelle: "libelle" of this new CorpsEnqueteur
	 * @param: services: List of "services" to add to this new CorpsEnqueteur
	 */
	public CorpsEnqueteur ajouterCorpsEnqueteur(String libelle) throws Exception
	{
		Factory fac = DBFactory.getInstance();
		CorpsEnqueteur newCorps = fac.createCorpsEnqueteur();

		newCorps.setLibelle(libelle);

		newCorps.create();

		return newCorps;
	}

	/**
	 * Edit a CorpsEnqueteur
	 * 
	 * @param: corps: Entity to edit
	 * @param: libelle: new "libelle" of this CorpsEnqueteur
	 */
	public void modifierCorpsEnqueteur(CorpsEnqueteur corps, String libelle) throws Exception
	{
		corps.setLibelle(libelle);

		corps.update();
	}

	/**
	 * Delete a CorpsEnqueteur
	 * 
	 * @param: corps: Entity to delete
	 */
	public void supprimerCorpsEnqueteur(CorpsEnqueteur corps) throws Exception
	{
		corps.delete();
	}

	/**
	 * Get HashMap containing data of a specific CorpsEnqueteur
	 * 
	 * @param: corps: Entity to consult
	 */
	public HashMap<String, Object> consulterCorpsEnqueteur(CorpsEnqueteur corps)
	{
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("id", corps.getId());
		result.put("libelle", corps.getLibelle());
		return result;
	}

	/**
	 * Load an ArrayList of CorpsEnqueteur using a filter
	 * 
	 * @param: filter: condition to respect in the query
	 */
	public ArrayList<CorpsEnqueteur> chargerCorpsEnqueteur(HashMap<String, String> filter)
	{
		ceMng = new CorpsEnqueteurManagerDB();
		ceMng.loadCorpsEnqueteur(filter);
		return ceMng.getListeCorpsEnqueteur();
	}

}
