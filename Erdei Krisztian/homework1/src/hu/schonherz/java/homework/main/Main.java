package hu.schonherz.java.homework.main;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.homework.IOhandler.IOHandler;
import hu.schonherz.java.homework.datatypes.Server;
import hu.schonherz.java.homework.datatypes.Sysadmin;

public class Main {

	/*
	*  
	*  1.
	*  
	*  Server osztály alábbi adattagokkal:
	*  	 1) ID of server
	*    2) Name of server
	*    3) type
	*    4) status of server (RUNNING, STOPPED)
	* 
	*  2.
	*  
	*   Sysadmin osztály alábbi adatagokkal
	* 	
	*    1) Name 
	*    2) EmployeeID
	*    3 (rest): Id of servers for he/she has right. (több is lehet)
	* 
	*  3.
	*   IO handler: 
	*   serverRead()
	*  	sysadminRead()
	*   
	*  4.
	*  
	*   Main : olvasás utánni adatagok összehasonlítása , thread kezelése , kiíratás megfelelő módon
	*   
	*   
	*/

	public static void main(String[] args) {

		List<Server> servers = new ArrayList<>();
		servers = IOHandler.serverRead();

		List<Sysadmin> sysadmins = new ArrayList<Sysadmin>();
		sysadmins = IOHandler.sysadminRead();

	}
}
