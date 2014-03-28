package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import common.Utilitaire;

public class SQLManager
{
	private static SQLManager	instance	= null;
	private Connection			connection;
	private Statement			statement;
	
	public static final String	NO_WHERE	= "no_where";

	private SQLManager()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost/themis", "root", "boby34");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
		}
		if (connection == null)
		{
			try
			{
				connection = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net/sql434397", "sql434397", "qE1*kB2*");
				System.err.println("WARNING : You are using a remote database : sql4.freemysqlhosting.net/sql434397");
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try
		{
			statement = connection.createStatement();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Get the singleton instance
	 * 
	 * @return THE instance of SQLManager that should be used for the application.
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
	public ResultSet select(String table, ArrayList<String> fields, String where)
	{
		String query = "SELECT ";
		query += Utilitaire.implode(",", fields);
		query += " FROM " + table;
		
		if(where != SQLManager.NO_WHERE)
		{
			query += " WHERE " + where;
		}
		
		System.out.println(query);
		
		try
		{
			return statement.executeQuery(query);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param tableName
	 * @param where
	 * @return
	 */
	public ResultSet select(String tableName, String where)
	{
		ArrayList<String> allFields = new ArrayList<String>();
		allFields.add("*");
		
		return select(tableName, allFields, where);
	}

	/**
	 * 
	 * @param table
	 * @param fieldsValues
	 */
	public void insert(String table, HashMap<String, String> fieldsValues)
	{

		String query = "INSERT INTO " + table + "(";

		ArrayList<String> fields = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();

		for (String key : fieldsValues.keySet())
		{
			fields.add(key);
			values.add("'" + fieldsValues.get(key) + "'");
		}

		query += Utilitaire.implode(",", fields);
		query += ") VALUES(";
		query += Utilitaire.implode(",", values);
		query += ")";

		System.out.println(query);

		// executing the query
		this._executeQuery(query);
	}

	/**
	 * 
	 * @param table
	 * @param fieldsValues
	 * @param where
	 */
	public void update(String table, HashMap<String, String> fieldsValues, String where)
	{
		String query = "UPDATE " + table + " SET ";
		String value;
		for (String column : fieldsValues.keySet())
		{
			value = fieldsValues.get(column);
			query += column + "='" + value + "',";
		}

		query = query.substring(0, query.length() - 1); // Getting rid of the last ',

		query += " WHERE " + where;

		System.out.println(query);
		
		// executing the query
		this._executeQuery(query);
	}

	/**
	 * Creates and executes a DELETE query
	 * 
	 * @param table table in which lines have to be deleted
	 * @param where the where clause of the query
	 */
	public void delete(String table, String where)
	{

		// building the query
		String query = "DELETE FROM ";
		query += table;
		if (where != SQLManager.NO_WHERE)
			query += " WHERE " + where;

		System.out.println(query);

		// executing the query
		this._executeQuery(query);
	}

	/**
	 * 
	 * @param query
	 *            : The query to be executed on the Database
	 * 
	 */
	private void _executeQuery(String query)
	{
		try
		{
			statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}
}
