/**
 * @author Alexandre Laffaille
 */

package tests;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.enqueteur.TitreEnqueteur;
import business.enqueteur.TitreEnqueteurDB;

public class TitreEnqueteurDBTest {
	
	private TitreEnqueteur te;

	@Before
	public void setUp() throws Exception {
		
		te = new TitreEnqueteurDB();
		te.setId(9999);
		
		te.setLibelle("test_libelle");
	}
	
	@Test
	public void equalsTest() throws Exception {
		
		TitreEnqueteur ten = new TitreEnqueteurDB();
		ten.setId(9999);
		
		assertEquals(te.equals(ten), true);
		
		ten.setId(9998);
		
		assertEquals(te.equals(ten), false);
	}
	
	@Test
	public void toStringTest() {
		
		String message = "Titre #9999 - test_libelle";
		
		String messageToCompare = te.toString();
		
		assertEquals(messageToCompare, message);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getHashMapTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("libelle", "test_libelle");
		
		// La methode getHashMap est private, on passe donc par la reflection
		Method method = te.getClass().getDeclaredMethod("getHashMap");
		method.setAccessible(true);
		HashMap<String, String> mapToCompare = 
				(HashMap<String, String>) method.invoke(te);
		
		assertEquals(mapToCompare.toString(), map.toString());
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("TitreEnqueteurDB Test - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("TitreEnqueteurDB Test - END");
	}
}
