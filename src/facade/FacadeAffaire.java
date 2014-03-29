package facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import persistence.DBFactory;
import persistence.Factory;
import business.affaire.Affaire;
import business.affaire.AffaireManager;
import business.affaire.AffaireManagerDB;

public class FacadeAffaire {

	//ATTRIBUTES

	/**
	 * Manager to load entities
	 */
	private AffaireManager	aMng;

	// CONSTRUCTOR

	public FacadeAffaire() {}

	// METHODS
	/**
	 * Add a new Affaire
	 * @param: Affaire attributes
	 */
	public Affaire ajouterAffaire(String nom, int numDossier, int numInstruction, int numParquet, Date dateOrdre, Date dateRendu, boolean delai) throws Exception
	{
		Factory fac = DBFactory.getInstance();
		Affaire newAffaire = fac.createAffaire();

		newAffaire.setNom(nom);
		newAffaire.setNumDossier(numDossier);
		newAffaire.setNumInstruction(numInstruction);
		newAffaire.setNumParquet(numParquet);
		newAffaire.setDateOrdre(dateOrdre);
		newAffaire.setDateRendu(dateRendu);
		newAffaire.setDelai(delai);

		newAffaire.create();

		return newAffaire;
	}

	/**
	 * Edit an Affaire
	 * @param: Affaire attributes
	 */
	public void modifierAffaire(Affaire affaire, String nom, int numDossier, int numInstruction, int numParquet, Date dateOrdre, Date dateRendu, boolean delai) throws Exception
	{
		affaire.setNom(nom);
		affaire.setNumDossier(numDossier);
		affaire.setNumInstruction(numInstruction);
		affaire.setNumParquet(numParquet);
		affaire.setDateOrdre(dateOrdre);
		affaire.setDateRendu(dateRendu);
		affaire.setDelai(delai);

		affaire.update();
	}

	/**
	 * Delete an Affaire
	 * 
	 * @param: affaire: Entity to delete
	 */
	public void supprimerAffaire(Affaire affaire) throws Exception
	{
		affaire.delete();
	}

	/**
	 * Get HashMap containing data of a specific Affaire
	 * 
	 * @param: affaire: Entity to consult
	 */
	public HashMap<String, Object> consulterAffaire(Affaire affaire)
	{
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("id", affaire.getId());
		result.put("nom", affaire.getNom());
		result.put("num_dossier", affaire.getNumDossier());
		result.put("num_instruction", affaire.getNumInstruction());
		result.put("num_parquet", affaire.getNumParquet());
		result.put("date_ordre", affaire.getDateOrdre());
		result.put("date_rendu", affaire.getDateRendu());
		result.put("delai", affaire.getDelai());
		return result;
	}

	/**
	 * Get ArrayList<String> containing a toString for each Affaire
	 * 
	 * @param: listeAffaires: ArrayList to read
	 */
	public ArrayList<String> getApercu(ArrayList<Affaire> listeAffaires) {
		
		ArrayList<String> listeApercus = new ArrayList<String>();
		Iterator<Affaire> it = listeAffaires.iterator();
		
		while(it.hasNext()) {
			listeApercus.add(it.next().toString());
		}
		
		return listeApercus;
		
	}
	
	
	/**
	 * Load an ArrayList of Affaire using a filter
	 * 
	 * @param: filter: condition to respect in the query
	 */
	public ArrayList<Affaire> chargerAffaire(HashMap<String, String> filter)
	{
		aMng = new AffaireManagerDB();
		aMng.loadAffaire(filter);
		return aMng.getListeAffaires();
	}
	
}
