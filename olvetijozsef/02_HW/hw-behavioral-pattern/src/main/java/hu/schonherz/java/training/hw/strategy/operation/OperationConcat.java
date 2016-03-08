package hu.schonherz.java.training.hw.strategy.operation;

import hu.schonherz.java.training.hw.strategy.Strategy;

/**
 * Implements the String concatenate operation.
 * 
 * @author Ölveti József
 *
 */
public class OperationConcat implements Strategy {

	@Override
	public String doOperation(String str1, String str2) {
		return str1.concat(str2);
	}

}
