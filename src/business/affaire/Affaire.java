package business.affaire;

import java.util.Date;
import java.util.HashMap;

import business.Business;
import business.enqueteur.Enqueteur;

public abstract class Affaire implements Business {
	
	/**
	 * The id on the database
	 */
	protected int id;
	
	/**
	 * The name of the case
	 */
	protected String nom;
	
	protected int numDossier;
	
	protected int numInstruction;
	
	protected int numParquet;
	
	protected Date dateOrdre;
	
	/**
	 * The date when the case report is over
	 */
	protected Date dateRendu;
	
	/**
	 * If a delay of 10 days is required before opening the "Scelles"
	 */
	protected boolean delai;
	
	protected String comment;
	
	protected Enqueteur idEnqueteur;
	
	public Affaire() {
		
	}
	
	/**
	 * @see load() from interface Business
	 */
	public void load(HashMap<String, Object> map) {
		this.id = (int) map.get("id");
		this.nom = (String) map.get("nom");
		this.numDossier = (int) map.get("num_dossier");
		this.numInstruction = (int) map.get("num_instruction");
		this.numParquet = (int) map.get("num_parquet");
		this.dateOrdre = (Date) map.get("date_ordre");
		this.dateRendu = (Date) map.get("date_rendu");
		this.delai = (boolean) map.get("delai");
		this.comment = (String) map.get("comment");
		this.idEnqueteur = (Enqueteur) map.get("id_enqueteur");
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
	
	// getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNumDossier() {
		return numDossier;
	}

	public void setNumDossier(int numDossier) {
		this.numDossier = numDossier;
	}

	public int getNumInstruction() {
		return numInstruction;
	}

	public void setNumInstruction(int numInstruction) {
		this.numInstruction = numInstruction;
	}

	public int getNumParquet() {
		return numParquet;
	}

	public void setNumParquet(int numParquet) {
		this.numParquet = numParquet;
	}

	public Date getDateOrdre() {
		return dateOrdre;
	}

	public void setDateOrdre(Date dateOrdre) {
		this.dateOrdre = dateOrdre;
	}

	public Date getDateRendu() {
		return dateRendu;
	}

	public void setDateRendu(Date dateRendu) {
		this.dateRendu = dateRendu;
	}

	public boolean getDelai() {
		return delai;
	}

	public void setDelai(boolean delai) {
		this.delai = delai;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setEnqueteur(Enqueteur e) {
		this.idEnqueteur = e;
	}
	
	public Enqueteur getEnqueteur() {
		return idEnqueteur;
	}
	
	public String toString() {
		String message = "Affaire #"+this.id+" - "+this.nom;
		
		return message;
	}
	
	/**
	 * @see equals() from Business interface
	 */
	public boolean equals(Business a) {
		return this.id == ((Affaire)a).getId();
	}
	
}
