package business;

import java.util.HashMap;

public abstract class ServiceEnqueteur implements Business {

	/**
	 * The name of the service
	 */
	private String libelle;
	
	/**
	 * The phone number of the service
	 */
	private String telephone;
	
	/**
	 * The location (full address) of the service
	 */
	private String lieu;
	
	/**
	 * @see load() from interface Business
	 */
	public abstract void load(HashMap map);
	
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
