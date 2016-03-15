package hu.schonherz.training.creational;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestBuilderPattern {
	//The example address for testing the builder
	public static String a = new Address.AddressBuilder().houseNumber("HNO-22/34").floorNumber("First Floor")
			.street("123 ABC Street").city("Some City").province("Some Province").country("Some Country")
			.zip("12345676").landmark("Near XYZ beach").build();;
	//The file witch contains the addresses
	public static File file = new File("addresses.txt");
	public static boolean fileExisting = file.exists();
	public static boolean fileCanRead = file.canRead();
			
	public static void main(String[] args) {
		//The list witch contains the build addresses
		List<String> address = new ArrayList<String>();
		//Reading from the file
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new FileReader(file));
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] parts = line.split(";");
				String a = new Address.AddressBuilder().houseNumber(parts[0])
				         .floorNumber(parts[1]).street(parts[2])
				         .city(parts[3]).province(parts[4])
				         .country(parts[5]).zip(parts[6])
				         .landmark(parts[7]).build();
				address.add(a);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Write the addresses from the list to console
		for (String string : address) {
			System.out.println(string);
		}
	}
}
