package business;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.HashMap;

public abstract class CorpsEnqueteur implements Business {

	/**
	 * The name of the structure of detectives (e.g. Police)
	 */
	private String libelle;
	
	/**
	 * The list of services related to this structure
	 */
	private ArrayList<ServiceEnqueteur> listeServices;
	
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
