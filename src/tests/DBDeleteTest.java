package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.SQLManager;

public class DBDeleteTest {
	
	private int sizeBeforeDelete;

	@Before
	public void setUp() throws Exception {
		
		SQLManager connect = SQLManager.getConnection();
		
		ResultSet rs = connect.querySelect("SELECT * FROM enqueteur");
		assertNotNull(rs);
		rs.last();
		this.sizeBeforeDelete = rs.getRow();
	}

	@Test
	public void deleteEnqueteurTest() throws SQLException {
		
		SQLManager connect = SQLManager.getConnection();
		
		// Run the query
		connect.query("DELETE FROM enqueteur WHERE nom='test_nom'");
		
		ResultSet rs = connect.querySelect("SELECT * FROM enqueteur");
		assertNotNull(rs);
		
		rs.last();
		assertEquals(this.sizeBeforeDelete - 1, rs.getRow());
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("DB Delete Test - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("DB Delete Test - END");
	}

}
