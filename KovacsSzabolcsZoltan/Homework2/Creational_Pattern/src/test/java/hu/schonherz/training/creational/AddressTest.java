package hu.schonherz.training.creational;

import org.junit.*;
import static org.junit.Assert.*;


public class AddressTest {

	//Testing that the file is exist or not
	@BeforeClass
	public static void onceExecutedBeforeAll() {
		assertTrue("The file isn't exists!", TestBuilderPattern.fileExisting);
	}
	//Testing our privileges 
	@Before
	public void executedBeforeEach() {
		assertTrue("Don't have permisson to read the file", TestBuilderPattern.fileCanRead);
	}

//	@AfterClass
//	public static void onceExecutedAfterAll() {
//		
//	}
//
//	@After
//	public void executedAfterEach() {
//		
//	}
	//Testing that the builder working correct or not
	@Test
	public void testTest() {
		String a = new Address.AddressBuilder().houseNumber("HNO-22/34")
		         .floorNumber("First Floor").street("123 ABC Street")
		         .city("Some City").province("Some Province")
		         .country("Some Country").zip("12345676")
		         .landmark("Near XYZ beach").build();
		
		assertEquals("Bad address builder",TestBuilderPattern.a, a.toString());
	}
}