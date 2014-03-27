package business;

import java.util.HashMap;

import persistence.SQLManager;

public class ServiceEnqueteurDB extends ServiceEnqueteur
{

	/**
	 * Correspondence with the table in the database
	 */
	public static final String table = "service_enqueteur";
	
	@Override
	public int create() {
		SQLManager sql = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(":libelle", this.libelle);
		map.put(":telephone", this.telephone);
		map.put(":lieu", this.lieu);
		
		// Run the query
		sql.query("INSERT INTO service_enqueteur(libelle,telephone,lieu) VALUES(':libelle',':telephone',':lieu')", map);
		
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
		map.put(":telephone", this.telephone);
		map.put(":lieu", this.lieu);
		
		// Run the query
		sqlManager.query("UPDATE service_enqueteur SET libelle=':libelle', telephone=':telephone', lieu=':lieu' WHERE id=':id'", map);
	}

	@Override
	public void delete() {
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(":id",String.valueOf(this.id));
		
		// Run the query
		sqlManager.query("DELETE FROM service_enqueteur WHERE id=':id'", map);
	}

}
