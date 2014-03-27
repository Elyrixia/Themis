package business;

import java.util.HashMap;

import persistence.SQLManager;

public class TitreEnqueteurDB extends TitreEnqueteur {

	/**
	 * Correspondence with the table in the database
	 */
	public static final String table = "titre_enqueteur";
	
	@Override
	public int create() {
		SQLManager sql = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(":libelle", this.libelle);
		
		// Run the query
		sql.query("INSERT INTO titre_enqueteur(libelle) VALUES(':libelle')", map);
		
		// Get the id of this new CorpsEnqueteur
		this.id = sql.getLastID();
		return this.id;
	}

	@Override
	public void update() {
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(":id",String.valueOf(this.id));
		map.put(":libelle", this.libelle);
		
		// Run the query
		sqlManager.query("UPDATE titre_enqueteur SET libelle=':libelle' WHERE id=':id'", map);
	}

	@Override
	public void delete() {
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(":id",String.valueOf(this.id));
		
		// Run the query
		sqlManager.query("DELETE FROM corps_enqueteur WHERE id=':id'", map);	
	}

}
