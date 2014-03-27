package business;

public abstract class Personne {
	
	/**
	 * The unique id of this person.
	 */
	protected int id;
	
	/**
	 * The last name of a person
	 */
	protected String nom;
	
	/**
	 * The first name of a person
	 */
	protected String prenom;
	
	/**
	 * The address of a person
	 */
	protected String adresse;
	
	/**
	 * The professional phone number
	 */
	protected String telephonePro;
	
	/**
	 * The email address
	 */
	protected String email;
	
	/**
	 * The professional fax number
	 */
	protected String faxPro;
	
	public Personne() {
		
	}
	
	// Getters and setters
	
	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id : the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

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
