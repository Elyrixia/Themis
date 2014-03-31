/**
 * @author Nathan Marin
 */

package business.enqueteur;

import java.util.HashMap;

import business.Business;

public abstract class CorpsEnqueteur implements Business {

	/**
	 * The id in the database
	 */
	protected int id;
	
	/**
	 * The name of the structure of detectives (e.g. Police)
	 */
	protected String libelle;
	
	
	public CorpsEnqueteur() {
		
	}

	/**
	 * @see load() from interface Business
	 */
	public void load(HashMap<String, Object> map) {
		this.id = (int) map.get("id");
		this.libelle = (String) map.get("libelle");
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
	public abstract void delete() throws Exception;
	
	public abstract int getNbServices();
	
	// setters and getters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) throws Exception {
		if(libelle.length() > 60)
			throw new Exception("The label length must not exceed 60 characters!");
		
		this.libelle = libelle;
	}
	
	public String toString() {
		String message = "CorpsEnqueteur #"+this.id+" - "+this.libelle;
		
		return message;
	}
	
	/**
	 * @see equals() from Business interface
	 */
	public boolean equals(Business a) {
		return this.id == ((CorpsEnqueteur)a).getId();
	}
	
}
