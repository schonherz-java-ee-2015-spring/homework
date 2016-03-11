/**
 * 
 */
package hu.schonherz.homework.service.impl.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import hu.schonherz.homework.service.api.writer.JSONWriter;
import hu.schonherz.homework.service.impl.util.JSONObjectUtil;

/**
 * @author gabichelsea We can write Note objects as JSONObjects to a JSON file
 */
public class NoteWriter implements JSONWriter {

	@Override
	public void write(String targetPath) {
		prepareToWriteObject(targetPath);
		writeJSONObjectToFile(targetPath);
	}

	/**
	 * This method ask for a JSON object as Note then write it to file If the
	 * file is exist then we will append
	 */

	private void writeJSONObjectToFile(String targetPath) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(targetPath), true))) {
			JSONObject object = JSONObjectUtil.createJSONObjectForNote();
			writer.write(object.toJSONString());
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The JSON file have to begin by left brace('[') --> JSONArray
	 * @param targetPath
	 */
	private void prepareToWriteObject(String targetPath) {
		File file = new File(targetPath);
		if (!file.exists() || file.length() == 0) {
			try (FileWriter writer = new FileWriter(file)){
				writer.write("[");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
