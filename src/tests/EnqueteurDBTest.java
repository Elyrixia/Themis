package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.Enqueteur;
import business.EnqueteurDB;

public class EnqueteurDBTest {
	
	protected Enqueteur e;
	
	
	@Before
	public void setUp() throws Exception {
		e = new EnqueteurDB();
	}

	@After
	public void tearDown() throws Exception {
		e = null;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
