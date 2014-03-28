package business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;

public class AffaireManagerDB extends AffaireManager {

	@Override
	public void loadAffaire(HashMap<String, String> filter) {
		
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
		ResultSet result = connect.select(AffaireDB.TABLE_NAME, SQLManager.ALL, where);

		// Preparing ArrayList
		try
		{
			Factory fac = DBFactory.getInstance();
			while (result.next())
			{
				// Create new Affaire
				Affaire newAffaire = fac.createAffaire();
				
				// Reading row in SQLResult
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("id", result.getInt("id"));
				row.put("nom", result.getString("nom"));
				row.put("numDossier", result.getInt("numDossier"));
				row.put("numInstruction", result.getInt("numInstruction"));
				row.put("numParquet", result.getInt("numParquet"));
				row.put("dateOrdre", result.getDate("dateOrdre"));
				row.put("dateRendu", result.getDate("dateRendu"));
				row.put("delai", result.getBoolean("delai"));
				
				// Loading CorpsEnqueteur using values in row
				newAffaire.load(row);
				
				// Adding CorpsEnqueteur to ArrayList
				this.listeAffaires.add(newAffaire);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}