package hu.schonherz.java.training.thread;

import java.util.List;

import hu.schonherz.java.training.firereader.EmployeeReader;
import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.firereader.SysAdminReader;
import hu.schonherz.java.training.pojo.Employee;
import hu.schonherz.java.training.pojo.Servers;
import hu.schonherz.java.training.pojo.SystemAdministrator;

public class ServerReaderThread extends Thread {

	@Override
	public void run() {
		while(true){
			List<SystemAdministrator> sysadminok = SysAdminReader.read();
			  //List <Servers> servers = ServerReader.read();
				List<Servers> szerverek = ServerReader.read();
				for (Servers servers : szerverek) {
					if (servers.getStatus().equals("STOPPED")) {
						int count = 0;
						for (SystemAdministrator systemAdministrator : sysadminok) {
							for (int i = 0; i < systemAdministrator.getTasks().size(); i++) {
								if (servers.getID() == Integer.parseInt(systemAdministrator.getTasks().get(i))) {
									if (count == 0) {
										System.out.println(servers.getServerName() + ":");
										count++;
									}
									if (count > 0) {
										System.out.println(systemAdministrator.getName());
									}
								}
							}

						}
					}
				}
			   try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception ServerReaderThread");
				e.printStackTrace();
			}  
		  }
	}

}
