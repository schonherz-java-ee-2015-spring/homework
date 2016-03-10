/**
 * 
 */
package hu.schonherz.homework.display.main;

import java.io.File;

import hu.schonherz.homework.service.api.model.Note;
import hu.schonherz.homework.service.api.reader.Reader;
import hu.schonherz.homework.service.api.writer.Writer;
import hu.schonherz.homework.service.impl.reader.NoteReader;
import hu.schonherz.homework.service.impl.writer.NoteWriter;


/**
 * @author gabichelsea
 *
 */
public class ReminderApp {
	
	private static final String SUBDIRECTORY = "../files";
	private static final String FILENAME = "reminder.json";
	
	public static void main(String[] args) {
		String sourceName = SUBDIRECTORY + File.separator + FILENAME;
		Writer writer = new NoteWriter();
		writer.write(sourceName);
		
		Reader<Note> reader = new NoteReader();
		reader.read(sourceName);
	}
}
