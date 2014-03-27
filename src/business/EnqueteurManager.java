package business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import persistence.DBFactory;
import persistence.Factory;
import persistence.SQLManager;

public class EnqueteurManager {

	// ATTRIBUTES
	
	/**
	 * Loaded list of Enqueteur
	 */
	private ArrayList<Enqueteur> listeEnqueteurs;
	
	// CONSTRUCTOR
	
	public EnqueteurManager() {
		this.listeEnqueteurs = new ArrayList<Enqueteur>();
	}
	
	// METHODS
	
	/**
	 * Load Enqueteur list using a filter
	 * @param: filter: A DEFINIR
	 */
	public void loadEnqueteurs(HashMap<String,String> filter) {
		SQLManager connect = SQLManager.getConnection();
		
		String query = "SELECT * FROM Enqueteur";
		
		// Si on a fourni un filtre il va falloir specifier le where
		if(filter.size() > 0) {
			query += " WHERE ";
			
			Iterator<String> keySetIterator = filter.keySet().iterator();
			
			// Premiere condition
			String key = keySetIterator.next();
			query += key + filter.get(key);
			
			// S'il y en a d'autres
			while(keySetIterator.hasNext()) {
				query += " AND ";
				key = keySetIterator.next();
				query += key + filter.get(key);
			}
		}
		
		// Sending query
		ResultSet result = connect.querySelect(query);
		
		// Preparing ArrayList
		try {
			Factory fac = DBFactory.getInstance();
			while(result.next()) {
				// Create new CorpsEnqueteur
				Enqueteur newEnqueteur = fac.createEnqueteur();
				// Reading row in SQLResult
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("id",result.getInt("id"));
				row.put("nom", result.getString("nom"));
				row.put("prenom", result.getString("prenom"));
				row.put("adresse", result.getString("adresse"));
				row.put("telephonePro", result.getString("telephonePro"));
				row.put("telephonePerso", result.getString("telephonePerso"));
				row.put("email",result.getString("email"));
				row.put("faxPro", result.getString("faxPro"));
				
				// Need to instanciate TitreEnqueteur to add to the Enqueteur
				
				int titre = result.getInt("titre");
				TitreEnqueteurManager teMng = new TitreEnqueteurManager();
				HashMap<String,String> filterTitre = new HashMap<String,String>();
				filterTitre.put("id", "="+String.valueOf(titre));
				teMng.loadTitresEnqueteur(filterTitre);
				ArrayList<TitreEnqueteur> resultTitre = teMng.getListeTitresEnqueteur();
				row.put("titre", resultTitre.get(0));
				
					/*
					String queryTitre = "SELECT * FROM TitreEnqueteur WHERE id = "+String.valueOf(titre);
					ResultSet resultTitre = connect.querySelect(queryTitre);
					resultTitre.first();
					HashMap<String, Object> rowTitre = new HashMap<String, Object>();
					rowTitre.put(":id", resultTitre.getInt("id"));
					rowTitre.put(":libelle", resultTitre.getString("libelle"));
					TitreEnqueteur newTitre = fac.createTitreEnqueteur();
					newTitre.load(rowTitre);
					*/
				
				// Need to instanciate ServiceEnqueteur to add to the Enqueteur
				
				int service = result.getInt("service");
				ServiceEnqueteurManager seMng = new ServiceEnqueteurManager();
				HashMap<String,String> filterService = new HashMap<String,String>();
				filterService.put("id", "="+String.valueOf(service));
				seMng.loadServicesEnqueteur(filterService);
				ArrayList<ServiceEnqueteur> resultService = seMng.getListeServicesEnqueteur();
				row.put("service", resultService.get(0));
				
				// Loading Enqueteur using values in row
				newEnqueteur.load(row);
				// Adding Enqueteur to ArrayList
				this.listeEnqueteurs.add(newEnqueteur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// GETTERS
	
	public ArrayList<Enqueteur> getListeEnqueteurs() {
		return this.listeEnqueteurs;
	}
	
}