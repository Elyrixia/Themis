package facade;

import java.util.ArrayList;
import java.util.HashMap;

import persistence.DBFactory;
import persistence.Factory;
import business.enqueteur.Enqueteur;
import business.enqueteur.EnqueteurManager;
import business.enqueteur.EnqueteurManagerDB;
import business.enqueteur.ServiceEnqueteur;
import business.enqueteur.TitreEnqueteur;

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
	public Enqueteur ajouterEnqueteur(String nom, String prenom, String adresse, String telephonePro, String telephonePerso, String email, String faxPro, TitreEnqueteur titre, ServiceEnqueteur service) throws Exception {
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
			
		return newEnqueteur;
	}
	/**
	 * Edit an Enqueteur
	 * @param: Enqueteur attributes
	 */
	public void modifierEnqueteur(Enqueteur enqueteur, String nom, String prenom, String adresse, String telephonePro, String telephonePerso, String email, String faxPro, TitreEnqueteur titre, ServiceEnqueteur service) throws Exception {
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
	}
	
	/**
	 * Delete an Enqueteur
	 * @param: enqueteur: Entity to delete
	 */
	public void supprimerEnqueteur(Enqueteur enqueteur) throws Exception {
		enqueteur.delete();
	}
	
	/**
	 * Get HashMap containing data of a specific Enqueteur
	 * @param: enqueteur: Entity to consult
	 */
	public HashMap<String,Object> consulterEnqueteur(Enqueteur enqueteur) {
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("id", enqueteur.getId());
		result.put("nom", enqueteur.getNom());
		result.put("prenom", enqueteur.getPrenom());
		result.put("adresse", enqueteur.getAdresse());
		result.put("telephone_pro", enqueteur.getTelephonePro());
		result.put("telephone_perso", enqueteur.getTelephonePerso());
		result.put("email",enqueteur.getEmail());
		result.put("fax_pro", enqueteur.getFaxPro());
		result.put("id_titre", enqueteur.getTitre());
		result.put("id_service", enqueteur.getService());
		
		return result;
	}
	
	/**
	 * Load an ArrayList of Enqueteur using a filter
	 * @param: filter: condition to respect in the query
	 */
	public ArrayList<Enqueteur> chargerEnqueteur(HashMap<String,String> filter) {
		eMng = new EnqueteurManagerDB();
		eMng.loadEnqueteurs(filter);
		return eMng.getListeEnqueteurs();
	}
	
}