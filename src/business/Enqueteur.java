package business;

import java.util.HashMap;

public abstract class Enqueteur extends Personne implements Business
{

	/**
	 * The title of the detective (for example, "Lieutenant")
	 */
	protected TitreEnqueteur titre;

	/**
	 * The service where the detective works (for instance, police station)
	 */
	protected ServiceEnqueteur service;

	/**
	 * The personal phone number of the detective
	 */
	protected String telephonePerso;
	
	public Enqueteur() {
		super();
	}
	
	/**
	 * @see load() from interface Business
	 */
	public void load(HashMap<String, Object> map) {
		
		this.id = (int) map.get("id");
		this.nom = (String) map.get("nom");
		this.prenom = (String) map.get("prenom");
		this.adresse = (String) map.get("adresse");
		this.telephonePro = (String) map.get("telephonePro");
		this.email = (String) map.get("email");
		this.faxPro = (String) map.get("faxPro");
		this.titre = (TitreEnqueteur) map.get("titre");
		this.service = (ServiceEnqueteur) map.get("service");
	}
	
	/**
	 * @see create() from interface Business
	 */
	public abstract int create();
	
	/**
	 * @see update() from interface Business
	 */
	public abstract void update();
	
	/**
	 * @see delete() from interface Business
	 */
	public abstract void delete();
	
	// getters and setters

	public TitreEnqueteur getTitre() {
		return titre;
	}

	public void setTitre(TitreEnqueteur titre) throws Exception {
		if(titre == null)
			throw new Exception("The detective must have a title!");
		
		this.titre = titre;
	}

	public ServiceEnqueteur getService() {
		return service;
	}

	public void setService(ServiceEnqueteur service) throws Exception {
		if(service == null)
			throw new Exception("The detective must be part of a service!");
		
		this.service = service;
	}

	public String getTelephonePerso() {
		return telephonePerso;
	}

	public void setTelephonePerso(String telephonePerso) throws Exception {
		if(telephonePerso.length() > 14) // | (+33)611223344 | = 14
			throw new Exception("The personal phone number length must not exceed 14 characters!");
		
		this.telephonePerso = telephonePerso;
	}

}
