package business;

import java.util.HashMap;

public interface Business 
{
	
	/**
	 * Add the object to the database system chosen
	 * Example: if JDBC is chosen, this method will use "INSERT..."
	 * @return the ID of the object created
	 */
	public int create();
	
	/**
	 * Updates the object already persisted in the database system
	 * Example: if JDBC is chosen, this method will use "UPDATE..."
	 */
	public void update();
	
	/**
	 * Loads all the attributes thanks to the parameter map
	 * @param map contains a map attribute -> value retrieved from the database system
	 */
	public void load(HashMap map);
	
	/**
	 * Deletes the object from the database system
	 * Example: if JDBC is chosen, this method will use "DELETE..."
	 */
	public void delete();
}
	