package business;

public abstract class Titre {

	/**
	 * The id in the database
	 */
	protected int id;
	
	/**
	 * The name of the title (example: "Lieutenant")
	 */
	protected String libelle;
	
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

	public void setLibelle(String libelle) throws Exception {
		if(libelle.length() > 60)
			throw new Exception("The label length must not exceed 60 characters!");
		
		this.libelle = libelle;
	}
	
	public String toString() {
		String message = "Titre #"+this.id+" - "+this.libelle;
		
		return message;
	}
	
	public boolean equals(Titre a) {
		return  id == a.getId() && 
				libelle.equals(a.getLibelle());
	}
	
}
