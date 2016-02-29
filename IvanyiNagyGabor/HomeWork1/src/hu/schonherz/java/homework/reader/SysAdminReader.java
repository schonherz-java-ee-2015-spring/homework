package hu.schonherz.java.homework.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hu.schonherz.java.homework.model.SysAdmin;

public class SysAdminReader implements Reader<SysAdmin> {

	@Override
	public List<SysAdmin> read(File file) {
		List<SysAdmin> sysAdmins = new ArrayList<SysAdmin>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			SysAdmin sysAdmin;
			while ((line = br.readLine()) != null) {
				sysAdmin = sysAdminParser(line.split(","));
				if (sysAdmin != null) {
					sysAdmins.add(sysAdmin);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + file.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("General I/O exception: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Unknown exception: " + e.getMessage());
		}
		return sysAdmins;
	}

	public SysAdmin sysAdminParser(String[] slices) {
		SysAdmin sysAdmin = null;
		try {
			Set<Long> serverIds = new HashSet<Long>();
			for (int i = 2; i < slices.length; ++i) {
				serverIds.add(Long.parseLong(slices[i].trim()));
			}
			sysAdmin = new SysAdmin(slices[0].trim(), Long.parseLong(slices[1].trim()), serverIds);
		} catch (NumberFormatException e) {
			System.err.println("Cannot convert number: " + slices[1].trim() + "(" + slices[0].trim() + ")");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBounds: " + slices[0].trim() + " has not ID");
		}
		return sysAdmin;
	}

}
