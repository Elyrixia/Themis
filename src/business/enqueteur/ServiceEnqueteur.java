package business.enqueteur;

import java.util.HashMap;

import business.Business;

public abstract class ServiceEnqueteur implements Business
{

	/**
	 * The id in the database
	 */
	protected int				id;

	/**
	 * The name of the service
	 */
	protected String			libelle;

	/**
	 * The phone number of the service
	 */
	protected String			telephone;

	/**
	 * The location (full address) of the service
	 */
	protected String			lieu;

	/**
	 * The CorpsEnqueteur concerned by this Service
	 */
	protected CorpsEnqueteur	idCorps;

	/**
	 * @see load() from interface Business
	 */
	public void load(HashMap<String, Object> map)
	{
		this.id = (int) map.get("id");
		this.libelle = (String) map.get("libelle");
		this.telephone = (String) map.get("telephone");
		this.lieu = (String) map.get("lieu");
		this.idCorps = (CorpsEnqueteur) map.get("id_corps");
	}

	public ServiceEnqueteur()
	{

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

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getLibelle()
	{
		return libelle;
	}

	public void setLibelle(String libelle) throws Exception
	{
		if (libelle.length() > 255)
			throw new Exception("The label length must not exceed 255 characters!");

		this.libelle = libelle;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone) throws Exception
	{
		if (telephone.length() > 14)
			throw new Exception("The phone number length must not exceed 14 characters!");

		this.telephone = telephone;
	}

	public String getLieu()
	{
		return lieu;
	}

	public void setLieu(String lieu) throws Exception
	{
		if (lieu.length() > 255)
			throw new Exception("The place length must not exceed 255 characters!");

		this.lieu = lieu;
	}

	public CorpsEnqueteur getCorps()
	{
		return idCorps;
	}

	public void setCorps(CorpsEnqueteur corps) throws Exception
	{
		if (corps == null)
			throw new Exception("The CorpsEnqueteur wasn't instancied properly!");

		this.idCorps = corps;
	}

}
