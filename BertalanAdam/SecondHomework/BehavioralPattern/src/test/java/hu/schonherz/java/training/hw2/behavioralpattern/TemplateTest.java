package hu.schonherz.java.training.hw2.behavioralpattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TemplateTest {

	@Test
	public void testAppropriateMethods(){
		// Test that every method in the template method called only once, and all of them are called!
		HaveLasagne mock = mock(HaveLasagne.class);
		mock.haveDinner();
		
		verify(mock, times(1)).gatherIngredients();
		verify(mock, times(1)).cookMeal();
		verify(mock, times(1)).eat();
		verify(mock, times(1)).washUp();
	}

}
