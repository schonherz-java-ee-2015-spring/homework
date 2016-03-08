package hu.schonherz.java.training.hw.strategy.operation;

import hu.schonherz.java.training.hw.strategy.Strategy;

/**
 * Implements the String getlonger operation.
 * 
 * @author Ölveti József
 *
 */
public class OperationGetLonger implements Strategy {

	@Override
	public String doOperation(String str1, String str2) {
		if (str1.length() > str2.length()) {
			return str1;
		} else if (str2.length() > str1.length()) {
			return str2;
		}
		return "Same Length";
	}

}
