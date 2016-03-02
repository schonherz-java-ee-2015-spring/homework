package hu.schonherz.java.training.pojo;

import java.util.List;

import hu.schonherz.java.training.server.Server;

public class SystemAdministrator extends Employee {
  
  private static final long serialVersionUID = 2244059719140625986L;
  private List<Server> servers;
  private List <String> tasks;

  public SystemAdministrator(String name, int employeeID, List<String> tasks) {
    super(name, employeeID);
    this.tasks = tasks;
  }


public SystemAdministrator(List<Server> servers) {
	super();
	this.servers = servers;
}

public List<Server> getServers() {
    return servers;
  }

  public void setServers(List<Server> servers) {
    this.servers = servers;
  }


public List<String> getTasks() {
	return tasks;
}


public void setTasks(List<String> tasks) {
	this.tasks = tasks;
}


}
