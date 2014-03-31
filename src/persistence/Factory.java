/**
 * @author Alexandre Laffaille, Nathan Marin, Benoit Ruiz, Tristan Sallé
 */

package persistence;

import business.affaire.*;
import business.enqueteur.*;

public abstract class Factory
{
	public abstract Enqueteur createEnqueteur();
	public abstract CorpsEnqueteur createCorpsEnqueteur();
	public abstract ServiceEnqueteur createServiceEnqueteur();
	public abstract TitreEnqueteur createTitreEnqueteur();
	public abstract Affaire createAffaire();
	public abstract Scelle createScelle();
	public abstract TypeObjet createTypeObjet();
	public abstract Objet createObjet();
	public abstract Frais createFrais();
}
