/**
 * @author Alexandre Laffaille, Nathan Marin, Benoit Ruiz, Tristan Sallé
 */

package business.affaire;

import java.sql.ResultSet;
import java.sql.SQLException;
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
		
		ResultSet rs = sqlManager.select(ScelleDB.TABLE_NAME, "id_affaire = " + this.id);
		try {
			rs.last();
			int nbScelles = rs.getRow();
			if(nbScelles > 0) {
				throw new Exception("This affaire is used by " + nbScelles + " scelle(s)!\nDeletion aborted.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		rs = sqlManager.select(FraisDB.TABLE_NAME, "id_affaire = " + this.id);
		try {
			rs.last();
			int nbFrais = rs.getRow();
			if(nbFrais > 0) {
				throw new Exception("This affaire is used by " + nbFrais + " frais!\nDeletion aborted.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		rs = sqlManager.select(FraisDB.TABLE_NAME, "id_affaire = " + this.id);
		try {
			rs.last();
			int nbFrais = rs.getRow();
			if(nbFrais > 0) {
				throw new Exception("This affaire is used by " + nbFrais + " frais!\nDeletion aborted.");
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
		
		map.put("nom", this.nom);
		map.put("num_dossier", String.valueOf(this.numDossier));
		map.put("num_instruction", String.valueOf(this.numInstruction));
		map.put("num_parquet", String.valueOf(this.numParquet));
		
		DateFormat db = new SimpleDateFormat("yyyy-MM-dd");
		map.put("date_ordre", db.format(this.dateOrdre));
		map.put("date_rendu", db.format(this.dateRendu));
		
		map.put("delai", Utilitaire.booleanToString(this.delai));
		
		map.put("comment", this.comment);
		
		map.put("id_enqueteur", String.valueOf(this.idEnqueteur.getId()));
		
		return map;
	}
	
}
