package hu.schonherz.java.homework.main;

import hu.schonherz.java.homework.serverchecker.Serverchecker;

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
	private static void checktheservers(){
		Serverchecker s = new Serverchecker();
		s.run();
	}
	
	public static void main(String[] args)  {
	checktheservers();
	}

}
	

