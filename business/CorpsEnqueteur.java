package business;

import java.util.ArrayList;

public abstract class CorpsEnqueteur {

	/**
	 * The name of the structure of detectives (e.g. Police)
	 */
	private String libelle;
	
	/**
	 * The list of services related to this structure
	 */
	private ArrayList<ServiceEnqueteur> listeServices;
	
}
