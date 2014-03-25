package business;

<<<<<<< Updated upstream:business/Enqueteur.java
public abstract class Enqueteur extends Personne implements Business
{
=======
import java.util.HashMap;

public abstract class Enqueteur extends Personne implements Business {
>>>>>>> Stashed changes:src/business/Enqueteur.java

	/**
	 * The title of the detective (for example, "Lieutenant")
	 */
	private TitreEnqueteur titre;

	/**
	 * The service where the detective works (for instance, police station)
	 */
	private ServiceEnqueteur service;

	/**
	 * The personal phone number of the detective
	 */
	private String telephonePerso;
	
	/**
	 * @see load() from interface Business
	 */
	public abstract void load(HashMap map);
	
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

	public TitreEnqueteur getTitre()
	{
		return titre;
	}

	public void setTitre(TitreEnqueteur titre)
	{
		this.titre = titre;
	}

	public ServiceEnqueteur getService()
	{
		return service;
	}

	public void setService(ServiceEnqueteur service)
	{
		this.service = service;
	}

	public String getTelephonePerso()
	{
		return telephonePerso;
	}

	public void setTelephonePerso(String telephonePerso)
	{
		this.telephonePerso = telephonePerso;
	}
<<<<<<< Updated upstream:business/Enqueteur.java

}
=======
	
}
>>>>>>> Stashed changes:src/business/Enqueteur.java
