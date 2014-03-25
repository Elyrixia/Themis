package business;

public abstract class Enqueteur extends Personne
{

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

<<<<<<< HEAD
=======
	public TitreEnqueteur getTitre() {
		return titre;
	}

	public void setTitre(TitreEnqueteur titre) {
		this.titre = titre;
	}

	public ServiceEnqueteur getService() {
		return service;
	}

	public void setService(ServiceEnqueteur service) {
		this.service = service;
	}

	public String getTelephonePerso() {
		return telephonePerso;
	}

	public void setTelephonePerso(String telephonePerso) {
		this.telephonePerso = telephonePerso;
	}
	
	
>>>>>>> ec95cd2582944916cb50aa43dca1d4b831c19b48
}
