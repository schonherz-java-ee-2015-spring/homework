/**
 * 
 */
package hu.schonherz.homework.service.impl.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.simple.JSONObject;

/**
 * @author gabichelsea
 *
 */
public class JSONObjectUtil {

	private JSONObjectUtil() {
	}
	
	/*
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
}
