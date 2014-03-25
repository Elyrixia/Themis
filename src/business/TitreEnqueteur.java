package business;

import java.util.HashMap;

public abstract class TitreEnqueteur extends Titre implements Business {
	
	
	public void load(HashMap map) {
		
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
}
