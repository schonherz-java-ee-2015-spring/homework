package hu.schonherz.java.training.firereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.training.pojo.Employee;

public class EmployeeReader {

<<<<<<< HEAD
	private static final String SUBDIRECTORY = "files";
	private static final String FILENAME = "employees.txt";

	// Will it works under Linux? ÔøΩÔøΩÔøΩÔøΩ
	private static File file = new File(SUBDIRECTORY + File.separator
	/* linux is fog tudni futni a file.separator miatt */
			+ FILENAME);

	/**
	 * @return List of employees which has been found in employees.txt file
	 */
	public static List<Employee> read() {
		// list√°ba pakoljuk √©s azzal t√©r√ºnk vissza
		// Hint: BufferedReader usage
		List<Employee> result = new LinkedList<Employee>();

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] parts = line.split(",");
				Employee emp = new Employee(parts[0], Integer.parseInt(parts[1]));
				result.add(emp);
				// System.out.println(line);

			}
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("BufferedReader error -- File not found");
			e.printStackTrace();
		}
		return result;
	}

=======
  private static final String SUBDIRECTORY = "files";
  private static final String FILENAME = "employees.txt";
  
  //Will it works under Linux?                         °°°°
  //private static File file = new File(SUBDIRECTORY + "\\" + FILENAME);
  private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);
  
  /**
   * @return List of employees which has been found in employees.txt file
   */
  public static List<Employee> read() {
    List<Employee> result = new LinkedList<Employee>();
    /*
     * Alternative solution
    Scanner sc = new Scanner(file);
    while(sc.hasNext()) {
      
    }*/
    BufferedReader bufferedReader = null;
    try {
      bufferedReader = new BufferedReader(new FileReader(file));
      String line;
      while((line = bufferedReader.readLine()) != null) {
        String[] attributes = line.split(",");
        if (attributes.length < 2) {
          throw new MyException();
        }
        Employee employee = new Employee(attributes[0], Integer.parseInt(attributes[1]));
        result.add(employee);
      }
    } catch (IOException e) {
      System.out.println("File is not found");
    } catch (MyException e) {
      System.out.println("File is corruptd");
    } finally {
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException e) {
          System.out.println("BufferedReader was not closed");
        }
      }
    }
    return result;
  }
  
>>>>>>> c4bc2faea37cc837a00763b91c277400d53113fd
}
