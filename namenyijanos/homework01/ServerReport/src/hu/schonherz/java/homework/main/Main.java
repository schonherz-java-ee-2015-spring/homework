/**
 * 
 */
package hu.schonherz.java.homework.main;

import hu.schonherz.java.homework.realTimeRead.RealTimeRead;

/**
 * @author namenyijanos
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		listStoppedServers();

	}
	
	private static void listStoppedServers() {
		RealTimeRead lister = new RealTimeRead();
		lister.start();
	}
}
