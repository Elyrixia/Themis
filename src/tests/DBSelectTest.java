package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.SQLManager;

public class DBSelectTest {

	@Test
	public void selectAllEnqueteurTest() throws SQLException {
		
		SQLManager connect = SQLManager.getConnection();
		
		ResultSet rs = connect.querySelect("SELECT * FROM enqueteur");
		assertNotNull(rs);
		rs.last();
		assertNotEquals(rs.getRow(), 0);
	}
	
	@Test
	public void selectOneEnqueteurTest() throws SQLException {
		
		SQLManager connect = SQLManager.getConnection();
		
		ResultSet rs = connect.querySelect("SELECT * FROM enqueteur WHERE nom='test_nom'");
		assertNotNull(rs);
		rs.last();
		assertEquals(rs.getRow(), 1);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("DB Select Test - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("DB Select Test - END");
	}

}
