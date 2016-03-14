package hu.schonherz.java.training.hw2.structuralpattern;

import org.junit.Test;

import mockit.Mocked;
import mockit.Verifications;

public class ProxyTest {

	@Test
	public void testConctructorCall(@Mocked Bed anyBed){
		new BedProxy().layDownAndSleep();
//		new BedProxy();
		
		new Verifications() {
			{new Bed();}
		};
	}
	

}
