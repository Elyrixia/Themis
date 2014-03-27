package business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;

public class ServiceEnqueteurManager {

	// ATTRIBUTES
	
	/**
	 * Loaded list of ServiceEnqueteur
	 */
	private ArrayList<ServiceEnqueteur> listeServices;
		
	// CONSTRUCTOR
		
	public ServiceEnqueteurManager() {
		this.listeServices = new ArrayList<ServiceEnqueteur>();
	}
		
	// METHODS
		
	/**
	 * Load ServiceEnqueteur list using a filter
	 * @param: filter: A DEFINIR
	 */
	public void loadServicesEnqueteur(HashMap<String,String> filter) {
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
		ResultSet result = connect.select(ServiceEnqueteurDB.table,null,where);
		
		// Preparing ArrayList
		try {
			Factory fac = DBFactory.getInstance();
			while(result.next()) {
				// Create new ServiceEnqueteur
				ServiceEnqueteur newService = fac.createServiceEnqueteur();
				// Reading row in SQLResult
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("id",result.getInt("id"));
				row.put("libelle", result.getString("libelle"));
				row.put("telephone", result.getString("telephone"));
				row.put("lieu", result.getString("lieu"));
				// Loading ServiceEnqueteur using values in row
				newService.load(row);
				// Adding ServiceEnqueteur to ArrayList
				this.listeServices.add(newService);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	// GETTERS
	
	public ArrayList<ServiceEnqueteur> getListeServicesEnqueteur() {
		return this.listeServices;
	}
}
