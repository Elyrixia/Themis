package business.enqueteur;

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
		SQLManager sql = SQLManager.getConnection();
		
		// Prepare the query
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
		
		// Run the query
		this.id = sql.insert(TABLE_NAME, map);
		
		return this.id;
	}

	@Override
	public void update() {
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Prepare the query
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
	
	/**
	 * 
	 * @return the number of affaires in which this detective has worked
	 */
	public int getNbAffaires() {
		
		SQLManager sqlManager = SQLManager.getConnection();
		return sqlManager.count(AffaireDB.TABLE_NAME, "id_enqueteur = " + this.id);
	}

}
