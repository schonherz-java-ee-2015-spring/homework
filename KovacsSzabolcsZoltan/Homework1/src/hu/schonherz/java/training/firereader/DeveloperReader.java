package hu.schonherz.java.training.firereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.training.pojo.Developer;

public class DeveloperReader {

	private static final String SUBDIRECTORY = "files";
	private static final String FILENAME = "developers.txt";
	private static final String BINARYFILE = "developers.dat";

	// Will it works under Linux? ����
	private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);
	private static File binaryfile = new File(SUBDIRECTORY + File.separator + BINARYFILE);

	
//    @Deprecated
	public static List<Developer> readFromTextFile() {
		List<Developer> result = new LinkedList<Developer>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			while((line = bufferedReader.readLine()) != null) {
				String[] attributes = line.split(",");
				List<String> tasks = new LinkedList<String>();
				for (int i = 2; i < attributes.length; i++) {
					tasks.add(attributes[i]);
				}
				Developer developer = new Developer(attributes[0], Integer.parseInt(attributes[1]), tasks);
				result.add(developer);
			}
		} catch (IOException e) {
			System.out.println("File is not found!");
		}
		
		
		return result;
	}

	public static void writeToBinaryFile(List<Developer> developers) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(binaryfile))){
			oos.writeObject(developers);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Developer> readFromBinaryFile() {
		List<Developer> result = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(binaryfile))){
			Object o = ois.readObject();
			result = (List<Developer>) o;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		

	}
}
