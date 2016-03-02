package hu.schonherz.java.training.hw1.employee;

import java.util.ArrayList;

public class Developer extends Employee {
	
	// A developer is an employee but also has tasks
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
	
	// Adds a task to the task list
	public void addTask( String task ){
		tasks.add(task);
	}
	
	// Removes a task from the task list given by an id
	public String removeTask( int which ){
		return tasks.remove(which);
	}
	
}
