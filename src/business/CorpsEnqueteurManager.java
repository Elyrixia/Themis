package business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;

public class CorpsEnqueteurManager
{

	// ATTRIBUTES

	/**
	 * Loaded list of CorpsEnqueteur
	 */
	private ArrayList<CorpsEnqueteur>	listeCorps;

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
	public void loadCorpsEnqueteur(HashMap<String, String> filter)
	{
		SQLManager connect = SQLManager.getConnection();

		String where = "";

		// Si on a fourni un filtre il va falloir specifier le where
		if (filter.size() > 0)
		{
			Iterator<String> keySetIterator = filter.keySet().iterator();

			// Premiere condition
			String key = keySetIterator.next();
			where += key + filter.get(key);

			// S'il y en a d'autres
			while (keySetIterator.hasNext())
			{
				where += " AND ";
				key = keySetIterator.next();
				where += key + filter.get(key);
			}
		}

		// Sending query
		ResultSet result = connect.select(CorpsEnqueteurDB.TABLE_NAME, SQLManager.ALL, where);

		// Preparing ArrayList
		try
		{
			Factory fac = DBFactory.getInstance();
			while (result.next())
			{
				// Create new CorpsEnqueteur
				CorpsEnqueteur newCorps = fac.createCorpsEnqueteur();
				
				// Reading row in SQLResult
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("id", result.getInt("id"));
				row.put("libelle", result.getString("libelle"));
				
				// Loading CorpsEnqueteur using values in row
				newCorps.load(row);
				
				// Adding CorpsEnqueteur to ArrayList
				this.listeCorps.add(newCorps);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// GETTERS

	public ArrayList<CorpsEnqueteur> getListeCorpsEnqueteur()
	{
		return this.listeCorps;
	}

}
