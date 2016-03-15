package hu.schonherz.homework.headswitcher.designpatterns.nullobjectpattern;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RealCustomerTest {

	String nev = "Test";
	RealCustomer rc = new RealCustomer(nev);
	
	@Test
	public void isItEqual(){
		assertEquals(nev, rc.getName());
	}
}
