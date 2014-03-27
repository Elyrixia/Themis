package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.SQLManager;

public class DBInsertTest {
	
	private int sizeBeforeInsert;
	
	@Before
	public void setUp() throws Exception {
		
		SQLManager connect = SQLManager.getConnection();
		
		ResultSet rs = connect.querySelect("SELECT * FROM enqueteur");
		assertNotNull(rs);
		rs.last();
		this.sizeBeforeInsert = rs.getRow();
	}
	
	@Test
	public void insertEnqueteurTest() throws SQLException {
		
		SQLManager connect = SQLManager.getConnection();
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put(":titre", String.valueOf(42));
		map.put(":service", String.valueOf(42));
		map.put(":nom", "test_nom");
		map.put(":prenom", "test_prenom");
		map.put(":adresse", "test_adresse");
		map.put(":telephonePro", "0011223344");
		map.put(":email", "test_email");
		map.put(":faxPro", "0011223344");
		map.put(":telephonePerso", "0011223344");
		
		// Run the query
		connect.query("INSERT INTO enqueteur(id_titre, id_service, nom, prenom, adresse, telephone_pro, email, fax_pro, telephone_perso) "
				+ "VALUES(':titre', ':service', ':nom', ':prenom', ':adresse', ':telephonePro', 'email', 'faxPro', 'telephonePerso')", map);
		
		ResultSet rs = connect.querySelect("SELECT * FROM enqueteur");
		assertNotNull(rs);
		
		rs.last();
		assertEquals(this.sizeBeforeInsert + 1, rs.getRow());
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("DB Insert Test - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("DB Insert Test - END");
	}

}
