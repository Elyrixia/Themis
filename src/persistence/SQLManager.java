package persistence;

import java.sql.*;
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

	public static SQLManager getConnection()
	{
		if (instance == null)
			instance = new SQLManager();

		return instance;
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
