package hu.schonherz.java.training.pojo;

import java.io.Serializable;
import java.util.List;

public class Developer extends Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3936601396418860868L;
	private List<String> tasks;

//	private int name;
	
	public Developer() {
		super();
	}
	
	
//	@Override
//	public void setName(final String name) {
//		super.setName(name);
//		
//		super.name = "NoNAME";
//		this.name = 123;
//	}
	
	public Developer(String name, int employeeID, List<String> tasks) {
		super(name, employeeID);
		this.tasks = tasks;
	}

	public List<String> getTasks() {
		return tasks;
	}

	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
	}

}
