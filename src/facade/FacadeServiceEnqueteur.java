/**
 * @author Nathan Marin
 */

package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import persistence.DBFactory;
import persistence.Factory;
import business.enqueteur.CorpsEnqueteur;
import business.enqueteur.ServiceEnqueteur;
import business.enqueteur.ServiceEnqueteurManager;
import business.enqueteur.ServiceEnqueteurManagerDB;

public class FacadeServiceEnqueteur extends FacadeAbstraite {

	// ATTRIBUTES
	
	/**
	 * Manager to load entities
	 */
	private ServiceEnqueteurManager seMng;
	
	// CONSTRUCTOR
	
	public FacadeServiceEnqueteur() {}
	
	// METHODS
	
	/**
	 * Add a new ServiceEnqueteur
	 * @param: Service attributes
	 */
	public ServiceEnqueteur ajouterServiceEnqueteur(String libelle, String telephone, String lieu, CorpsEnqueteur corps) throws Exception {
		Factory fac = DBFactory.getInstance();
		ServiceEnqueteur newService = fac.createServiceEnqueteur();
		
		newService.setLibelle(libelle);
		newService.setTelephone(telephone);
		newService.setLieu(lieu);
		newService.setCorps(corps);
		
		newService.create();
			
		return newService;
	}
	
	/**
	 * Edit a ServiceEnqueteur
	 * @param: Service attributes
	 */
	public void modifierServiceEnqueteur(ServiceEnqueteur service, String libelle, String telephone, String lieu, CorpsEnqueteur corps) throws Exception {
		service.setLibelle(libelle);
		service.setTelephone(telephone);
		service.setLieu(lieu);
		service.setCorps(corps);
			
		service.update();
	}
	
	/**
	 * Delete a ServiceEnqueteur
	 * @param: service: Entity to delete
	 */
	public void supprimerServiceEnqueteur(ServiceEnqueteur service) throws Exception {
		service.delete();
	}
	
	/**
	 * Get HashMap containing data of a specific ServiceEnqueteur
	 * @param: corps: Entity to consult
	 */
	public HashMap<String,Object> consulterServiceEnqueteur(ServiceEnqueteur service) {
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("id", service.getId());
		result.put("libelle", service.getLibelle());
		result.put("telephone", service.getTelephone());
		result.put("lieu", service.getLieu());
		result.put("id_corps", service.getCorps());
		result.put("nombre d'enqueteurs travaillant dans ce service", service.getNbEnqueteurs());
		return result;
	}
	
	/**
	 * Get ArrayList<String> containing a toString for each ServiceEnqueteur
	 * 
	 * @param: listeServicesEnqueteur: ArrayList to read
	 */
	public ArrayList<String> getApercu(ArrayList<ServiceEnqueteur> listeServicesEnqueteur) {
		
		ArrayList<String> listeApercus = new ArrayList<String>();
		Iterator<ServiceEnqueteur> it = listeServicesEnqueteur.iterator();
		
		while(it.hasNext()) {
			listeApercus.add(it.next().toString());
		}
		
		return listeApercus;
		
	}
	
	/**
	 * Load an ArrayList of ServiceEnqueteur using a filter
	 * @param: filter: condition to respect in the query
	 */
	public ArrayList<ServiceEnqueteur> chargerServiceEnqueteur(HashMap<String,String> filter) {
		seMng = new ServiceEnqueteurManagerDB();
		seMng.loadServicesEnqueteur(filter);
		return seMng.getListeServicesEnqueteur();
	}
	
}