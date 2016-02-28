package hu.schonherz.java.training.hw1.employee;

import java.util.ArrayList;

public class Developer extends Employee {
	
	private ArrayList<String> tasks;

	/**
	 * @return the tasks
	 */
	public ArrayList<String> getTasks() {
		return tasks;
	}

	/**
	 * @param tasks the tasks to set
	 */
	public void setTasks(ArrayList<String> tasks) {
		this.tasks = tasks;
	}
	
	public void addTask( String task ){
		// TODO some formal validation
		tasks.add(task);
	}
	
	public String removeTask( int which ){
		// TODO some formal validation
		return tasks.remove(which);
	}
	
}
