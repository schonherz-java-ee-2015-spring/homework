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
<<<<<<< HEAD
import java.util.LinkedList;
=======
>>>>>>> c4bc2faea37cc837a00763b91c277400d53113fd
import java.util.List;

import hu.schonherz.java.training.pojo.Developer;

public class DeveloperReader {
<<<<<<< HEAD
	private static final String SUBDIRECTORY = "files";
	private static final String FILENAME = "developers.txt";
	private static final String BINARYFILE = "developers.dat";

	private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);
	private static File binaryfile = new File (SUBDIRECTORY + File.separator + BINARYFILE);

	public static List<Developer> readFromTextFile() {
		List<Developer> dev = new LinkedList<Developer>();

		String line;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
			// try blokkba bele lehet rakni a változódeklarálást
			// a benne lévő változókat be fogja zárni a try befejeztével
			// resource management
			while ((line = bufferedReader.readLine()) != null) {
				int i = 2;
				String[] StringParts = line.split(",");
				List<String> tasks = new LinkedList<String>();
				while (i != StringParts.length) {
					tasks.add(StringParts[i]);
					i++;
				}
				Developer result = new Developer(StringParts[0], Integer.parseInt(StringParts[1]), tasks);
				dev.add(result);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		return dev;
	}

	public static void writeToBinaryFile(List<Developer> developers) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(binaryfile));) {
			oos.writeObject(developers);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<Developer> readFromBinaryFile() {
		List <Developer> result = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(binaryfile))) {
			Object o = ois.readObject();
					result = (List<Developer>) o;
				
			//result = (List<Developer>) ois.readObject();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		
		}
	return result;
	}
=======
  
  private static final String SUBDIRECTORY = "files";
  private static final String FILENAME = "developers.txt";
  private static final String BINARYFILE = "developers.dat";
  
  private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);
  private static File binaryFile = new File(SUBDIRECTORY + File.separator + BINARYFILE);

  //public static List<Developer> readFromTextFile() throws FileNotFoundException, IOException {
  //public static List<Developer> readFromTextFile() throws NumberFormatException {
  public static List<Developer> readFromTextFile() {
    List<Developer> result = new ArrayList<Developer>();
    // Automatic resource management
    // https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      String line;
      while((line = bufferedReader.readLine()) != null) {
        String[] attributes = line.split(",");
        List<String> tasks = new ArrayList<String>();
        for(int i = 2; i<attributes.length; i++) {
          tasks.add(attributes[i]);
        }
        result.add(new Developer(attributes[0], Integer.parseInt(attributes[1]), tasks));
      }
    // pokemon exception handling
    /*} catch (Exception e) {
      System.out.println("Exception!!!");
    } catch (NumberFormatException e) {
      System.out.println("There is no int in 2nd parameter");
    */} catch (IOException e) {
      System.out.println("io error");
    }
    return result;
  }
  
  @Deprecated
  public static void writeToBinaryFile(List<Developer> developers) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(binaryFile));) {
      oos.writeObject(developers);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  @SuppressWarnings("unchecked")
  public static List<Developer> readFromBinaryFile() {
    List<Developer> result = new ArrayList<Developer>();
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(binaryFile))) {
      /*Object o = ois.readObject();
        if (o instanceof ArrayList<?>) {
        result = (List<Developer>) o;
      }*/
      result = (List<Developer>) ois.readObject();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return result;
  }
>>>>>>> c4bc2faea37cc837a00763b91c277400d53113fd
}
