package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.SQLManager;
import business.EnqueteurDB;

public class DBInsertTest {
	
	private int sizeBeforeInsert;
	
	@Before
	public void setUp() throws Exception {
		
		SQLManager connect = SQLManager.getConnection();
		
		ResultSet rs = connect.select(EnqueteurDB.TABLE_NAME, SQLManager.NO_WHERE);
		assertNotNull(rs);
		
		rs.last();
		this.sizeBeforeInsert = rs.getRow();
	}
	
	@Test
	public void insertEnqueteurTest() throws SQLException {
		
		SQLManager connect = SQLManager.getConnection();
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("id_titre", String.valueOf(9999));
		map.put("id_service", String.valueOf(9999));
		map.put("nom", "test_nom");
		map.put("prenom", "test_prenom");
		map.put("adresse", "test_adresse");
		map.put("telephone_pro", "0011223344");
		map.put("email", "test_email");
		map.put("fax_pro", "0011223344");
		map.put("telephone_perso", "0011223344");
		
		connect.insert(EnqueteurDB.TABLE_NAME, map);
		
		ResultSet rs = connect.select(EnqueteurDB.TABLE_NAME, SQLManager.NO_WHERE);
		assertNotNull(rs);
		
		rs.last();
		assertThat(this.sizeBeforeInsert + 1, is(rs.getRow()));
		//assertEquals(this.sizeBeforeInsert + 1, rs.getRow());
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
