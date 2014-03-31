/**
 * @author Nathan Marin
 */

package business.enqueteur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import common.Utilitaire;
import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;

public class CorpsEnqueteurManagerDB extends CorpsEnqueteurManager
{

	// CONSTRUCTOR

	public CorpsEnqueteurManagerDB()
	{
		super();
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

		String where = Utilitaire.getWhere(filter);

		// Sending query
		ResultSet result = connect.select(CorpsEnqueteurDB.TABLE_NAME, where);

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

}