package persistence;

import business.*;

public class DBFactory extends Factory
{
	private static DBFactory instance = null;
	
	private DBFactory()
	{
		
	}
	
	public static DBFactory getInstance()
	{
		if(instance == null)
			instance = new DBFactory();
		return instance;
	}
		
	@Override
	public Enqueteur createEnqueteur()
	{
		return new EnqueteurDB();
	}

	@Override
	public CorpsEnqueteur createCorpsEnqueteur()
	{
		return new CorpsEnqueteurDB();
	}

	@Override
	public ServiceEnqueteur createServiceEnqueteur()
	{
		return new ServiceEnqueteurDB();
	}

	@Override
	public TitreEnqueteur createTitreEnqueteur()
	{
		return new TitreEnqueteurDB();
	}
	
	@Override
	public Affaire createAffaire() {
		return new AffaireDB();
	}
	
	@Override
	public Scelle createScelle() {
		return new ScelleDB();
	}

}
