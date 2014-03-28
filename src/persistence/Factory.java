package persistence;

import business.*;
import business.affaire.Affaire;
import business.affaire.Scelle;
import business.affaire.TypeObjet;
import business.enqueteur.CorpsEnqueteur;
import business.enqueteur.Enqueteur;
import business.enqueteur.ServiceEnqueteur;
import business.enqueteur.TitreEnqueteur;

public abstract class Factory
{
	public abstract Enqueteur createEnqueteur();
	public abstract CorpsEnqueteur createCorpsEnqueteur();
	public abstract ServiceEnqueteur createServiceEnqueteur();
	public abstract TitreEnqueteur createTitreEnqueteur();
	public abstract Affaire createAffaire();
	public abstract Scelle createScelle();
	public abstract TypeObjet createTypeObjet();
}
