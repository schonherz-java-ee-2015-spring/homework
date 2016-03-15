package hu.schonherz.java.training.hw.strategy.operation;

import hu.schonherz.java.training.hw.strategy.Strategy;

/**
 * Implements the String mix operation. Mix two strings literatim.
 * 
 * @author Ölveti József
 *
 */
public class OperationMix implements Strategy {

	@Override
	public String doOperation(String str1, String str2) {
		StringBuilder builder = new StringBuilder();
		int i;
		for (i = 0; i < str1.length(); i++) {
			builder.append(str1.charAt(i));
			try {
				builder.append(str2.charAt(i));
			} catch (IndexOutOfBoundsException e) {
				builder.append(str1.subSequence(i + 1, str1.length()));
				break;
			}
		}
		builder.append(str2.subSequence(i, str2.length()));
		return builder.toString();
	}

}
