package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.SQLManager;
import business.enqueteur.EnqueteurDB;

public class DBSelectTest {

	@Test
	public void selectAllEnqueteurTest() throws SQLException {
		
		SQLManager connect = SQLManager.getConnection();
		
		ResultSet rs = connect.select(EnqueteurDB.TABLE_NAME, SQLManager.NO_WHERE);
		assertNotNull(rs);
		rs.last();
		assertThat(rs.getRow(), is(not(0)));
		//assertNotEquals(rs.getRow(), 0);
	}
	
	@Test
	public void selectOneEnqueteurTest() throws SQLException {
		
		SQLManager connect = SQLManager.getConnection();
		
		ResultSet rs = connect.select(EnqueteurDB.TABLE_NAME, "nom='test_nom'");
		assertNotNull(rs);
		rs.last();
		assertThat(rs.getRow(), is(1));
		//assertEquals(rs.getRow(), 1);
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
