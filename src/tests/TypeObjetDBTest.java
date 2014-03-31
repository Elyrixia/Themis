package tests;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.affaire.TypeObjet;
import business.affaire.TypeObjetDB;

public class TypeObjetDBTest {
	
	private TypeObjet t;

	@Before
	public void setUp() throws Exception {
		
		t = new TypeObjetDB();
		t.setId(9999);
		
		t.setLibelle("test_libelle");
	}
	
	@Test
	public void equalsTest() throws Exception {
		
		TypeObjet to = new TypeObjetDB();
		to.setId(9999);
		
		assertEquals(t.equals(to), true);
		
		to.setId(9998);
		
		assertEquals(t.equals(to), false);
	}
	
	@Test
	public void toStringTest() {
		
		String message = "TypeObjet #9999 - test_libelle";
		
		String messageToCompare = t.toString();
		
		assertEquals(messageToCompare, message);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getHashMapTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("libelle", "test_libelle");
		
		// La methode getHashMap est private, on passe donc par la reflection
		Method method = t.getClass().getDeclaredMethod("getHashMap");
		method.setAccessible(true);
		HashMap<String, String> mapToCompare = 
				(HashMap<String, String>) method.invoke(t);
		
		assertEquals(mapToCompare.toString(), map.toString());
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("TypeObjetDB Test - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("TypeObjetDB Test - END");
	}
}
