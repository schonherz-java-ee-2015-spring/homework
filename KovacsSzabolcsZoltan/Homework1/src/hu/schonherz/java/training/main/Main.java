package hu.schonherz.java.training.main;

import java.util.List;

import hu.schonherz.java.training.firereader.DeveloperReader;
import hu.schonherz.java.training.firereader.EmployeeReader;
import hu.schonherz.java.training.pojo.Developer;
import hu.schonherz.java.training.pojo.Employee;
import hu.schonherz.java.training.thread.ReaderThread;
import hu.schonherz.java.training.thread.ServerAndAdminReaderThread;
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

		// Server ws = new WindowsServer();
		// Server ls = new LinuxServer();

		// Map<Integer, String> map = new HashMap<>();
		// map.put(1, "egy");
		// map.put(2, "kettő");
		// System.out.println(map.get(2));
		//
		// Number n = new Integer(0);
		// List<? extends Number> numbers = new ArrayList<Integer>();
		// List<? super Integer> ints = new ArrayList<Number>();

		// iohandling();
		// test();
		// threading();
		homework();
	}

	private static void test() {
		System.out.println("kitsi katsa");
	}

	@SuppressWarnings("unused")
	private static void iohandling() {
		List<Employee> employees = EmployeeReader.read();
		for (Employee employee : employees) {
			System.out.println(employee.getName() + " - " + employee.getEmployeeID());
		}
		List<Developer> developers = DeveloperReader.readFromTextFile();

		System.out.println("-----------------------------------");
		developers.forEach(d -> {
			System.out.println(d.getName() + "(" + d.getEmployeeID() + ")");
			d.getTasks().forEach(t -> {
				System.out.print(t + " ");
			});
			System.out.println();
		});

		// for (Developer developer : developers) {
		// System.out.println(developer.getName() + " - " +
		// developer.getEmployeeID() + " - " + developer.getTasks());
		// }
		DeveloperReader.writeToBinaryFile(developers);

		List<Developer> dev = DeveloperReader.readFromBinaryFile();
		for (Developer developer : dev) {
			System.out.println(developer.getName() + " - " + developer.getEmployeeID());
		}
	}

	public void lamda(Developer d) {
		System.out.println(d.getName() + " - " + d.getEmployeeID());
		d.getTasks().forEach(t -> {
			System.out.print(t + " ");
		});
	}

	public static void threading() {
		ReaderThread readerThread = new ReaderThread();
		System.out.println(readerThread.getState());
		readerThread.start();
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
	 * As a manager of the organization, I want a real-time report for those
	 * servers, which are not running. The report should tell that which system
	 * administrators have right for those servers.
	 * ------------------------------------------- 
	 * real-time report: continuously while the program is running (every 10 sec) 
	 * report: write out on the console. Format: serverName (what is not running) and the list of administrators' name 
	 * servers: servers.txt contains them: 
	 * 	1) ID of server 
	 * 	2) Name of server 
	 * 	3) Type 
	 * 	4) Status of server (RUNNING, STOPPED)
	 * system administrators: sysadmins.txt contains them: 
	 * 	1) Name 
	 * 	2) EmployeeID
	 * 	3) (rest): Id of servers for he/she has right.
	 * 
	 * NOTE:
	 * 
	 * TEST: If the servers.txt has been changed then it will be presented by
	 * the report
	 */
	private static void homework() {
		ServerAndAdminReaderThread serverAndDevReaderThread = new ServerAndAdminReaderThread();
		serverAndDevReaderThread.start();

		try {
			serverAndDevReaderThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
