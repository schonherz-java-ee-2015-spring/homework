package hu.schonherz.java.training.hw.strategy;

import hu.schonherz.java.training.hw.strategy.operation.OperationConcat;
import hu.schonherz.java.training.hw.strategy.operation.OperationGetLonger;
import hu.schonherz.java.training.hw.strategy.operation.OperationMix;

/**
 * The Application.
 * 
 * @author Ölveti József
 *
 */
public class Main {

	public static void main(String[] args) {
		Context context = new Context(new OperationConcat());
		System.out.println(context.executeStrategy("000", "xxxx"));

		context = new Context(new OperationMix());
		System.out.println(context.executeStrategy("xx", "12345678"));

		context = new Context(new OperationGetLonger());
		System.out.println(context.executeStrategy("xxx", "xx00"));
	}

}
