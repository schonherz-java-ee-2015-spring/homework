package hu.schonherz.java.training.thread;

import java.util.List;

import hu.schonherz.java.training.firereader.EmployeeReader;
import hu.schonherz.java.training.pojo.Employee;

public class ReaderThread extends Thread {

	@Override
	public void run() {
		for(int i = 0; i < 3; i++) {
			List<Employee> employees = EmployeeReader.read();
			for (Employee employee : employees) {
				System.out.println(employee.getName() + " - " + employee.getEmployeeID());
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
