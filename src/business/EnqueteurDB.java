package business;

import java.util.HashMap;

import persistence.SQLManager;

public class EnqueteurDB extends Enqueteur {
	
	@Override
	public int create() {
		SQLManager sql = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(":nom", this.nom);
		map.put(":prenom", this.prenom);
		map.put(":adresse", this.adresse);
		map.put(":telephonePro", this.telephonePro);
		map.put(":telephonePerso", this.telephonePerso);
		map.put(":email", this.email);
		map.put(":faxPro", this.faxPro);
		//map.put(":titre", this.titre.getId());
		//map.put(":service", this.service.getId());
		
		// Run the query
		sql.query("INSERT INTO Enqueteur(nom,prenom,adresse,telephonePro,telephonePerso,email,faxPro,titre,service) VALUES(':nom',':prenom',':adresse',':telephonePro',':telephonePerso',':email',':faxPro',':titre',':service')", map);
		
		// Get the id of this new CorpsEnqueteur
		this.id = sql.getLastID();
		return this.id;
	}

	@Override
	public void update() {
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(":nom", this.nom);
		map.put(":prenom", this.prenom);
		map.put(":adresse", this.adresse);
		map.put(":telephonePro", this.telephonePro);
		map.put(":telephonePerso", this.telephonePerso);
		map.put(":email", this.email);
		map.put(":faxPro", this.faxPro);
		//map.put(":titre", this.titre.getId());
		//map.put(":service", this.service.getId());
		
		// Run the query
		sqlManager.query("UPDATE Enqueteur SET nom=':nom', prenom=':prenom', adresse=':adresse', telephonePro=':telephonePro', telephonePerso=':telephonePerso', email=':email', faxPro=':faxPro', titre=':titre', service=':service' WHERE id=':id'", map);
	}

	@Override
	public void delete() {
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(":id",String.valueOf(this.id));
		
		// Run the query
		sqlManager.query("DELETE FROM Enqueteur WHERE id=':id'", map);
	}

}
