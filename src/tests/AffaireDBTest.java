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
import business.enqueteur.Enqueteur;
import business.enqueteur.EnqueteurDB;

public class AffaireDBTest {
	
	private Affaire a;

	@Before
	public void setUp() throws Exception {
		
		a = new AffaireDB();
		a.setId(9999);
		
		Enqueteur e = mock(EnqueteurDB.class);
		a.setNom("test_nom");
		a.setNumDossier(123);
		a.setNumInstruction(12);
		a.setNumParquet(42);
		a.setDateOrdre(new Date(0));
		a.setDateRendu(new Date(0));
		a.setDelai(false);
		a.setComment("test_comment");
		a.setEnqueteur(e);
	}
	
	@Test
	public void equalsTest() throws Exception {
		
		Affaire aff = new AffaireDB();
		aff.setId(9999);
		
		assertEquals(a.equals(aff), true);
		
		aff.setId(9998);
		
		assertEquals(a.equals(aff), false);
	}
	
	@Test
	public void toStringTest() {
		
		String message = "Affaire #9999 - test_nom";
		
		String messageToCompare = a.toString();
		
		assertEquals(messageToCompare, message);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getHashMapTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("nom", "test_nom");
		map.put("num_dossier", "123");
		map.put("num_instruction", "12");
		map.put("num_parquet", "42");
		
		DateFormat db = new SimpleDateFormat("yyyy-MM-dd");
		map.put("date_ordre", db.format(new Date(0)));
		map.put("date_rendu", db.format(new Date(0)));
		map.put("delai", "0");
		map.put("comment", "test_comment");
		map.put("id_enqueteur", "0");
		
		// La methode getHashMap est private, on passe donc par la reflection
		Method method = a.getClass().getDeclaredMethod("getHashMap");
		method.setAccessible(true);
		HashMap<String, String> mapToCompare = 
				(HashMap<String, String>) method.invoke(a);
		
		assertEquals(mapToCompare.toString(), map.toString());
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("AffaireDB Test - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("AffareDB Test - END");
	}
}
