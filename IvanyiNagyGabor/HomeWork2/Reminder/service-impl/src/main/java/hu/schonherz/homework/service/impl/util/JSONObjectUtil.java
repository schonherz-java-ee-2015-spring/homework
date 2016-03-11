/**
 * 
 */
package hu.schonherz.homework.service.impl.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.simple.JSONObject;

import hu.schonherz.homework.service.api.model.Note;

/**
 * @author gabichelsea
 *
 */
public class JSONObjectUtil {

	private JSONObjectUtil() {
	}
	
	/**
	 * This method create and give back a JSON object as a Note class
	 * The information is from the console except the dateTime
	 */
	@SuppressWarnings({ "resource", "unchecked" })
	public static JSONObject createJSONObjectForNote() {
		JSONObject object = new JSONObject();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Author:");
		object.put("Author", scanner.nextLine());
		System.out.println("Title:");
		object.put("Title", scanner.nextLine());
		System.out.println("Remark:");
		object.put("Remark", scanner.nextLine());

		LocalDateTime dateTime = LocalDateTime.now();
		object.put("Time", dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

		return object;
	}
	
	
	/**
	 * Create Note from JSONObject
	 * @param jsonObject
	 * @return
	 */
	public static Note convertJSONObjectToNote(JSONObject jsonObject) {
		Note note = new Note();
		note.setAuthorName((String) jsonObject.get("Author"));
		note.setTitle((String) jsonObject.get("Title"));
		note.setRemark((String) jsonObject.get("Remark"));
		note.setDateTime(LocalDateTime.parse((String) jsonObject.get("Time"),
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		
		return note;
	}
}
