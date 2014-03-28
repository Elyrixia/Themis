package business.affaire;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;
import common.Utilitaire;

public class TypeObjetManagerDB extends TypeObjetManager {

	@Override
	public void loadTypeObjet(HashMap<String, String> filter) {
		
		SQLManager connect = SQLManager.getConnection();

		String where = Utilitaire.getWhere(filter);

		// Sending query
		ResultSet result = connect.select(TypeObjetDB.TABLE_NAME, where);

		// Preparing ArrayList
		try
		{
			Factory fac = DBFactory.getInstance();
			while (result.next())
			{
				// Create new TypeObjet
				TypeObjet newTypeObjet = fac.createTypeObjet();
				
				// Reading row in SQLResult
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("id", result.getInt("id"));
				row.put("libelle", result.getString("libelle"));
				
				// Loading TypeObjet using values in row
				newTypeObjet.load(row);
				
				// Adding TypeObjet to ArrayList
				this.listeTypesObjet.add(newTypeObjet);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
