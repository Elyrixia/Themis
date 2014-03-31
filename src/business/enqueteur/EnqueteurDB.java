package business.enqueteur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import persistence.SQLManager;
import business.affaire.AffaireDB;

public class EnqueteurDB extends Enqueteur {
	
	/**
	 * Correspondence with the table in the database
	 */
	public static final String TABLE_NAME = "enqueteur";
	
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
		
		ResultSet rs = sqlManager.select(AffaireDB.TABLE_NAME, "id_enqueteur = " + this.id);
		try {
			rs.last();
			int nbAffaires = rs.getRow();
			if(nbAffaires > 0) {
				throw new Exception("This detective has worked in " + nbAffaires + " affaire(s)!\nDeletion aborted.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Prepare the query
		String where = "id = "+this.id;
		
		// Run the query
		sqlManager.delete(TABLE_NAME, where);
	}
	
	/**
	 * 
	 * @return the number of affaires in which this detective has worked
	 */
	public int getNbAffaires() {
		
		SQLManager sqlManager = SQLManager.getConnection();
		return sqlManager.count(AffaireDB.TABLE_NAME, "id_enqueteur = " + this.id);
	}
	
	private HashMap<String,String> getHashMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("nom", this.nom);
		map.put("prenom", this.prenom);
		map.put("adresse", this.adresse);
		map.put("telephone_pro", this.telephonePro);
		map.put("telephone_perso", this.telephonePerso);
		map.put("email", this.email);
		map.put("fax_pro", this.faxPro);
		map.put("id_titre", String.valueOf(this.idTitre.getId()));
		map.put("id_service", String.valueOf(this.idService.getId()));
		
		return map;
	}

}
