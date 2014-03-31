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

import business.affaire.Affaire;
import business.affaire.AffaireDB;
import business.affaire.Frais;
import business.affaire.FraisDB;

public class FraisDBTest {
	
	private Frais f;

	@Before
	public void setUp() throws Exception {
		
		f = new FraisDB();
		f.setId(9999);
		
		Affaire a = mock(AffaireDB.class);
		f.setLibelle("test_libelle");
		f.setIdAffaire(a);
		f.setPrix(0);
	}
	
	@Test
	public void equalsTest() throws Exception {
		
		Frais fr = new FraisDB();
		fr.setId(9999);
		
		assertEquals(f.equals(fr), true);
		
		fr.setId(9998);
		
		assertEquals(f.equals(fr), false);
	}
	
	@Test
	public void toStringTest() {
		
		String message = "Frais #9999 - test_libelle";
		
		String messageToCompare = f.toString();
		
		assertEquals(messageToCompare, message);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getHashMapTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("libelle", "test_libelle");
		map.put("id_affaire", "0");
		map.put("prix", "0");
		
		// La methode getHashMap est private, on passe donc par la reflection
		Method method = f.getClass().getDeclaredMethod("getHashMap");
		method.setAccessible(true);
		HashMap<String, String> mapToCompare = 
				(HashMap<String, String>) method.invoke(f);
		
		assertEquals(mapToCompare.toString(), map.toString());
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("FraisDB Test - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("FraisDB Test - END");
	}
}
