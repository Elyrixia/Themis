package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { DBInsertTest.class, DBSelectTest.class, DBUpdateTest.class, DBDeleteTest.class })
public class DBTestSuite {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("DB Test Suite - START");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("DB Test Suite - END");
	}
	
}
