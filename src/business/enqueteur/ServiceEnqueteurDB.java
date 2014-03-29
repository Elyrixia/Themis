package business.enqueteur;

import java.util.HashMap;

import persistence.SQLManager;

public class ServiceEnqueteurDB extends ServiceEnqueteur
{

	/**
	 * Correspondence with the table in the database
	 */
	public static final String	TABLE_NAME	= "service_enqueteur";

	@Override
	public int create()
	{
		SQLManager sql = SQLManager.getConnection();

		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("libelle", this.libelle);
		map.put("telephone", this.telephone);
		map.put("lieu", this.lieu);
		map.put("id_corps", String.valueOf(this.idCorps.getId()));

		// Run the query
		this.id = sql.insert(TABLE_NAME, map);

		return this.id;
	}

	@Override
	public void update()
	{
		SQLManager sqlManager = SQLManager.getConnection();

		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("libelle", this.libelle);
		map.put("telephone", this.telephone);
		map.put("lieu", this.lieu);
		map.put("id_corps", String.valueOf(this.idCorps.getId()));
		String where = "id = " + this.id;

		// Run the query
		sqlManager.update(TABLE_NAME, map, where);
	}

	@Override
	public void delete()
	{
		SQLManager sqlManager = SQLManager.getConnection();

		// Prepare the query
		String where = "id = " + this.id;

		// Run the query
		sqlManager.delete(TABLE_NAME, where);
	}

}