package hu.schonertz.javaee.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SysadminReader {
	public static final String FILENAME = "sysadmins.txt";
	public static final String FILELOC = "files";
	public static final String FILEPATH = FILELOC + File.separator + FILENAME;
	public static final String SEPARATOR = ",";
	
	public SysadminReader() {
		super();
	}
	
	
	public List<Sysadmin> readSysadmins(){
		List<Sysadmin> ret = new ArrayList<Sysadmin>();
		
		
		try (Scanner sc = new Scanner(new FileInputStream(new File(FILEPATH)))){
			
			for(;sc.hasNextLine();){
				String line = sc.nextLine();
				ret.add(lineToSysadmin(line));
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		return ret;
	}
	
	
	
	public Sysadmin lineToSysadmin(String line){
		Queue<String> sysadminstrings = (Queue<String>) new LinkedList<String>(); 
		
		for(String t : line.split(SEPARATOR))
			sysadminstrings.add(t);
		
		String name = sysadminstrings.remove();
		Integer eid = Integer.parseInt(sysadminstrings.remove());
		
		List<Integer> servers = new ArrayList<Integer>();
		
		for(String servstr : sysadminstrings){
			servers.add(Integer.parseInt(servstr));
		}
		
		return new Sysadmin(eid, name, servers);
	}
	
	
	
}
