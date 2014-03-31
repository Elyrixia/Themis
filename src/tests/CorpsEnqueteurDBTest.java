package tests;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.enqueteur.CorpsEnqueteur;
import business.enqueteur.CorpsEnqueteurDB;

public class CorpsEnqueteurDBTest {
	
	private CorpsEnqueteur ce;

	@Before
	public void setUp() throws Exception {
		
		ce = new CorpsEnqueteurDB();
		ce.setId(9999);
		
		ce.setLibelle("test_libelle");
	}
	
	@Test
	public void equalsTest() throws Exception {
		
		CorpsEnqueteur cen = new CorpsEnqueteurDB();
		cen.setId(9999);
		
		assertEquals(ce.equals(cen), true);
		
		cen.setId(9998);
		
		assertEquals(ce.equals(cen), false);
	}
	
	@Test
	public void toStringTest() {
		
		String message = "CorpsEnqueteur #9999 - test_libelle";
		
		String messageToCompare = ce.toString();
		
		assertEquals(messageToCompare, message);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getHashMapTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("libelle", "test_libelle");
		
		// La methode getHashMap est private, on passe donc par la reflection
		Method method = ce.getClass().getDeclaredMethod("getHashMap");
		method.setAccessible(true);
		HashMap<String, String> mapToCompare = 
				(HashMap<String, String>) method.invoke(ce);
		
		assertEquals(mapToCompare.toString(), map.toString());
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("CorpsEnqueteurDB Test - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("CorpsEnqueteurDB Test - END");
	}
}
