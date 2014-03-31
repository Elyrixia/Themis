package business.affaire;

import java.util.HashMap;

import business.Business;

public abstract class Frais implements Business {

	/**
	 * The id on the database
	 */
	protected int id;
	
	protected String libelle;
	
	protected int prix;
	
	protected Affaire idAffaire;
	
	/**
	 * @see create() from interface Business
	 */
	public abstract int create();

	/**
	 * @see update() from interface Business
	 */
	public abstract void update();

	/**
	 * @see load() from interface Business
	 */
	public void load(HashMap<String, Object> map) {
		this.id = (int) map.get("id");
		this.libelle = (String) map.get("libelle");
		this.prix = (int) map.get("prix");
		this.idAffaire = (Affaire) map.get("id_affaire");
	}

	/**
	 * @see create() from interface Business
	 */
	public abstract void delete() throws Exception;

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

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Affaire getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(Affaire idAffaire) {
		this.idAffaire = idAffaire;
	}
	
	public String toString() {
		String message = "Frais #"+this.id+" - "+this.libelle;
		
		return message;
	}
	
	/**
	 * @see equals() from Business interface
	 */
	public boolean equals(Business a) {
		return this.id == ((Frais)a).getId();
	}
	
}
