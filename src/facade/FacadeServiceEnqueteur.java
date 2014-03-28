package facade;

import java.util.ArrayList;
import java.util.HashMap;

import persistence.DBFactory;
import persistence.Factory;
import business.ServiceEnqueteur;
import business.ServiceEnqueteurManager;
import business.ServiceEnqueteurManagerDB;

public class FacadeServiceEnqueteur {

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
	public ServiceEnqueteur ajouterServiceEnqueteur(String libelle, String telephone, String lieu) throws Exception {
		Factory fac = DBFactory.getInstance();
		ServiceEnqueteur newService = fac.createServiceEnqueteur();
		
		newService.setLibelle(libelle);
		newService.setTelephone(telephone);
		newService.setLieu(lieu);
		
		newService.create();
			
		return newService;
	}
	
	/**
	 * Edit a ServiceEnqueteur
	 * @param: Service attributes
	 */
	public void modifierServiceEnqueteur(ServiceEnqueteur service, String libelle, String telephone, String lieu) throws Exception {
		service.setLibelle(libelle);
		service.setTelephone(telephone);
		service.setLieu(lieu);
			
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
		return result;
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