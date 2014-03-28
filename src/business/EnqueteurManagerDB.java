package business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;

public class EnqueteurManagerDB extends EnqueteurManager
{

	// CONSTRUCTOR

	public EnqueteurManagerDB()
	{
		super();
	}

	// METHODS

	/**
	 * Load Enqueteur list using a filter
	 * 
	 * @param: filter: A DEFINIR
	 */
	public void loadEnqueteurs(HashMap<String, String> filter)
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
		ResultSet result = connect.select(EnqueteurDB.TABLE_NAME, SQLManager.ALL, where);

		// Preparing ArrayList
		try
		{
			Factory fac = DBFactory.getInstance();
			while (result.next())
			{
				// Create new CorpsEnqueteur
				Enqueteur newEnqueteur = fac.createEnqueteur();
				// Reading row in SQLResult
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("id", result.getInt("id"));
				row.put("nom", result.getString("nom"));
				row.put("prenom", result.getString("prenom"));
				row.put("adresse", result.getString("adresse"));
				row.put("telephonePro", result.getString("telephonePro"));
				row.put("telephonePerso", result.getString("telephonePerso"));
				row.put("email", result.getString("email"));
				row.put("faxPro", result.getString("faxPro"));

				// Need to instantiate TitreEnqueteur to add to the Enqueteur

				int titre = result.getInt("titre");
				TitreEnqueteurManager teMng = new TitreEnqueteurManagerDB();
				HashMap<String, String> filterTitre = new HashMap<String, String>();
				filterTitre.put("id", "=" + String.valueOf(titre));
				teMng.loadTitresEnqueteur(filterTitre);
				ArrayList<TitreEnqueteur> resultTitre = teMng.getListeTitresEnqueteur();
				row.put("titre", resultTitre.get(0));

				// Need to instantiate ServiceEnqueteur to add to the Enqueteur

				int service = result.getInt("service");
				ServiceEnqueteurManager seMng = new ServiceEnqueteurManagerDB();
				HashMap<String, String> filterService = new HashMap<String, String>();
				filterService.put("id", "=" + String.valueOf(service));
				seMng.loadServicesEnqueteur(filterService);
				ArrayList<ServiceEnqueteur> resultService = seMng.getListeServicesEnqueteur();
				row.put("service", resultService.get(0));

				// Loading Enqueteur using values in row
				newEnqueteur.load(row);
				// Adding Enqueteur to ArrayList
				this.listeEnqueteurs.add(newEnqueteur);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}