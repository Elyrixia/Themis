package business.affaire;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import common.Utilitaire;
import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;

public class AffaireManagerDB extends AffaireManager {

	@Override
	public void loadAffaire(HashMap<String, String> filter) {
		
		SQLManager connect = SQLManager.getConnection();

		String where = Utilitaire.getWhere(filter);

		// Sending query
		ResultSet result = connect.select(AffaireDB.TABLE_NAME, where);

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
				row.put("num_dossier", result.getInt("num_dossier"));
				row.put("num_instruction", result.getInt("num_instruction"));
				row.put("num_parquet", result.getInt("num_parquet"));
				row.put("date_ordre", result.getDate("date_ordre"));
				row.put("date_rendu", result.getDate("date_rendu"));
				row.put("delai", result.getBoolean("delai"));
				
				// Loading Affaire using values in row
				newAffaire.load(row);
				
				// Adding Affaire to ArrayList
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
