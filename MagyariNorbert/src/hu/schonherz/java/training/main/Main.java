package hu.schonherz.java.training.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import hu.schonherz.java.training.firereader.DeveloperReader;
import hu.schonherz.java.training.firereader.EmployeeReader;
import hu.schonherz.java.training.pojo.Developer;
import hu.schonherz.java.training.pojo.Employee;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.thread.ReaderThread;
import hu.schonherz.java.training.thread.SynchronizationTest;

public class Main {

	/*
	 * COURSE AGENDA
	 * 
	 * Friday - IO, Thread, Exceptions 0) Create branch 1) I/O a) Read employee
	 * from file b) Read developers from file c) Read from developers.txt d)
	 * Write to developers.dat e) Read from developers.dat 2) Threading a)
	 * Create thread to read up employee and developers (ReaderThread) b) Play
	 * with synchronized 3) Exceptions
	 * 
	 * Saturday - Annotation, Interfaces, Abstract Classes, Inheritance,
	 * Polimorfism, Generics 1) Annotations 2) Create server a) Windows server
	 * b) Linux server c) Windows Database server d) Linux Web server e) Linux
	 * Database and Web server 3) Create Database and Web interface a) With
	 * default getStatus 4) Generics 5) Homework
	 */
	public static void main(String[] args) {

		// test(); //kiskacsa

		// java.util.List<Employee> employees = EmployeeReader.read();
		// for (Employee employee : employees) {
		// System.out.println(employee.getName() + " " +
		// employee.getEmployeeID());
		// }
		java.util.List<Developer> developers = DeveloperReader.readFromTextFile();
		// for (Developer developer : developers) {
		// System.out.println(developer.getName() + " " +
		// developer.getEmployeeID() + " " + developer.getTasks());
		// }
		DeveloperReader.writeToBinaryFile(developers);

		List<Developer> dev = DeveloperReader.readFromBinaryFile();

		// for (Developer developer : dev) {
		// System.out.println(
		// "bináris " + developer.getName() + " " + developer.getEmployeeID() +
		// " " + developer.getTasks());
		// }

		dev.forEach(d -> {
			System.out.println(d.getName() + " " + d.getEmployeeID());
			d.getTasks().forEach(t -> {
				System.out.println(t);
			});
		});

		// threading();
		// synchronyzeTest();

//		Server ws = new WindowsServer();
//		Server ls = new LinuxServer();

		// Map is a generic what has two type parameter
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "egy");
		map.put(2, "ketto");
		System.out.println(map.get(2));

		Number n = new Integer(0);
		List<? extends Number> numbers = new ArrayList<Integer>();
		List<? super Integer> ints = new ArrayList<Number>();
		
		List<Employee> e1 = new LinkedList <>(); //két irányban láncolt lista
		List<Employee> e2 = new ArrayList<>(); //
		
		
		

	}

	public void lambda(Developer d) {
		System.out.println(d.getName() + "(" + d.getEmployeeID() + ")");
		d.getTasks().forEach(t -> {
			System.out.println(t);
		});
	}

	public static void synchronyzeTest() {
		SynchronizationTest st1 = new SynchronizationTest(1);
		SynchronizationTest st2 = new SynchronizationTest(2);

		st1.start();
		st2.start();
	}

	private static void threading() {
		ReaderThread readerThread = new ReaderThread();
		readerThread.start(); // itt egy külön szál indul
		test();
	}

	private static void test() {
		System.out.println("kis kacsa");
	}

	/*
	 * As a manager of the organization (fontos, hogy kinek lesz a fejlesztés, nem mindegy hogy egy mezei júzernek),
	 * I want a real-time(folyamatosan, míg a program fut)
	 * report for those servers,
	 * which are not running. The report should tell that which system
	 * administrators have right for those servers.
	 * 
	 * real-time report: continuously while the program is running (every 10 sec)
	 * report: write out on console. Format: serverName (what is not running) and the list of administrators name.
	 * servers: server.txt contains them:
	 * 	1) ID of the server
	 * 	2) Name of the server
	 * 	3) type
	 *  4) status of server
	 * 
	 * TEST: If the servers.txt has been changed then it will be presented by the report.
	 * 
	 * 
	 */
	private static void homework() {
		// TODO unimplemented method
		throw new UnsupportedOperationException("Not implemented yet.");
	}

@SuppressWarnings("unused")
public class Main {

  /*
   * COURSE AGENDA
   * 
   * Friday - IO, Thread, Exceptions
   * 0) Create branch
   * 1) I/O
   *    a) Read employee from file
   *    b) Read from developers.txt
   *    c) Write to developers.dat
   *    d) Read from developers.dat
   * 2) Threading 
   *    a) Create thread to read up employee (ReaderThread)
   *    b) Play with synchronized
   * 3) Exceptions
   * 
   * Saturday - Annotation, Interfaces, Abstract Classes, Inheritance, Polimorfism, Generics
   * 1) Annotations
   * 2) Create server
   *    a) Windows server
   *    b) Linux server
   *    c) Windows Database server
   *    d) Linux Web server
   *    e) Linux Database and Web server
   * 3) Create Database and Web interface
   *    a) With default getStatus
   * 4) Generics
   * 5) Homework
   */
  public static void main(String[] args) {
    /*Status status = Status.RUNNING;
    System.out.println(status.name());
    System.out.println(status.toString());
    Developer dev = new Developer();
    System.out.println(dev.toString());
    */
    /*synchroniedTest();
    Server ws = new WindowsServer();*/
    /*
    // Map is a generic what has two type parameter
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "egy");
    map.put(2, "ketto");
    System.out.println(map.get(2));
    
    Number n = new Integer(0);
    List<? extends Number> numbers = new ArrayList<Integer>();
    List<? super Integer> ints = new ArrayList<Number>();
    */
    
    List<Developer> dev = DeveloperReader.readFromBinaryFile();
    for (Developer developer : dev) {
      System.out.println(developer.getName() + " (" + developer.getEmployeeID() + ")");
      for (String s : developer.getTasks()) {
        System.out.println(s);
      }
    }
    System.out.println("------------------------------");
    
    // Lamda expression
    List<Developer> devs = DeveloperReader.readFromTextFile();
    devs.forEach(d -> {
      System.out.println(d.getName() + "(" + d.getEmployeeID() + ")");
      d.getTasks().forEach(t -> {
        System.out.println(t);
      });
    });
    //devs.forEach(System.out::println);
    
    List<Employee> e1 = new LinkedList<Employee>();
    List<Employee> e2 = new ArrayList<Employee>();
    
  }
  
  // what happen inside of the forEach - Each dev will be the parameter of this method
  public void lamda(Developer d) {
    System.out.println(d.getName() + "(" + d.getEmployeeID() + ")");
    d.getTasks().forEach(t -> {
      System.out.println(t);
    });
  }
  
  private static void test() {
    System.out.println("kis kacsa");
  }
  
  private static void ioHandling() {
    List<Employee> employees = EmployeeReader.read();
    for (Employee employee : employees) {
      System.out.println(employee.getName() + " - " + employee.getEmployeeID());
    }
    
    List<Developer> developers = DeveloperReader.readFromTextFile();
    for (Developer developer : developers) {
      System.out.println(developer.getName() + " (" + developer.getEmployeeID() + ")");
      for (String s : developer.getTasks()) {
        System.out.println(s);
      }
    }
    DeveloperReader.writeToBinaryFile(developers);
    
    System.out.println("---------------------------------------------");
    
    List<Developer> dev = DeveloperReader.readFromBinaryFile();
    for (Developer developer : dev) {
      System.out.println(developer.getName() + " (" + developer.getEmployeeID() + ")");
      for (String s : developer.getTasks()) {
        System.out.println(s);
      }
    }
  }
  
  private static void threading() {
    ReaderThread readerThread = new ReaderThread();
    //System.out.println(readerThread.getState());
    readerThread.start();
    /*try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }*/
    System.out.println(readerThread.getState());
    try {
      readerThread.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    test();
  }
  
  public static void synchroniedTest() {
    SynchronizationTest st1 = new SynchronizationTest(1);
    SynchronizationTest st2 = new SynchronizationTest(2);
    
    st1.start();
    st2.start();
  }
  
  /*
   * As a manager of the organization, I want a real-time report for those servers, which are not running.
   * The report should tell that which system administrators have right for those servers.
   * 
   *  -----------------------------
   *  real-time report: continuously while the program is running (every 10 sec)
   *  report: Write out on console. Format: serverName (what is not running) and the list of administrators' name
   *  servers: servers.txt contains them: 
   *    1) ID of server
   *    2) Name of server
   *    3) type
   *    4) status of server (RUNNING, STOPPED)
   *  system administrators: sysadmins.txt
   *    1) Name
   *    2) EmployeeID
   *    3 (rest): Id of servers for he/she has right.
   *  
   *  NOTE: Should be in separate project or you can write the code here, as you prefer
   *        If you finished it, please put the project folder into homework repository under your subfolder (your name)
   *        !!!And Push it!!!
   *        deadline: marc. 4. 14:00
   *  TEST: If the servers.txt has been changed then it will be presented by the report
   */
  private static void homework() {
    // TODO unimplemented method
    throw new UnsupportedOperationException("Not implemented yet.");
  }

}}
