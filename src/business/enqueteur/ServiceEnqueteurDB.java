package business.enqueteur;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	public void delete() throws Exception
	{
		SQLManager sqlManager = SQLManager.getConnection();
		
		ResultSet rs = sqlManager.select(EnqueteurDB.TABLE_NAME, "id_service = " + this.id);
		try {
			rs.last();
			int nbEnqueteurs = rs.getRow();
			if(nbEnqueteurs > 0) {
				throw new Exception("This service is used by " + nbEnqueteurs + " detective(s)!\nDeletion aborted.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Prepare the query
		String where = "id = " + this.id;

		// Run the query
		sqlManager.delete(TABLE_NAME, where);
	}
	
	/**
	 * 
	 * @return the number of detectives that work in this service
	 */
	public int getNbEnqueteurs() {
		
		SQLManager sqlManager = SQLManager.getConnection();
		return sqlManager.count(EnqueteurDB.TABLE_NAME, "id_service = " + this.id);
	}

}
