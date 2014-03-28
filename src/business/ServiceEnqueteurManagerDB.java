package business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;

public class ServiceEnqueteurManagerDB extends ServiceEnqueteurManager
{

	// CONSTRUCTOR

	public ServiceEnqueteurManagerDB()
	{
		super();
	}

	// METHODS

	/**
	 * Load ServiceEnqueteur list using a filter
	 * 
	 * @param: filter: A DEFINIR
	 */
	public void loadServicesEnqueteur(HashMap<String, String> filter)
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
		ResultSet result = connect.select(ServiceEnqueteurDB.TABLE_NAME, SQLManager.ALL, where);

		// Preparing ArrayList
		try
		{
			Factory fac = DBFactory.getInstance();
			while (result.next())
			{
				// Create new ServiceEnqueteur
				ServiceEnqueteur newService = fac.createServiceEnqueteur();
				// Reading row in SQLResult
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("id", result.getInt("id"));
				row.put("libelle", result.getString("libelle"));
				row.put("telephone", result.getString("telephone"));
				row.put("lieu", result.getString("lieu"));

				// Need to instantiate CorpsEnqueteur to add to the ServiceEnqueteur

				int corps = result.getInt("corps");
				CorpsEnqueteurManager ceMng = new CorpsEnqueteurManagerDB();
				HashMap<String, String> filterCorps = new HashMap<String, String>();
				filterCorps.put("id", "=" + String.valueOf(corps));
				ceMng.loadCorpsEnqueteur(filterCorps);
				ArrayList<CorpsEnqueteur> resultCorps = ceMng.getListeCorpsEnqueteur();
				row.put("corps", resultCorps.get(0));

				// Loading ServiceEnqueteur using values in row
				newService.load(row);
				// Adding ServiceEnqueteur to ArrayList
				this.listeServices.add(newService);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}