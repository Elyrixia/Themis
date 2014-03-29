package business.affaire;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;

import common.Utilitaire;

public class ObjetManagerDB extends ObjetManager {

	@Override
	public void loadObjet(HashMap<String, String> filter) {
		
		SQLManager connect = SQLManager.getConnection();

		String where = Utilitaire.getWhere(filter);

		// Sending query
		ResultSet result = connect.select(ObjetDB.TABLE_NAME, where);

		// Preparing ArrayList
		try
		{
			Factory fac = DBFactory.getInstance();
			while (result.next())
			{
				// Create new Objet
				Objet newObjet = fac.createObjet();
				
				// Reading row in SQLResult
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("id", result.getInt("id"));
				row.put("libelle", result.getString("libelle"));
				row.put("comment", result.getString("comment"));
				
				// Need to instantiate Scelle to add to the Objet

				int scelle = result.getInt("id_scelle");
				ScelleManager sMng = new ScelleManagerDB();
				HashMap<String, String> filterScelle = new HashMap<String, String>();
				filterScelle.put("id", "=" + String.valueOf(scelle));
				sMng.loadScelle(filterScelle);
				ArrayList<Scelle> resultScelle = sMng.getListeScelles();
				row.put("id_scelle", resultScelle.get(0));
				
				// Need to instantiate TypeObjet to add to the Objet
				
				int typeObjet = result.getInt("id_type");
				TypeObjetManager toMng = new TypeObjetManagerDB();
				HashMap<String, String> filterTypeObjet = new HashMap<String, String>();
				filterTypeObjet.put("id", "=" + String.valueOf(typeObjet));
				toMng.loadTypeObjet(filterTypeObjet);
				ArrayList<TypeObjet> resultTypeObjet = toMng.getListeTypesObjet();
				row.put("id_type", resultTypeObjet.get(0));

				// Need to instantiate Objet to add to the Objet if it exists
				
				int objet = result.getInt("id_objet");
				if (!result.wasNull()) {
					ObjetManager oMng = new ObjetManagerDB();
					HashMap<String, String> filterObjet = new HashMap<String, String>();
					filterObjet.put("id", "=" + String.valueOf(objet));
					oMng.loadObjet(filterObjet);
					ArrayList<Objet> resultObjet = oMng.getListeObjets();
					row.put("id_objet", resultObjet.get(0));
				}
				
				// Loading Objet using values in row
				newObjet.load(row);
				
				// Adding Objet to ArrayList
				this.listeObjets.add(newObjet);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
