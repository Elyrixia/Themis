package business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;

public class TitreEnqueteurManager {

	// ATTRIBUTES
	
	/**
	 * Loaded list of TitreEnqueteur
	 */
	private ArrayList<TitreEnqueteur> listeTitres;
			
	// CONSTRUCTOR
			
	public TitreEnqueteurManager() {
		this.listeTitres = new ArrayList<TitreEnqueteur>();
	}
			
	// METHODS
			
	/**
	 * Load TitreEnqueteur list using a filter
	 * @param: filter: A DEFINIR
	 */
	public void loadTitresEnqueteur(HashMap<String,String> filter) {
		SQLManager connect = SQLManager.getConnection();
		
		String where = "";
		
		// Si on a fourni un filtre il va falloir specifier le where
		if(filter.size() > 0) {
			Iterator<String> keySetIterator = filter.keySet().iterator();
			
			// Premiere condition
			String key = keySetIterator.next();
			where += key + filter.get(key);
			
			// S'il y en a d'autres
			while(keySetIterator.hasNext()) {
				where += " AND ";
				key = keySetIterator.next();
				where += key + filter.get(key);
			}
		}
		
		// Sending query
		ResultSet result = connect.select(TitreEnqueteurDB.table,null,where);
		
		// Preparing ArrayList
		try {
			Factory fac = DBFactory.getInstance();
			while(result.next()) {
				// Create new ServiceEnqueteur
				TitreEnqueteur newTitre = fac.createTitreEnqueteur();
				// Reading row in SQLResult
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("id",result.getInt("id"));
				row.put("libelle", result.getString("libelle"));
				// Loading TitreEnqueteur using values in row
				newTitre.load(row);
				// Adding ServiceEnqueteur to ArrayList
				this.listeTitres.add(newTitre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
	// GETTERS
		
	public ArrayList<TitreEnqueteur> getListeTitresEnqueteur() {
			return this.listeTitres;
	}
	
}
