package business.enqueteur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import persistence.SQLManager;

public class CorpsEnqueteurDB extends CorpsEnqueteur
{
	/**
	 * Correspondence with the table in the database
	 */
	public static final String TABLE_NAME = "corps_enqueteur";
	
	@Override
	public int create() {
		SQLManager sql = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("libelle", this.libelle);
		
		// Run the query
		this.id = sql.insert(TABLE_NAME, map);

		return this.id;
	}

	@Override
	public void update() {
		SQLManager sqlManager = SQLManager.getConnection();
		
		// Prepare the query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("libelle", this.libelle);
		String where = "id = "+this.id;
		
		// Run the query
		sqlManager.update(TABLE_NAME, map, where);
	}

	@Override
	public void delete() throws Exception {
		SQLManager sqlManager = SQLManager.getConnection();
		
		ResultSet rs = sqlManager.select(ServiceEnqueteurDB.TABLE_NAME, "id_corps = " + this.id);
		try {
			rs.last();
			int nbServices = rs.getRow();
			if(nbServices > 0) {
				throw new Exception("This Corps is used by " + nbServices + " service(s)!\nDeletion aborted.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Prepare the query
		String where = "id = "+this.id;
		
		// Run the query
		sqlManager.delete(TABLE_NAME, where);
	}
	
	/**
	 * 
	 * @return the number of services that depend on this corps
	 */
	public int getNbServices() {
		
		SQLManager sqlManager = SQLManager.getConnection();
		return sqlManager.count(ServiceEnqueteurDB.TABLE_NAME, "id_corps = " + this.id);
	}
}
