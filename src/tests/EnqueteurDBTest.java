/**
 * @author Alexandre Laffaille
 */

package tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		
		e = new EnqueteurDB();
		e.setId(9999);
		
		TitreEnqueteur t = mock(TitreEnqueteurDB.class);
		ServiceEnqueteur s = mock(ServiceEnqueteurDB.class);
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
	public void equalsTest() throws Exception {
		
		Enqueteur en = new EnqueteurDB();
		en.setId(9999);
		
		assertEquals(e.equals(en), true);
		
		en.setId(9998);
		
		assertEquals(e.equals(en), false);
	}
	
	@Test
	public void toStringTest() {
		
		String message = "Enqueteur #9999 - test_nom test_prenom";
		
		String messageToCompare = e.toString();
		
		assertEquals(messageToCompare, message);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getHashMapTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("nom", "test_nom");
		map.put("prenom", "test_prenom");
		map.put("adresse", "test_adresse");
		map.put("telephone_pro", "0011223344");
		map.put("telephone_perso", "0011223344");
		map.put("email", "test_email@bob.fr");
		map.put("fax_pro", "0011223344");
		map.put("id_titre", "0");
		map.put("id_service", "0");
		
		// La methode getHashMap est private, on passe donc par la reflection
		Method method = e.getClass().getDeclaredMethod("getHashMap");
		method.setAccessible(true);
		HashMap<String, String> mapToCompare = 
				(HashMap<String, String>) method.invoke(e);
		
		assertEquals(mapToCompare.toString(), map.toString());
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
