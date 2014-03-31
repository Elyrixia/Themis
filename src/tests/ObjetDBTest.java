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

import business.affaire.Objet;
import business.affaire.ObjetDB;
import business.affaire.Scelle;
import business.affaire.ScelleDB;
import business.affaire.TypeObjet;
import business.affaire.TypeObjetDB;

public class ObjetDBTest {
	
	private Objet o;

	@Before
	public void setUp() throws Exception {
		
		o = new ObjetDB();
		o.setId(9999);
		
		Scelle s = mock(ScelleDB.class);
		TypeObjet t = mock(TypeObjetDB.class);
		Objet ob = mock(ObjetDB.class);
		o.setLibelle("test_libelle");
		o.setComment("test_comment");
		o.setIdScelle(s);
		o.setIdType(t);
		o.setIdObjet(ob);
	}
	
	@Test
	public void equalsTest() throws Exception {
		
		Objet ob = new ObjetDB();
		ob.setId(9999);
		
		assertEquals(o.equals(ob), true);
		
		ob.setId(9998);
		
		assertEquals(o.equals(ob), false);
	}
	
	@Test
	public void toStringTest() {
		
		String message = "Objet #9999 - test_libelle";
		
		String messageToCompare = o.toString();
		
		assertEquals(messageToCompare, message);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getHashMapTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("libelle", "test_libelle");
		map.put("comment", "test_comment");
		map.put("id_scelle", "0");
		map.put("id_type", "0");
		map.put("id_objet", "0");
		
		// La methode getHashMap est private, on passe donc par la reflection
		Method method = o.getClass().getDeclaredMethod("getHashMap");
		method.setAccessible(true);
		HashMap<String, String> mapToCompare = 
				(HashMap<String, String>) method.invoke(o);
		
		assertEquals(mapToCompare.toString(), map.toString());
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("ObjetDB Test - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("ObjetDB Test - END");
	}
}
