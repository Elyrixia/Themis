/**
 * @author Tristan Sallé
 */

package business.affaire;

import java.util.HashMap;

import persistence.SQLManager;

public class FraisDB extends Frais {
	
	/**
	 * Correspondence with the table in the database
	 */
	public static final String TABLE_NAME = "frais";
	
	@Override
	public int create() {
		// Connection to the DB
		SQLManager sql = SQLManager.getConnection();
		
		// Run the query
		this.id = sql.insert(TABLE_NAME, getHashMap());
		
		return this.id;
	}

	@Override
	public void update() {
		// Connection to the DB
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Condition where
		String where = "id = "+this.id;
		
		// Run the query
		sqlManager.update(TABLE_NAME, getHashMap(), where);
	}

	@Override
	public void delete() throws Exception {
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Condition where
		String where = "id = "+this.id;
		
		// Run the query
		sqlManager.delete(TABLE_NAME, where);
	}

	private HashMap<String,String> getHashMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("libelle", this.libelle);
		map.put("prix", String.valueOf(this.prix));
		
		map.put("id_affaire", String.valueOf(this.idAffaire.getId()));
		
		return map;
	}

}
