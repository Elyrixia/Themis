/**
 * @author Benoit Ruiz
 */

package business.affaire;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import persistence.SQLManager;

public class TypeObjetDB extends TypeObjet {

	/**
	 * Correspondence with the table in the database
	 */
	public static final String TABLE_NAME = "type_objet";
	
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
		
		ResultSet rs = sqlManager.select(ObjetDB.TABLE_NAME, "id_type = " + this.id);
		try {
			rs.last();
			int nbObjets = rs.getRow();
			if(nbObjets > 0) {
				throw new Exception("This type d'objet is used by " + nbObjets + " objet(s)!\nDeletion aborted.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Prepare the query
		String where = "id = "+this.id;
		
		// Run the query
		sqlManager.delete(TABLE_NAME, where);
	}
	
	private HashMap<String,String> getHashMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("libelle", this.libelle);
		
		return map;
	}

}
