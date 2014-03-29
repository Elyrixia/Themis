package facade;

import business.Business;

public abstract class FacadeAbstraite {
	
	/**
	 * Get toString of a Business object
	 * 
	 * @param: business: Business object to read
	 */
	public  String getApercu(Business business) {
		return business.toString();
	}

}
