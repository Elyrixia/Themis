package business.affaire;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;
import business.enqueteur.Enqueteur;
import business.enqueteur.EnqueteurManager;
import business.enqueteur.EnqueteurManagerDB;
import business.enqueteur.TitreEnqueteur;
import business.enqueteur.TitreEnqueteurManager;
import business.enqueteur.TitreEnqueteurManagerDB;

import common.Utilitaire;

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
				row.put("comment", result.getString("comment"));
				
				// Need to instantiate Enqueteur to add to the Affaire
				int enqueteur = result.getInt("id_enqueteur");
				EnqueteurManager eMng = new EnqueteurManagerDB();
				HashMap<String, String> filterEnqueteur = new HashMap<String, String>();
				filterEnqueteur.put("id", "=" + String.valueOf(enqueteur));
				eMng.loadEnqueteurs(filterEnqueteur);
				ArrayList<Enqueteur> resultEnqueteur = eMng.getListeEnqueteurs();
				row.put("id_enqueteur", resultEnqueteur.get(0));
				
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
