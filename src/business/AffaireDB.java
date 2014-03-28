package business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import common.Utilitaire;
import persistence.SQLManager;

public class AffaireDB extends Affaire {

	/**
	 * Correspondence with the table in the database
	 */
	public static final String TABLE_NAME = "affaire";
	
	@Override
	public int create() {
		SQLManager sql = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("nom", this.nom);
		map.put("num_dossier", String.valueOf(this.numDossier));
		map.put("num_instruction", String.valueOf(this.numInstruction));
		map.put("num_parquet", String.valueOf(this.numParquet));
		
		DateFormat db = new SimpleDateFormat("MM/dd/yyyy");
		map.put("date_ordre", db.format(this.dateOrdre));
		map.put("date_rendu", db.format(this.dateRendu));
		
		map.put("delai", Utilitaire.booleanToString(this.delai));
		
		// Run the query
		sql.insert(TABLE_NAME, map);
		
		// Get the id of this new CorpsEnqueteur
		this.id = sql.getLastID();
		return this.id;
	}

	@Override
	public void update() {
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("nom", this.nom);
		map.put("num_dossier", String.valueOf(this.numDossier));
		map.put("num_instruction", String.valueOf(this.numInstruction));
		map.put("num_parquet", String.valueOf(this.numParquet));
		
		DateFormat db = new SimpleDateFormat("MM/dd/yyyy");
		map.put("date_ordre", db.format(this.dateOrdre));
		map.put("date_rendu", db.format(this.dateRendu));
		
		map.put("delai", Utilitaire.booleanToString(this.delai));
		
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
