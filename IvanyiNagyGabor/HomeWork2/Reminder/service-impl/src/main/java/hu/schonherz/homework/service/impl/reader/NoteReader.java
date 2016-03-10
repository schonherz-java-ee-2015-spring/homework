/**
 * 
 */
package hu.schonherz.homework.service.impl.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import hu.schonherz.homework.service.api.model.Note;
import hu.schonherz.homework.service.api.reader.JSONReader;

/**
 * @author gabichelsea
 *
 */
public class NoteReader implements JSONReader<Note> {

	@Override
	public List<Note> read(String sourcePath) {
		return processFile(sourcePath);
	}

	private List<Note> processFile(String sourcePath) {
		JSONParser parser = new JSONParser();
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(sourcePath)))) {
			String content = "";
			String line;
			while ((line= reader.readLine()) != null) { 
				content += line;
			}
			/*
			 * Important: Keep the right JSON arrays form
			 * Never delete the end bracket from the file ----> because of append!!!
			 */
			content += "]";
			
//			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(new File(sourcePath)));
			JSONArray jsonArray = (JSONArray) parser.parse(content);
			for (Object object : jsonArray) {
				Note note = new Note();
				JSONObject jsonObject = (JSONObject) object;
				note.setAuthorName((String) jsonObject.get("Author"));
				note.setTitle((String) jsonObject.get("Title"));
				note.setRemark((String) jsonObject.get("Remark"));
				note.setDateTime(LocalDateTime.parse((String) jsonObject.get("Time"),
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
				System.out.println(note);
			}

			// System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
