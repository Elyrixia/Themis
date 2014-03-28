package persistence;

import business.*;
import business.affaire.Affaire;
import business.affaire.AffaireDB;
import business.affaire.Scelle;
import business.affaire.ScelleDB;
import business.affaire.TypeObjet;
import business.affaire.TypeObjetDB;
import business.enqueteur.CorpsEnqueteur;
import business.enqueteur.CorpsEnqueteurDB;
import business.enqueteur.Enqueteur;
import business.enqueteur.EnqueteurDB;
import business.enqueteur.ServiceEnqueteur;
import business.enqueteur.ServiceEnqueteurDB;
import business.enqueteur.TitreEnqueteur;
import business.enqueteur.TitreEnqueteurDB;

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
	
	@Override
	public TypeObjet createTypeObjet() {
		return new TypeObjetDB();
	}

}
