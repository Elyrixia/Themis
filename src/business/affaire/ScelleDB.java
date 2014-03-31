/**
 * @author Benoit Ruiz
 */

package business.affaire;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import persistence.SQLManager;

public class ScelleDB extends Scelle {

	/**
	 * Correspondence with the table in the database
	 */
	public static final String TABLE_NAME = "scelle";
	
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
		
		ResultSet rs = sqlManager.select(ScelleDB.TABLE_NAME, "id_scelle = " + this.id);
		try {
			rs.last();
			int nbScelles = rs.getRow();
			if(nbScelles > 0) {
				throw new Exception("This scelle is used by " + nbScelles + " scelle(s)!\nDeletion aborted.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		rs = sqlManager.select(ObjetDB.TABLE_NAME, "id_scelle = " + this.id);
		try {
			rs.last();
			int nbObjets = rs.getRow();
			if(nbObjets > 0) {
				throw new Exception("This scelle is used by " + nbObjets + " objet(s)!\nDeletion aborted.");
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
		
		map.put("num_proces", String.valueOf(this.numProces));
		
		DateFormat db = new SimpleDateFormat("yyyy-MM-dd");
		map.put("date_recup", db.format(this.dateRecup));
		
		map.put("lieu_recup", this.lieuRecup);
		map.put("comment", this.comment);
		
		map.put("id_affaire", String.valueOf(this.idAffaire.getId()));
		if(this.idScelle == null) map.put("id_scelle", "null");
		else map.put("id_scelle", String.valueOf(this.idScelle.getId()));
		
		return map;
	}

}
