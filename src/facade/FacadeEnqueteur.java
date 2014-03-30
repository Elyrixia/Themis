package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import persistence.DBFactory;
import persistence.Factory;
import business.enqueteur.Enqueteur;
import business.enqueteur.EnqueteurManager;
import business.enqueteur.EnqueteurManagerDB;
import business.enqueteur.ServiceEnqueteur;
import business.enqueteur.TitreEnqueteur;

public class FacadeEnqueteur extends FacadeAbstraite {

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
		result.put("ID", enqueteur.getId());
		result.put("Nom", enqueteur.getNom());
		result.put("Prenom", enqueteur.getPrenom());
		result.put("Adresse", enqueteur.getAdresse());
		result.put("Telephone professionnel", enqueteur.getTelephonePro());
		result.put("Telephone personnel", enqueteur.getTelephonePerso());
		result.put("Email",enqueteur.getEmail());
		result.put("Fax profesionnel", enqueteur.getFaxPro());
		result.put("Titre", enqueteur.getTitre());
		result.put("Service", enqueteur.getService());
		result.put("Nombre d'affaires dans lesquelles cet enqueteur a travaille", enqueteur.getNbAffaires());
		
		return result;
	}
	
	/**
	 * Get ArrayList<String> containing a toString for each Enqueteur
	 * 
	 * @param: listeEnqueteurs: ArrayList to read
	 */
	public ArrayList<String> getApercu(ArrayList<Enqueteur> listeEnqueteurs) {
		
		ArrayList<String> listeApercus = new ArrayList<String>();
		Iterator<Enqueteur> it = listeEnqueteurs.iterator();
		
		while(it.hasNext()) {
			listeApercus.add(it.next().toString());
		}
		
		return listeApercus;
		
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