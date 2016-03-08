package hu.schonherz.java.training.hw.bridge;

import hu.schonherz.java.training.hw.bridge.machine.CoffeeMaker;
import hu.schonherz.java.training.hw.bridge.machine.Hairdryer;
import hu.schonherz.java.training.hw.bridge.machine.Television;

/**
 * The Application.
 * 
 * @author Ölveti József
 *
 */
public class Main {

	public static void main(String[] args) {
		Switch tv = new RemoteControl(new Television());
		Switch dryer = new RemoteControl(new Hairdryer());
		Switch maker = new RemoteControl(new CoffeeMaker());

		System.out.println(tv.switchOn());
		System.out.println(tv.switchOff());
		System.out.println(dryer.switchOn());
		System.out.println(dryer.switchOff());
		System.out.println(maker.switchOn());
		System.out.println(maker.switchOff());
	}
}
