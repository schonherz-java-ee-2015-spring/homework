package hu.schonherz.java.training.hw1.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import hu.schonherz.java.training.hw1.employee.Sysadmin;
import hu.schonherz.java.training.hw1.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.hw1.server.LinuxDatabaseServer;
import hu.schonherz.java.training.hw1.server.LinuxServer;
import hu.schonherz.java.training.hw1.server.Server;
import hu.schonherz.java.training.hw1.server.Server.Status;
import hu.schonherz.java.training.hw1.server.Server.Type;
import hu.schonherz.java.training.hw1.server.WindowsDatabaseAndWebServer;
import hu.schonherz.java.training.hw1.server.WindowsDatabaseServer;
import hu.schonherz.java.training.hw1.server.WindowsServer;
import hu.schonherz.java.training.hw1.server.WindowsWebServer;

public class Main {

	private static final String SUBDIRECTORY = "files";
	private static final String SERVERS = "servers.txt";
	private static final String SYSADMINS = "sysadmins.txt";
	private static File serversfile = new File(SUBDIRECTORY + File.separator + SERVERS);
	private static File sysadminsfile = new File(SUBDIRECTORY + File.separator + SYSADMINS);
	
	/* THE TASK:
	 * As a manager of the organization, I want a real-time report for those servers, which are not running.
	 * The report should tell that which system administrator have right for those servers.
	 * Format: serverName (what is not running) and the list of administrators' name
	 *  ----------
	 *  real-time report: continuosly while the program running every 10 sec
	 *  report: write out on console. FOrmat: serverName (What is not running) and the list of administrators names
	 *  servers: server.txt contains them:
	 *  1) ID of server
	 *  2) Name of server
	 *  3) type
	 *  4) Status of server (RUNNING, STOPPED)
	 *  
	 *  System administrators sysadmins.txt
	 *  1) name
	 *  2) EmployeeID
	 *  3) rest): ID of servers for he/she has right for
	 *  
	 *  TEST: if the servers.txt has been changed then it will be presented by the report
	 */

	// Method to read data from sysadmins.txt and create the appropriate objects
	private static ArrayList<Sysadmin> readSysadmins() {
		
		// Collection to store the sysadmins
		ArrayList<Sysadmin> sysadmins = new ArrayList<>();
		String inputLine;
		
		try (BufferedReader br = new BufferedReader(new FileReader(sysadminsfile))) {
			
			// read every line of the file
			while ((inputLine = br.readLine()) != null) {
				String[] attributes = inputLine.split(",");
				if( attributes.length < 3 )
				{
					// Not enough parameter
					System.out.println( "Some parameters are missing from sysadmins.txt");
					System.exit(-1);
				}
				
				// Collection to store the server IDs
				ArrayList<Integer> servers = new ArrayList<>();
				
				for (int i = 2; i < attributes.length; ++i) {
					servers.add(Integer.parseInt(attributes[i]));
				}
				
				// Create a sysadmin
				sysadmins.add(
						new Sysadmin(
								attributes[0],
								Integer.parseInt(attributes[1]),
								servers));
			}
		} catch (FileNotFoundException fnfe ){
			System.out.println("File not found!!");
			fnfe.printStackTrace();
			System.exit(-1);
		} catch (IOException ioe ) {
			System.out.println("Something wrong happened while reading lines! (Maybe no lines?)");
			ioe.printStackTrace();
			System.exit(-1);
		} catch (NumberFormatException nfe){
			System.out.println("Cannot parse integer from string! Wrong format!");
			nfe.printStackTrace();
			System.exit(-1);
		}

		return sysadmins;
	}
	
	// method to read the information from the servers.txt file
	private static ArrayList<Server> readServers(){
		
		// Collection to store the servers
		ArrayList<Server> servers = new ArrayList<>();
		String inputLine;

		try (BufferedReader br = new BufferedReader(new FileReader(serversfile))) {
			
			while ((inputLine = br.readLine()) != null) {
				String[] attributes = inputLine.split(",");

				if( attributes.length != 4 )
				{
					// Not enough parameter
					System.out.println( "Some parameters are missing from servers.txt");
					System.exit(-1);
				}
				
				// Create a server
				// lowercase the type of the server and create the appropriate object
				switch( attributes[2].toLowerCase() ){
					case "linux":
						servers.add(
								new LinuxServer(
										Integer.parseInt(attributes[0]),
										attributes[1],
										Type.LINUX,
										attributes[3].equalsIgnoreCase("running") ? Server.Status.RUNNING : Server.Status.STOPPED));
						break;
					case "linuxweb":
						servers.add(
								new LinuxDatabaseServer(
										Integer.parseInt(attributes[0]),
										attributes[1],
										Type.LINUXWEB,
										attributes[3].equalsIgnoreCase("running") ? Server.Status.RUNNING : Server.Status.STOPPED));
						break;
					case "linuxdb": 
						servers.add(
								new LinuxDatabaseServer(
										Integer.parseInt(attributes[0]),
										attributes[1],
										Type.LINUXDB,
										attributes[3].equalsIgnoreCase("running") ? Server.Status.RUNNING : Server.Status.STOPPED));
						break;
					case "linuxdbandweb":
						servers.add(
							new LinuxDatabaseAndWebServer(
									Integer.parseInt(attributes[0]),
									attributes[1],
									Type.LINUXDBANDWEB,
									attributes[3].equalsIgnoreCase("running") ? Server.Status.RUNNING : Server.Status.STOPPED));
					break;
					case "win": 
						servers.add(
							new WindowsServer(
									Integer.parseInt(attributes[0]),
									attributes[1],
									Type.WIN,
									attributes[3].equalsIgnoreCase("running") ? Server.Status.RUNNING : Server.Status.STOPPED));
					break;
					case "winweb":
						servers.add(
							new WindowsWebServer(
									Integer.parseInt(attributes[0]),
									attributes[1],
									Type.WINWEB,
									attributes[3].equalsIgnoreCase("running") ? Server.Status.RUNNING : Server.Status.STOPPED));
					break;
					case "windb":
						servers.add(
							new WindowsDatabaseServer(
									Integer.parseInt(attributes[0]),
									attributes[1],
									Type.WINDB,
									attributes[3].equalsIgnoreCase("running") ? Server.Status.RUNNING : Server.Status.STOPPED));
					break;
					case "windbandweb":
						servers.add(
							new WindowsDatabaseAndWebServer(
									Integer.parseInt(attributes[0]),
									attributes[1],
									Type.WINDBANDWEB,
									attributes[3].equalsIgnoreCase("running") ? Server.Status.RUNNING : Server.Status.STOPPED));
					break;
					default: System.out.println("Cannot determine server type!"); break;
				
				}
			}
		} catch (FileNotFoundException fnfe ){
			System.out.println("File not found!!");
			fnfe.printStackTrace();
			System.exit(-1);
		} catch (IOException ioe ) {
			System.out.println("Something wrong happened while reading lines! (Maybe no lines?)");
			ioe.printStackTrace();
			System.exit(-1);
		} catch (NumberFormatException nfe){
			System.out.println("Cannot parse integer from string! Wrong format!");
			nfe.printStackTrace();
			System.exit(-1);
		}

		return servers;
	}

	// call this method for magic
	private static void homework() {
		
		// Initially save the time when the files were last modified
		long serverfilemodified = serversfile.lastModified();
		long sysadfilemodified = sysadminsfile.lastModified();
		
		ArrayList<Server> servers = readServers();
		ArrayList<Sysadmin> sysadmins = readSysadmins();
		
		// infinite loop represents the 
		// "real-time report: continuosly while the program running every 10 sec"
		while (true) {
			// if the file has been modified since the last check
			if( serversfile.lastModified() != serverfilemodified )
			{
				// re read the data
				servers = readServers();
				// set the new modification time
				serverfilemodified = serversfile.lastModified();
			}
			// if the file has been modified since the last check
			if( sysadminsfile.lastModified() != sysadfilemodified )
			{
				// re read the data
				sysadmins = readSysadmins();
				sysadfilemodified = sysadminsfile.lastModified();
			}
			
			// business logic comes here
			// go through every server
			for (Server server : servers) {
				// if a server is down
				if( server.getStatus() == Status.STOPPED ){
					// print the server's name
					System.out.print( server.getName() + " : ");
					// go through every sysadmin
					for (Sysadmin sysadmin : sysadmins) {
						// go through every sysadmin's accessed server
						for (Integer ids : sysadmin.getAccessedServers()) {
							// if the sysadmin has access to the server
							if( ids == server.getId() ){
								// print the sysadmin's name
								System.out.print( sysadmin.getName() + ", " );
							}
						}
					}
					System.out.println();
				}
			}
			System.out.println();
			
			// Sleep the main thread for 10 sec at every while cycle
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("InterruptedException happened! I'M INTERRUPTED!");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		homework();
	}

}
