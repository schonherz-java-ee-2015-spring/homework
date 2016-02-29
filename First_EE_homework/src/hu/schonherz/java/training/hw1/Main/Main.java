package hu.schonherz.java.training.hw1.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import hu.schonherz.java.training.hw1.employee.Sysadmin;
import hu.schonherz.java.training.hw1.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.hw1.server.LinuxDatabaseServer;
import hu.schonherz.java.training.hw1.server.LinuxServer;
import hu.schonherz.java.training.hw1.server.Server;
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
				// TODO validation
				String[] attributes = inputLine.split(",");
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
		} catch (Exception e ) {
			// TODO: handle exception
		}

		return sysadmins;
	}
	
	private static ArrayList<Server> readServers(){
		
		// Collection to store the servers
		ArrayList<Server> servers = new ArrayList<>();
		String inputLine;

		try (BufferedReader br = new BufferedReader(new FileReader(serversfile))) {
			
			while ((inputLine = br.readLine()) != null) {
				// TODO validation
				String[] attributes = inputLine.split(",");
				
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
		} catch (Exception e ) {
			// TODO: handle exception
		}

		return servers;
	}

	private static void homework() {
		// TODO reread the file only when it is modified
		
		// Initially save the time when the files were last modified
		long serverfilemodified = serversfile.lastModified();
		long sysadfilemodified = sysadminsfile.lastModified();
		
		// infinite loop represents the 
		// "real-time report: continuosly while the program running every 10 sec"
		while (true) {
			// if the file has been modified since the last check
			if( serversfile.lastModified() != serverfilemodified )
			{
				// re read the data
				// readServers();
				// set the new modification time
				serverfilemodified = serversfile.lastModified();
			}
			// if the file has been modified since the last check
			if( sysadminsfile.lastModified() != sysadfilemodified )
			{
				// re read the data
				// readSysadmins();
				sysadfilemodified = sysadminsfile.lastModified();
			}
			
			// Sleep the main thread for 10 sec at every while cycle
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		homework();
	}

}
