package hu.schonherz.hello;

import java.util.ArrayList;

public class Hello {

	private static final String ASDHELLO_WORLD = "ASDHELLOWorld";
	String line;
	String line2;
	public Hello(String line, String line2) {
		super();
		this.line = line;
		this.line2 = line2;
	}
// ArrayList<E>List lista;
	public static void main(String[] args) {
		extracted();
	}
	private static void extracted() {
		System.out.println(ASDHELLO_WORLD);
		System.out.println(ASDHELLO_WORLD);
	}

	/**
	 * @return the line
	 */
	public String getLine() {
		return line;
	}

	/**
	 * @param line
	 *            the line to set
	 */
	public void setLine(String line) {
		this.line = line;
	}

	/**
	 * @return the line2
	 */
	public String getLine2() {
		return line2;
	}

	/**
	 * @param line2
	 *            the line2 to set
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}
}
