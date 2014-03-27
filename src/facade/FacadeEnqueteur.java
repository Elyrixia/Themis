package facade;

import java.util.ArrayList;
import java.util.HashMap;

import business.Enqueteur;
import business.EnqueteurManager;
import business.ServiceEnqueteur;
import business.TitreEnqueteur;
import persistence.DBFactory;
import persistence.Factory;

public class FacadeEnqueteur {

	// ATTRIBUTES
	
	/**
	 * Manager to load entities
	 */
	private EnqueteurManager eMng;
	
	// CONSTRUCTOR
	
	public FacadeEnqueteur() {}
	
	// METHODS
	
	/**
	 * Add a new Enqueteur
	 * @param: Enqueteur attributes
	 */
	public void ajouterEnqueteur(String nom, String prenom, String adresse, String telephonePro, String telephonePerso, String email, String faxPro, TitreEnqueteur titre, ServiceEnqueteur service) throws Exception {
		try {
			Factory fac = DBFactory.getInstance();
			Enqueteur newEnqueteur = fac.createEnqueteur();
			
			newEnqueteur.setNom(nom);
			newEnqueteur.setPrenom(prenom);
			newEnqueteur.setAdresse(adresse);
			newEnqueteur.setTelephonePro(telephonePro);
			newEnqueteur.setTelephonePerso(telephonePerso);
			newEnqueteur.setEmail(email);
			newEnqueteur.setFaxPro(faxPro);
			newEnqueteur.setTitre(titre);
			newEnqueteur.setService(service);
			
			newEnqueteur.create();
		} catch(Exception e) {
			throw e;
		}
		
	}
	/**
	 * Edit an Enqueteur
	 * @param: Enqueteur attributes
	 */
	public void modifierEnqueteur(Enqueteur enqueteur, String nom, String prenom, String adresse, String telephonePro, String telephonePerso, String email, String faxPro, TitreEnqueteur titre, ServiceEnqueteur service) throws Exception {
		try {
			enqueteur.setNom(nom);
			enqueteur.setPrenom(prenom);
			enqueteur.setAdresse(adresse);
			enqueteur.setTelephonePro(telephonePro);
			enqueteur.setTelephonePerso(telephonePerso);
			enqueteur.setEmail(email);
			enqueteur.setFaxPro(faxPro);
			enqueteur.setTitre(titre);
			enqueteur.setService(service);
			
			enqueteur.update();
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * Delete an Enqueteur
	 * @param: enqueteur: Entity to delete
	 */
	public void supprimerEnqueteur(Enqueteur enqueteur) throws Exception {
		try {
			enqueteur.delete();
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * Get HashMap containing data of a specific Enqueteur
	 * @param: enqueteur: Entity to consult
	 */
	public HashMap<String,Object> consulterEnqueteur(Enqueteur enqueteur) {
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put(":id", enqueteur.getId());
		result.put(":nom", enqueteur.getNom());
		result.put(":prenom", enqueteur.getPrenom());
		result.put(":adresse", enqueteur.getAdresse());
		result.put(":telephonePro", enqueteur.getTelephonePro());
		result.put(":telephonePerso", enqueteur.getTelephonePerso());
		result.put(":email",enqueteur.getEmail());
		result.put("faxPro", enqueteur.getFaxPro());
		result.put("titre", enqueteur.getTitre());
		result.put("service", enqueteur.getService());
		
		return result;
	}
	
	/**
	 * Load an ArrayList of Enqueteur using a filter
	 * @param: filter: condition to respect in the query
	 */
	public ArrayList<Enqueteur> chargerEnqueteur(HashMap<String,String> filter) {
		eMng = new EnqueteurManager();
		eMng.loadEnqueteurs(filter);
		return eMng.getListeEnqueteurs();
	}
	
}