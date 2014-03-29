package business.enqueteur;

import java.util.HashMap;

import business.Business;
import business.Personne;

public abstract class Enqueteur extends Personne implements Business
{

	/**
	 * The title of the detective (for example, "Lieutenant")
	 */
	protected TitreEnqueteur idTitre;

	/**
	 * The service where the detective works (for instance, police station)
	 */
	protected ServiceEnqueteur idService;

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
		this.telephonePro = (String) map.get("telephone_pro");
		this.email = (String) map.get("email");
		this.faxPro = (String) map.get("fax_pro");
		this.idTitre = (TitreEnqueteur) map.get("id_titre");
		this.idService = (ServiceEnqueteur) map.get("id_service");
		this.telephonePerso = (String) map.get("telephone_perso");
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
		return idTitre;
	}

	public void setTitre(TitreEnqueteur titre) throws Exception {
		if(titre == null)
			throw new Exception("The detective must have a title!");
		
		this.idTitre = titre;
	}

	public ServiceEnqueteur getService() {
		return idService;
	}

	public void setService(ServiceEnqueteur service) throws Exception {
		if(service == null)
			throw new Exception("The detective must be part of a service!");
		
		this.idService = service;
	}

	public String getTelephonePerso() {
		return telephonePerso;
	}

	public void setTelephonePerso(String telephonePerso) throws Exception {
		if(telephonePerso.length() > 14) // | (+33)611223344 | = 14
			throw new Exception("The personal phone number length must not exceed 14 characters!");
		
		this.telephonePerso = telephonePerso;
	}
	
	public String toString() {
		String message = "Enqueteur n�"+this.id+" - "+this.nom+" "+this.prenom;
		
		return message;
	}
	
	public boolean equals(Enqueteur a) {
		return  super.equals(a) && 
				idTitre.equals(a.getTitre()) && 
				idService.equals(a.getService());
	}

}
