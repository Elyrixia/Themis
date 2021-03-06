/**
 * @author Alexandre Laffaille
 */

package business.enqueteur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import common.Utilitaire;
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

		String where = Utilitaire.getWhere(filter);

		// Sending query
		ResultSet result = connect.select(EnqueteurDB.TABLE_NAME, where);

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
				row.put("telephone_pro", result.getString("telephone_pro"));
				row.put("telephone_perso", result.getString("telephone_perso"));
				row.put("email", result.getString("email"));
				row.put("fax_pro", result.getString("fax_pro"));

				// Need to instantiate TitreEnqueteur to add to the Enqueteur

				int titre = result.getInt("id_titre");
				TitreEnqueteurManager teMng = new TitreEnqueteurManagerDB();
				HashMap<String, String> filterTitre = new HashMap<String, String>();
				filterTitre.put("id", "=" + String.valueOf(titre));
				teMng.loadTitresEnqueteur(filterTitre);
				ArrayList<TitreEnqueteur> resultTitre = teMng.getListeTitresEnqueteur();
				row.put("id_titre", resultTitre.get(0));

				// Need to instantiate ServiceEnqueteur to add to the Enqueteur

				int service = result.getInt("id_service");
				ServiceEnqueteurManager seMng = new ServiceEnqueteurManagerDB();
				HashMap<String, String> filterService = new HashMap<String, String>();
				filterService.put("id", "=" + String.valueOf(service));
				seMng.loadServicesEnqueteur(filterService);
				ArrayList<ServiceEnqueteur> resultService = seMng.getListeServicesEnqueteur();
				row.put("id_service", resultService.get(0));

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