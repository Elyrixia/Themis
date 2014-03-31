/**
 * @author Alexandre Laffaille, Nathan Marin, Benoit Ruiz, Tristan Sallé
 */

package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { EnqueteurDBTest.class, TitreEnqueteurDBTest.class, 
						ServiceEnqueteurDBTest.class, CorpsEnqueteurDBTest.class,
						AffaireDBTest.class, ScelleDBTest.class,
						ObjetDBTest.class, TypeObjetDBTest.class, FraisDBTest.class })
public class BusinessDBTestSuite {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("Business DB Test Suite - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("Business DB Suite - END");
	}
	
}
