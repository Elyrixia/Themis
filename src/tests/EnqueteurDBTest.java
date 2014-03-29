package tests;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.enqueteur.CorpsEnqueteur;
import business.enqueteur.CorpsEnqueteurDB;
import business.enqueteur.Enqueteur;
import business.enqueteur.EnqueteurDB;
import business.enqueteur.ServiceEnqueteur;
import business.enqueteur.ServiceEnqueteurDB;
import business.enqueteur.TitreEnqueteur;
import business.enqueteur.TitreEnqueteurDB;

public class EnqueteurDBTest {
	
	private Enqueteur e;

	@Before
	public void setUp() throws Exception {
		
		TitreEnqueteur t = new TitreEnqueteurDB();
		t.setId(9999);
		t.setLibelle("test_titre");
		ServiceEnqueteur s = new ServiceEnqueteurDB();
		s.setId(9999);
		s.setLibelle("test_service");
		s.setLieu("test_lieu");
		s.setTelephone("0011223344");
		CorpsEnqueteur c = new CorpsEnqueteurDB();
		c.setId(9999);
		c.setLibelle("test_corps");
		s.setCorps(c);
		e = new EnqueteurDB();
		
		e.setTitre(t);
		e.setService(s);
		e.setNom("test_nom");
		e.setPrenom("test_prenom");
		e.setAdresse("test_adresse");
		e.setTelephonePerso("0011223344");
		e.setEmail("test_email@bob.fr");
		e.setFaxPro("0011223344");
		e.setTelephonePro("0011223344");
		
	}

	@Test
	public void createTest() {
		
		e.create();
		assertNotNull(e.getId());
	}
	
	@Test
	public void updateTest() {
		
		//e.create();
		//assertNotNull(e.getId());
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("EnqueteurDB Test - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("EnqueteurDB Test - END");
	}
}
