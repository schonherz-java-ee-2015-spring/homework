package listEmployees;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private String jobTitle;
	private int salary;
	private List<Employee> subordinates;

	public void add(Employee e) {
		subordinates.add(e);
	}

	public void remove(Employee e) {
		subordinates.remove(e);
	}

	public String toString() {
		return ("Name: " + name + ". Job title: " + jobTitle + ". Salary: " + salary + ".");
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public Employee(String name, String jobTitle, int salary) {
		super();
		this.name = name;
		this.jobTitle = jobTitle;
		this.salary = salary;
		subordinates = new ArrayList<Employee>();
	}
}
