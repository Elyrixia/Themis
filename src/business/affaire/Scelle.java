package business.affaire;

import java.util.Date;
import java.util.HashMap;

import business.Business;

public abstract class Scelle implements Business {
	
	/**
	 * The id on the database
	 */
	protected int id;
	
	protected int numProces;
	
	protected Date dateRecup;
	
	protected String lieuRecup;
	
	protected String comment;
	
	protected Affaire idAffaire;
	
	/**
	 * ID of the container. NULL if the current Scelle is the master container
	 */
	protected Scelle idScelle;
	
	public Scelle() {}

	/**
	 * @see load() from interface Business
	 */
	public void load(HashMap<String, Object> map) {
		this.id = (int) map.get("id");
		this.numProces = (int) map.get("num_proces");
		this.dateRecup = (Date) map.get("date_recup");
		this.lieuRecup = (String) map.get("lieu_recup");
		this.comment = (String) map.get("comment");
		this.idAffaire = (Affaire) map.get("id_affaire");
		this.idScelle = (Scelle) map.get("id_scelle");
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

	public int getNumProces() {
		return numProces;
	}

	public void setNumProces(int numProces) {
		this.numProces = numProces;
	}

	public Date getDateRecup() {
		return dateRecup;
	}

	public void setDateRecup(Date dateRecup) {
		this.dateRecup = dateRecup;
	}

	public String getLieuRecup() {
		return lieuRecup;
	}

	public void setLieuRecup(String lieuRecup) {
		this.lieuRecup = lieuRecup;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Affaire getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(Affaire idAffaire) {
		this.idAffaire = idAffaire;
	}

	public Scelle getIdScelle() {
		return idScelle;
	}

	public void setIdScelle(Scelle idScelle) {
		this.idScelle = idScelle;
	}
	
}
