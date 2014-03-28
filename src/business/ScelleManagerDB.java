package business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import common.Utilitaire;

import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;

public class ScelleManagerDB extends ScelleManager {

	@Override
	public void loadScelle(HashMap<String, String> filter) {
		
		SQLManager connect = SQLManager.getConnection();

		String where = Utilitaire.getWhere(filter);

		// Sending query
		ResultSet result = connect.select(ScelleDB.TABLE_NAME, SQLManager.ALL, where);

		// Preparing ArrayList
		try
		{
			Factory fac = DBFactory.getInstance();
			while (result.next())
			{
				// Create new Scelle
				Scelle newScelle = fac.createScelle();
				
				// Reading row in SQLResult
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("id", result.getInt("id"));
				row.put("numProces", result.getInt("numProces"));
				row.put("dateRecup", result.getDate("dateRecup"));
				row.put("lieuRecup", result.getString("lieuRecup"));
				row.put("comment", result.getString("comment"));
				
				// Need to instantiate Affaire to add to the Scelle

				int affaire = result.getInt("idAffaire");
				AffaireManager aMng = new AffaireManagerDB();
				HashMap<String, String> filterAffaire = new HashMap<String, String>();
				filterAffaire.put("id", "=" + String.valueOf(affaire));
				aMng.loadAffaire(filterAffaire);
				ArrayList<Affaire> resultAffaire = aMng.getListeAffaires();
				row.put("idAffaire", resultAffaire.get(0));
				
				// Need to instantiate Scelle to add to the Scelle if it exists

				int scelle = result.getInt("idScelle");
				if (!result.wasNull()) {
					ScelleManager sMng = new ScelleManagerDB();
					HashMap<String, String> filterScelle = new HashMap<String, String>();
					filterScelle.put("id", "=" + String.valueOf(scelle));
					sMng.loadScelle(filterScelle);
					ArrayList<Scelle> resultScelle = sMng.getListeScelles();
					row.put("idScelle", resultScelle.get(0));
				}
				
				// Loading Scelle using values in row
				newScelle.load(row);
				
				// Adding Scelle to ArrayList
				this.listeScelles.add(newScelle);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
