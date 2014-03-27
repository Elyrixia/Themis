package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.SQLManager;

public class DBUpdateTest {

	@Before
	public void setUp() throws Exception {
		
		SQLManager connect = SQLManager.getConnection();
		
		ResultSet rs = connect.querySelect("SELECT * FROM enqueteur");
		assertNotNull(rs);
	}

	@Test
	public void updateEnqueteurTest() {
		fail("Not yet implemented");
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
