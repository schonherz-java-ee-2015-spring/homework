package org.DesignPatternTemplate;

/**
 * Hello world!
 *
 */
public class TemplatePatternDemo {
	   public static void main(String[] args) {

	      Manufacturing thing = new SmartPhone();
	      thing.produce();
	      System.out.println();
	      thing = new Car();
	      thing.produce();		
	   }
	}
