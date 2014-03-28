package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.SQLManager;
import business.enqueteur.EnqueteurDB;

public class DBUpdateTest {
	
	private String valueBeforeUpdate;
	
	@Before
	public void setUp() throws Exception {
		
		SQLManager connect = SQLManager.getConnection();
		ArrayList<String> fields = new ArrayList<String>();
		fields.add("prenom");
		
		ResultSet rs = connect.select(EnqueteurDB.TABLE_NAME, fields, "nom='test_nom'");
		assertNotNull(rs);
		rs.first();
		
		valueBeforeUpdate = rs.getString("prenom");
	}

	@Test
	public void updateEnqueteurTest() throws SQLException {
		
		SQLManager connect = SQLManager.getConnection();
		HashMap<String, String> map = new HashMap<String, String>();
		ArrayList<String> fields = new ArrayList<String>();
		
		map.put("prenom", "test_nouveau_prenom");
		
		fields.add("prenom");
		
		connect.update(EnqueteurDB.TABLE_NAME, map, "nom='test_nom'");
		
		ResultSet rs = connect.select(EnqueteurDB.TABLE_NAME, fields, "nom='test_nom'");
		assertNotNull(rs);
		rs.first();
		
		assertThat(valueBeforeUpdate, is(not(rs.getString("prenom"))));
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("DB Update Test - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("DB Update Test - END");
	}

}
