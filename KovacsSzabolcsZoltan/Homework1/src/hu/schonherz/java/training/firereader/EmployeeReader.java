package hu.schonherz.java.training.firereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.training.pojo.Employee;

public class EmployeeReader {

	private static final String SUBDIRECTORY = "files";
	private static final String FILENAME = "employees.txt";

	// Will it works under Linux? ����
	private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

	/**
	 * @return List of employees which has been found in employees.txt file
	 */
	public static List<Employee> read() {
		// TODO unimplemented method
		// Hint: BufferedReader usage
		List<Employee> result = new LinkedList<Employee>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] attributes = line.split(",");
				if (attributes.length < 2) {
					throw new IndexOutOfBoundsException("The file is corrupted!");
				}
				Employee employee = new Employee(attributes[0], Integer.parseInt(attributes[1]));
				result.add(employee);
			}

		} catch (IOException e) {
			System.out.println("File is not found!");
		} catch (NumberFormatException e) {
			System.out.println("There is not int in the 2nd parameter");
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
