package business;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class FacadeCorpsEnqueteur {

	// ATTRIBUTES
	
	/**
	 * Manager qui permet d'acceder aux entites souhaitees
	 */
	private CorpsEnqueteurManager ceMng;
	
	// CONSTRUCTOR
	
	public FacadeCorpsEnqueteur() {}
	
	// METHODS
	
	/**
	 * Permet d'ajouter un nouveau corps d'enqueteur
	 * @libelle: Le libelle de ce corps
	 * @titres: La liste des titres lies a ce corps
	 */
	public Exception ajouterCorpsEnqueteur(String libelle, ArrayList<TitreEnqueteur> titres) {
		try {
			CorpsEnqueteur newCorps = new CorpsEnqueteur();
			newCorps.create(libelle,titres);
			return 1;
		} catch(Exception e) {
			return 0;
		}
		
	}
	/**
	 * Permet de modifier un corps d'enqueteur existant
	 * @corps: L'entite a modifier
	 * @libelle: Le nouveau libelle de ce corps
	 */
	public Exception modifierCorpsEnqueteur(CorpsEnqueteur corps, String libelle) {
		try {
			corps.setAttributes(libelle);
			return 1;
		} catch(Exception e) {
			return 0;
		}
	}
	
	/**
	 * Permet de supprimer un corps d'enqueteur existant
	 * @corps: L'entite a supprimer
	 */
	public Exception supprimerCorpsEnqueteur(CorpsEnqueteur corps) {
		try {
			corps.delete();
			return 1;
		} catch(Exception e) {
			return 0;
		}
	}
	
	/**
	 * ?
	 */
	public void consulterCorpsEnqueteur(CorpsEnqueteur corps) {
		
	}
	
	/**
	 * Permet de charger les corps d'enqueteur souhaites en fonction du filtre a appliquer
	 * @filter: Le filtre a appliquer
	 */
	public ArrayList<CorpsEnqueteur> chargerCorpsEnqueteur(HashMap filter) {
		ceMng = new CorpsEnqueteurManager();
		ceMng.loadAffaires(filter);
		return ceMng.listeAffaires;
	}
	
}
