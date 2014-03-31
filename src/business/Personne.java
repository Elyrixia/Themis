/**
 * @author Alexandre Laffaille
 */

package business;

import java.util.regex.Pattern;

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
	
	public void setNom(String nom) throws Exception {
		if(nom.length() > 30)
			throw new Exception("The last name length must not exceed 30 characters!");
		
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) throws Exception {
		if(prenom.length() > 30)
			throw new Exception("The first name length must not exceed 30 characters!");
		
		this.prenom = prenom;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) throws Exception {
		if(adresse.length() > 255)
			throw new Exception("The address length must not exceed 255 characters!");
		
		this.adresse = adresse;
	}
	
	public String getTelephonePro() {
		return telephonePro;
	}
	
	public void setTelephonePro(String telephonePro) throws Exception {
		if(adresse.length() > 14)
			throw new Exception("The profesionnal phone number length must not exceed 14 characters!");
		
		this.telephonePro = telephonePro;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) throws Exception {
		
		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(emailPattern);
		
		if(!p.matcher(email).matches())
			throw new Exception("The email is not a valid email address!");
		
		if(email.length() > 60)
			throw new Exception("The email length must not exceed 60 characters!");
		
		this.email = email;
	}
	
	public String getFaxPro() {
		return faxPro;
	}
	
	public void setFaxPro(String faxPro) throws Exception {
		if(faxPro.length() > 14)
			throw new Exception("The profesionnal fax number length must not exceed 14 characters!");
		
		this.faxPro = faxPro;
	}
	
	public boolean equals(Personne a) {
		return  id == a.getId() && 
				nom.equals(a.getNom()) && 
				prenom.equals(a.getPrenom()) && 
				adresse.equals(a.getAdresse()) && 
				telephonePro.equals(a.getTelephonePro()) && 
				email.equals(a.getEmail()) && 
				faxPro.equals(a.getFaxPro());
	}
	
}
