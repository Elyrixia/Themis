/**
 * @author Alexandre Laffaille, Nathan Marin, Benoit Ruiz, Tristan Sallé
 */

package facade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import persistence.DBFactory;
import persistence.Factory;
import business.affaire.Affaire;
import business.affaire.AffaireManager;
import business.affaire.AffaireManagerDB;
import business.enqueteur.Enqueteur;

public class FacadeAffaire extends FacadeAbstraite {

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
	public Affaire ajouterAffaire(String nom, int numDossier, int numInstruction, 
			int numParquet, Date dateOrdre, Date dateRendu, boolean delai, String comment, 
			Enqueteur enqueteur) throws Exception
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
		newAffaire.setComment(comment);
		newAffaire.setEnqueteur(enqueteur);
		
		newAffaire.create();

		return newAffaire;
	}

	/**
	 * Edit an Affaire
	 * @param: Affaire attributes
	 */
	public void modifierAffaire(Affaire affaire, String nom, int numDossier, 
			int numInstruction, int numParquet, Date dateOrdre, Date dateRendu, boolean delai, 
			String comment, Enqueteur enqueteur) throws Exception
	{
		affaire.setNom(nom);
		affaire.setNumDossier(numDossier);
		affaire.setNumInstruction(numInstruction);
		affaire.setNumParquet(numParquet);
		affaire.setDateOrdre(dateOrdre);
		affaire.setDateRendu(dateRendu);
		affaire.setDelai(delai);
		affaire.setComment(comment);
		affaire.setEnqueteur(enqueteur);
		
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
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		result.put("id", affaire.getId());
		result.put("nom", affaire.getNom());
		result.put("num_dossier", affaire.getNumDossier());
		result.put("num_instruction", affaire.getNumInstruction());
		result.put("num_parquet", affaire.getNumParquet());
		result.put("date_ordre", df.format(affaire.getDateOrdre()));
		result.put("date_rendu", df.format(affaire.getDateRendu()));
		result.put("delai", affaire.getDelai());
		result.put("comment", affaire.getComment());
		result.put("id_enqueteur", affaire.getEnqueteur());
		
		return result;
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
