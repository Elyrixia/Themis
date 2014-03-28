package business.affaire;

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
		
		SQLManager sql = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("num_proces", String.valueOf(this.numProces));
		
		DateFormat db = new SimpleDateFormat("MM/dd/yyyy");
		map.put("date_recup", db.format(this.dateRecup));
		
		map.put("lieu_recup", this.lieuRecup);
		map.put("comment", this.comment);
		
		map.put("id_affaire", String.valueOf(this.idAffaire.getId()));
		map.put("id_scelle", String.valueOf(this.idScelle.getId()));
		
		// Run the query
		this.id = sql.insert(TABLE_NAME, map);
		
		return this.id;
		
	}

	@Override
	public void update() {
		
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("num_proces", String.valueOf(this.numProces));
				
		DateFormat db = new SimpleDateFormat("MM/dd/yyyy");
		map.put("date_recup", db.format(this.dateRecup));
				
		map.put("lieu_recup", this.lieuRecup);
		map.put("comment", this.comment);
				
		map.put("id_affaire", String.valueOf(this.idAffaire.getId()));
		map.put("id_scelle", String.valueOf(this.idScelle.getId()));
		
		String where = "id = "+this.id;
		
		// Run the query
		sqlManager.update(TABLE_NAME, map, where);
		
	}

	@Override
	public void delete() {
		
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Prepare the query
		String where = "id = "+this.id;
		
		// Run the query
		sqlManager.delete(TABLE_NAME, where);
		
	}

}
