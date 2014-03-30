package business.affaire;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import persistence.SQLManager;

public class ObjetDB extends Objet {

	/**
	 * Correspondence with the table in the database
	 */
	public static final String TABLE_NAME = "objet";
	
	@Override
	public int create() {
		SQLManager sql = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("libelle", this.libelle);
		map.put("comment", this.comment);
		
		map.put("id_scelle", String.valueOf(this.idScelle.getId()));
		map.put("id_type", String.valueOf(this.idType.getId()));
		if(this.idObjet == null) map.put("id_objet", "null");
		else map.put("id_objet", String.valueOf(this.idObjet.getId()));
		
		// Run the query
		this.id = sql.insert(TABLE_NAME, map);
		
		return this.id;
	}

	@Override
	public void update() {
		
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("libelle", this.libelle);
		map.put("comment", this.comment);
		
		map.put("id_scelle", String.valueOf(this.idScelle.getId()));
		map.put("id_type", String.valueOf(this.idType.getId()));
		if(this.idObjet == null) map.put("id_objet", "null");
		else map.put("id_objet", String.valueOf(this.idObjet.getId()));
		
		String where = "id = "+this.id;
		
		// Run the query
		sqlManager.update(TABLE_NAME, map, where);
		
	}

	@Override
	public void delete() throws Exception {
		
		SQLManager sqlManager = SQLManager.getConnection();
		
		ResultSet rs = sqlManager.select(ObjetDB.TABLE_NAME, "id_objet = " + this.id);
		try {
			rs.last();
			int nbObjets = rs.getRow();
			if(nbObjets > 0) {
				throw new Exception("This objet is used by " + nbObjets + " objet(s)!\nDeletion aborted.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Prepare the query
		String where = "id = "+this.id;
		
		// Run the query
		sqlManager.delete(TABLE_NAME, where);
		
	}

}
