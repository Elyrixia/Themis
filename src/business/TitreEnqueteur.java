package business;

import java.util.HashMap;

public abstract class TitreEnqueteur extends Titre implements Business {

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
}
