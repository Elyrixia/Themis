package business.affaire;

import java.util.HashMap;

import business.Business;

public abstract class TypeObjet implements Business {
	
	/**
	 * The id in the database
	 */
	protected int id;
	
	protected String libelle;
	
	public TypeObjet() {}

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
	public abstract void delete();
	
	// getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String toString() {
		String message = "TypeObjet n�"+this.id+" - "+this.libelle;
		
		return message;
	}
	
	public boolean equals(TypeObjet a) {
		return  id == a.getId() && 
				libelle.equals(a.getLibelle());
	}
	
}
