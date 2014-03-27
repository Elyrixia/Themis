package business;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class CorpsEnqueteur implements Business {

	/**
	 * The id in the database
	 */
	protected int id;
	
	/**
	 * The name of the structure of detectives (e.g. Police)
	 */
	protected String libelle;
	
	/**
	 * The list of services related to this structure
	 */
	private ArrayList<ServiceEnqueteur> listeServices;
	
	public CorpsEnqueteur() {
		
	}

	/**
	 * @see load() from interface Business
	 */
	public void load(HashMap<String, Object> map) {
		
		this.id = (int) map.get("id");
		this.libelle = (String) map.get("libelle");
		this.listeServices = (ArrayList<ServiceEnqueteur>) map.get("listeServices");
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
	
	// setters and getters
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public ArrayList<ServiceEnqueteur> getListeServices() {
		return listeServices;
	}

	public void setListeServices(ArrayList<ServiceEnqueteur> listeServices) {
		this.listeServices = listeServices;
	}
}
