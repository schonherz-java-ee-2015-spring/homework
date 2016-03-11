/**
 * 
 */
package hu.schonherz.homework.service.impl.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import hu.schonherz.homework.service.api.model.Note;
import hu.schonherz.homework.service.api.reader.JSONReader;
import hu.schonherz.homework.service.impl.util.JSONObjectUtil;

/**
 * @author gabichelsea
 *
 */
public class NoteReader implements JSONReader<Note> {

	@Override
	public List<Note> read(String sourcePath) {
		return createNotesFromContent(loadFileContent(sourcePath));
	}

	/**
	 * Read the whole file content to a String reference Important: Keep the
	 * right JSON arrays form never delete the end bracket from the file and do
	 * not append it again after we finish reading It costs much resources to do
	 * it
	 * So instead of when we read the whole file to String reference then we
	 * append the right brace to our String
	 * 
	 * @param sourcePath
	 * @return
	 */
	private String loadFileContent(String sourcePath) {
		String content = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(sourcePath)))) {

			String line;
			while ((line = reader.readLine()) != null) {
				content += line;
			}
			content += "]";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * The content is actually the file full content + "]" Parsing it to
	 * JSONArray and use foreach to get JSONObjects Convert Notes from
	 * JSONObjects
	 * 
	 * @param content
	 * @return
	 */
	private List<Note> createNotesFromContent(String content) {
		List<Note> notes = new ArrayList<Note>();
		JSONParser parser = new JSONParser();

		JSONArray jsonArray;
		try {
			jsonArray = (JSONArray) parser.parse(content);
			for (Object object : jsonArray) {
				JSONObject jsonObject = (JSONObject) object;
				System.out.println(JSONObjectUtil.convertJSONObjectToNote(jsonObject));
				notes.add(JSONObjectUtil.convertJSONObjectToNote(jsonObject));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return notes;
	}

}
