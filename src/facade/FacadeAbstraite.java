/**
 * @author Tristan Sallé
 */

package facade;

import business.Business;

public abstract class FacadeAbstraite {
	
	/**
	 * Get toString of a Business object
	 * 
	 * @param: business: Business object to read
	 */
	public  String getApercu(Business business) {
		return business == null ? "Aucun" : business.toString();
	}
	
	/**
	 * Compare the values of the properties of 2 business instances
	 * @param a
	 * @param b
	 * @return true if the instances have the same properties/values, false otherwise
	 */
	public boolean compare(Business a, Business b) {
		if(a == null && b == null) {
			return true;
		}
		else if(a != null && b != null) {
			return a.equals(b); // !!!!! Appelle le equals() de Object !!!!!!
		}
		else {
			return false;
		}
	}

}
