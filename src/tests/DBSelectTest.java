package tests;

import static org.junit.Assert.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.SQLManager;
import business.EnqueteurDB;

public class DBSelectTest {

	@Test
	public void selectAllEnqueteurTest() throws SQLException {
		
		SQLManager connect = SQLManager.getConnection();
		
		//ResultSet rs = connect.select(EnqueteurDB.table, SQLManager.ALL, SQLManage.NO_WHERE);
		ResultSet rs = connect.querySelect("SELECT * FROM enqueteur");
		assertNotNull(rs);
		rs.last();
		assertNotEquals(rs.getRow(), 0);
	}
	
	@Test
	public void selectOneEnqueteurTest() throws SQLException {
		
		SQLManager connect = SQLManager.getConnection();
		
		//ResultSet rs = connect.select(EnqueteurDB.table, SQLManager.ALL, "nom='test_nom'");
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
