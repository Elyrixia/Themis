package business;

import java.util.HashMap;

import persistence.SQLManager;

public class EnqueteurDB extends Enqueteur {
	
	/**
	 * Correspondence with the table in the database
	 */
	public static final String table = "enqueteur";
	
	@Override
	public int create() {
		SQLManager sql = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(":nom", this.nom);
		map.put(":prenom", this.prenom);
		map.put(":adresse", this.adresse);
		map.put(":telephonePro", this.telephonePro);
		map.put(":telephonePerso", this.telephonePerso);
		map.put(":email", this.email);
		map.put(":faxPro", this.faxPro);
		map.put(":titre", String.valueOf(this.titre.getId()));
		map.put(":service", String.valueOf(this.service.getId()));
		
		// Run the query
		sql.insert(table, map);
		
		// Get the id of this new CorpsEnqueteur
		this.id = sql.getLastID();
		return this.id;
	}

	@Override
	public void update() {
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(":nom", this.nom);
		map.put(":prenom", this.prenom);
		map.put(":adresse", this.adresse);
		map.put(":telephonePro", this.telephonePro);
		map.put(":telephonePerso", this.telephonePerso);
		map.put(":email", this.email);
		map.put(":faxPro", this.faxPro);
		map.put(":titre", String.valueOf(this.titre.getId()));
		map.put(":service", String.valueOf(this.service.getId()));
		String where = "id = "+this.id;
		
		// Run the query
		sqlManager.update(table, map, where);
	}

	@Override
	public void delete() {
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Prepare the query
		String where = "id = "+this.id;
		
		// Run the query
		sqlManager.delete(table, where);
	}

}
