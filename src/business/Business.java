/**
 * @author Alexandre Laffaille, Nathan Marin, Benoit Ruiz, Tristan Sallé
 */

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
	 * Loads all the attributes with the values of the parameter WITHOUT any control process on the values
	 * Because this method is only used by the XManagers, we are certain that the data comes from the DB. Therefore,
	 * there is no need of control. To control the values, we use the method setAttributes(HashMap).
	 * @param map HashMap containing the pairs Attribute -> Value
	 */
	public void load(HashMap<String, Object> map);
	
	/**
	 * Deletes the object from the database system
	 * Example: if JDBC is chosen, this method will use "DELETE..."
	 */
	public void delete() throws Exception;
	
	/**
	 * Compares the id of 2 Business objects
	 * @param a
	 * @return true if the id are the same, false otherwise
	 */
	public boolean equals(Business a);
}
	