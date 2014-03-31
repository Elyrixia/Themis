/**
 * @author Benoit Ruiz
 */

package tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.affaire.Affaire;
import business.affaire.AffaireDB;
import business.affaire.Scelle;
import business.affaire.ScelleDB;

public class ScelleDBTest {
	
	private Scelle s;

	@Before
	public void setUp() throws Exception {
		
		s = new ScelleDB();
		s.setId(9999);
		
		Scelle sc = mock(ScelleDB.class);
		Affaire a = mock(AffaireDB.class);
		s.setNumProces(123);
		s.setDateRecup(new Date(0));
		s.setLieuRecup("test_lieu");
		s.setComment("test_comment");
		s.setIdAffaire(a);
		s.setIdScelle(sc);
	}
	
	@Test
	public void equalsTest() throws Exception {
		
		Scelle sc = new ScelleDB();
		sc.setId(9999);
		
		assertEquals(s.equals(sc), true);
		
		sc.setId(9998);
		
		assertEquals(s.equals(sc), false);
	}
	
	@Test
	public void toStringTest() {
		
		String message = "Scelle #9999 - test_comment";
		
		String messageToCompare = s.toString();
		
		assertEquals(messageToCompare, message);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getHashMapTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("num_proces", "123");
		DateFormat db = new SimpleDateFormat("yyyy-MM-dd");
		map.put("date_recup", db.format(new Date(0)));
		map.put("lieu_recup", "test_lieu");
		map.put("comment", "test_comment");
		map.put("id_affaire", "0");
		map.put("id_scelle", "0");
		
		// La methode getHashMap est private, on passe donc par la reflection
		Method method = s.getClass().getDeclaredMethod("getHashMap");
		method.setAccessible(true);
		HashMap<String, String> mapToCompare = 
				(HashMap<String, String>) method.invoke(s);
		
		assertEquals(mapToCompare.toString(), map.toString());
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("ScelleDB Test - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("ScelleDB Test - END");
	}
}
