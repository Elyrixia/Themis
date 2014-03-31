package business.affaire;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;

import common.Utilitaire;

public class FraisManagerDB extends FraisManager {

	@Override
	public void loadFrais(HashMap<String, String> filter) {

		SQLManager connect = SQLManager.getConnection();

		String where = Utilitaire.getWhere(filter);

		// Sending query
		ResultSet result = connect.select(FraisDB.TABLE_NAME, where);

		// Preparing ArrayList
		try {
			Factory fac = DBFactory.getInstance();
			while (result.next()) {
				// Create new Frais
				Frais newFrais = fac.createFrais();
				
				// Reading row in SQLResult
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("id", result.getInt("id"));
				row.put("libelle", result.getString("libelle"));
				row.put("prix", result.getInt("prix"));
				
				// Need to instantiate Affaire to add to the Frais
				int affaire = result.getInt("id_affaire");
				AffaireManager aMng = new AffaireManagerDB();
				HashMap<String, String> filterAffaire = new HashMap<String, String>();
				filterAffaire.put("id", "=" + String.valueOf(affaire));
				aMng.loadAffaire(filterAffaire);
				ArrayList<Affaire> resultAffaire = aMng.getListeAffaires();
				row.put("id_affaire", resultAffaire.get(0));
				
				// Loading Frais using values in row
				newFrais.load(row);
				
				// Adding Frais to ArrayList
				this.listeFrais.add(newFrais);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
