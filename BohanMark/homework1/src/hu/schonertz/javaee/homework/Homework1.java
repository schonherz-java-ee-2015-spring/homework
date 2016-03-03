package hu.schonertz.javaee.homework;

import java.util.ArrayList;
import java.util.List;

public class Homework1 {

	public static void main(String[] args) {
		
		try {
			for(;;Thread.sleep(10000)){
				ServerReader serverReader = new ServerReader();
				List <Server> servers = serverReader.readServers();
				
				for (Server server : servers) {
					if(!server.getStatus().equals(Server.RUNNING)){
						System.out.print(server.getName() + ":\t\t");
						getSysadminsByServerId(server.getId()).stream()
						.forEach(s -> {
							System.out.print(s.getName()+";");
						});
						System.out.println("");
					}
				}
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}
	
	public static List<Sysadmin> getSysadminsByServerId(Integer serverId){
		List<Sysadmin> ret = new ArrayList<Sysadmin>();
		SysadminReader sysadminReader = new SysadminReader();
		List<Sysadmin> sysadmins = sysadminReader.readSysadmins();
		
		for (Sysadmin sysadmin : sysadmins) {
			for (Integer server : sysadmin.getServers()) {
				if(server.equals(serverId))
					ret.add(sysadmin);
			}
		}
		
		return ret;
	}

}
