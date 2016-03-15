package addProduct;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ToyTest {

	
	ToyFactory toyFactory = new ToyFactory();
	
	@Test
	public void getDollTest() {
		Toy toy = toyFactory.getToy("doll");
		assertEquals(new Doll().getName(), toy.getName());
	}
	
	
	@Test
	public void getCarTest() {
		Toy toy = toyFactory.getToy("car");
		assertEquals(new Car().getName(), toy.getName());
	}
}
