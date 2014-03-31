/**
 * @author Nathan Marin
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

import business.enqueteur.CorpsEnqueteur;
import business.enqueteur.CorpsEnqueteurDB;
import business.enqueteur.ServiceEnqueteur;
import business.enqueteur.ServiceEnqueteurDB;

public class ServiceEnqueteurDBTest {
	
	private ServiceEnqueteur se;

	@Before
	public void setUp() throws Exception {
		
		se = new ServiceEnqueteurDB();
		se.setId(9999);
		
		CorpsEnqueteur c = mock(CorpsEnqueteurDB.class);
		se.setLibelle("test_libelle");
		se.setLieu("test_lieu");
		se.setTelephone("0011223344");
		se.setCorps(c);
	}
	
	@Test
	public void equalsTest() throws Exception {
		
		ServiceEnqueteur sen = new ServiceEnqueteurDB();
		sen.setId(9999);
		
		assertEquals(se.equals(sen), true);
		
		sen.setId(9998);
		
		assertEquals(se.equals(sen), false);
	}
	
	@Test
	public void toStringTest() {
		
		String message = "ServiceEnqueteur #9999 - test_libelle";
		
		String messageToCompare = se.toString();
		
		assertEquals(messageToCompare, message);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getHashMapTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("libelle", "test_libelle");
		map.put("telephone", "0011223344");
		map.put("lieu", "test_lieu");
		map.put("id_corps", "0");
		
		// La methode getHashMap est private, on passe donc par la reflection
		Method method = se.getClass().getDeclaredMethod("getHashMap");
		method.setAccessible(true);
		HashMap<String, String> mapToCompare = 
				(HashMap<String, String>) method.invoke(se);
		
		assertEquals(mapToCompare.toString(), map.toString());
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("ServiceEnqueteurDB Test - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("ServiceEnqueteurDB Test - END");
	}
}
