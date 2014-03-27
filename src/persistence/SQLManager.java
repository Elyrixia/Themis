package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SQLManager
{
	private static SQLManager instance = null;
	private Connection connection;
	private Statement statement;

	private SQLManager()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost/themis", "root", "boby34");
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
		}
		if (connection == null)
		{
			try
			{
				connection = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net/sql434397", "sql434397", "qE1*kB2*");
				System.err.println("WARNING : You are using a remote databse : sql4.freemysqlhosting.net/sql434397");
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try
		{
			statement = connection.createStatement();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Get the singleton instance
	 * @return	THE instance of SQLManager that should be used for the application.
	 */
	public static SQLManager getConnection()
	{
		if (instance == null)
			instance = new SQLManager();

		return instance;
	}
	
	/**
	 * 
	 * @param table
	 * @param fields
	 * @param where
	 */
	public void select(String table, ArrayList<String> fields, String where) {
		
		
	}
	
	/**
	 * 
	 * @param table
	 * @param fieldsValues
	 */
	public void insert(String table, HashMap<String, String> fieldsValues) {
		
		
	}
	
	/**
	 * 
	 * @param table
	 * @param fieldsValues
	 * @param where
	 */
	public void update(String table, HashMap<String, String> fieldsValues, String where) {
		
		
	}
	
	/**
	 * 
	 * @param table
	 * @param where
	 */
	public void delete(String table, String where) {
		
		
	}

	/**
	 * 
	 * @param query
	 *            : The query to be executed on the Database
	 * 
	 */
	public void query(String query)
	{
		try
		{
			statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param string
	 *            : A query with token to replace
	 * @param correspondance
	 *            : Correspondence between token and their values
	 */
	public void query(String string, HashMap<String, String> correspondance)
	{
		String newQuery = string;
		for (String key : correspondance.keySet())
		{
			newQuery = newQuery.replace(key, correspondance.get(key));
		}
		System.out.println(newQuery);
		query(newQuery);
	}
	
	/**
	 * 
	 */
	public ResultSet querySelect(String query) {
		try {
			return statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns the last ID updated in the Database
	 * 
	 * @return int : The last ID updated
	 */
	public int getLastID()
	{
		ResultSet lastID = null;
		try
		{
			lastID = statement.getGeneratedKeys();
			if (lastID.next())
				return lastID.getInt(1);

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}
}
