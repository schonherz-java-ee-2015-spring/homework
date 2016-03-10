/**
 * 
 */
package hu.schonherz.homework.service.impl.writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.json.simple.JSONObject;

import hu.schonherz.homework.service.api.writer.JSONWriter;
import hu.schonherz.homework.service.impl.util.JSONObjectUtil;

/**
 * @author gabichelsea We can write Note objects as JSONObjects to a JSON file
 */
public class NoteWriter implements JSONWriter {

	@Override
	public void write(String targetPath) {
		beforeWriteObject(targetPath);
		writeJSONObjectToFile(targetPath);
	}

	/*
	 * This method ask for a JSON object as Note then write it to file If the
	 * file is exist then we will append
	 */

	private void writeJSONObjectToFile(String targetPath) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(targetPath), true))) {
			JSONObject object = JSONObjectUtil.createJSONObjectForNote();
			writer.write(object.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void beforeWriteObject(String targetPath) {
		File file = new File(targetPath);
		if (!file.exists() || file.length() == 0) {
			try (FileWriter writer = new FileWriter(file)){
				writer.write("[");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

//		if (file.length() > 1) {
//			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))) {
//				
//			} 
//		}
	}

}
