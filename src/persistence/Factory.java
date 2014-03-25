package persistence;

import business.*;

public abstract class Factory
{
	public abstract Enqueteur createEnqueteur();
	public abstract CorpsEnqueteur createCorpsEnqueteur();
	public abstract ServiceEnqueteur createServiceEnqueteur();
	public abstract TitreEnqueteur createTitreEnqueteur();
	
	
}
