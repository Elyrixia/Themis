/**
 * @author Tristan Sallé
 */

package business.affaire;

import java.util.HashMap;

import business.Business;

public abstract class Objet implements Business {

	/**
	 * The id on the database
	 */
	protected int id;
	
	protected String libelle;
	
	protected String comment;
	
	protected Scelle idScelle;
	
	protected TypeObjet idType;
	
	protected Objet idObjet;
	
	public Objet() {}
	
	/**
	 * @see load() from interface Business
	 */
	public void load(HashMap<String, Object> map) {
		this.id = (int) map.get("id");
		this.libelle = (String) map.get("libelle");
		this.comment = (String) map.get("comment");
		this.idScelle = (Scelle) map.get("id_scelle");
		this.idType = (TypeObjet) map.get("id_type");
		this.idObjet = (Objet) map.get("id_objet");
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Scelle getIdScelle() {
		return idScelle;
	}

	public void setIdScelle(Scelle idScelle) {
		this.idScelle = idScelle;
	}

	public TypeObjet getIdType() {
		return idType;
	}

	public void setIdType(TypeObjet idType) {
		this.idType = idType;
	}

	public Objet getIdObjet() {
		return idObjet;
	}

	public void setIdObjet(Objet idObjet) {
		this.idObjet = idObjet;
	}
	
	public String toString() {
		String message = "Objet #"+this.id+" - "+this.libelle;
		
		return message;
	}
	
	/**
	 * @see equals() from Business interface
	 */
	public boolean equals(Business a) {
		return this.id == ((Objet)a).getId();
	}
	
}
