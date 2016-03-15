package hu.schonherz.training.behavioral;

import org.junit.*;
import static org.junit.Assert.*;

public class StateTest {
	
	TVContext context = new TVContext();
	
//	@BeforeClass
//	public void stateState() {
//		
//	}
	//Testing the TV start status
	@Test
	public void startStatTest() {
		context.setState(new TVStartState());
		assertEquals("The TV isn't turned on", context.doAction(), "TV is turned ON");
	}
	//Testing the TV stop status
	@Test
	public void stopStatTest() {
		context.setState(new TVStopState());
		assertEquals("The TV isn't turned off", context.doAction(), "TV is turned OFF");
	}
	
	
	
}
