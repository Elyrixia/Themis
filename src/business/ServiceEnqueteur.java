package business;

import java.util.HashMap;

public abstract class ServiceEnqueteur implements Business {

	/**
	 * The id in the database
	 */
	protected int id;
	
	/**
	 * The name of the service
	 */
	protected String libelle;
	
	/**
	 * The phone number of the service
	 */
	protected String telephone;
	
	/**
	 * The location (full address) of the service
	 */
	protected String lieu;
	
	/**
	 * @see load() from interface Business
	 */
	public void load(HashMap<String, Object> map) {
		
		this.id = (int) map.get("id");
		this.libelle = (String) map.get("libelle");
		this.telephone = (String) map.get("telephone");
		this.lieu = (String) map.get("lieu");
	}
	
	public ServiceEnqueteur() {
		
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
}
