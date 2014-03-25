package business;

public abstract class Personne {
	
	/**
	 * The last name of a person
	 */
	private String nom;
	
	/**
	 * The first name of a person
	 */
	private String prenom;
	
	/**
	 * The address of a person
	 */
	private String adresse;
	
	/**
	 * The professional phone number
	 */
	private String telephonePro;
	
	/**
	 * The email address
	 */
	private String email;
	
	/**
	 * The professional fax number
	 */
	private String faxPro;
	
	// Getters and setters
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getTelephonePro() {
		return telephonePro;
	}
	
	public void setTelephonePro(String telephonePro) {
		this.telephonePro = telephonePro;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFaxPro() {
		return faxPro;
	}
	
	public void setFaxPro(String faxPro) {
		this.faxPro = faxPro;
	}
	
}
