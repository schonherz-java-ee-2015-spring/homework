package hu.schonherz.homework.service.impl.util;

import java.time.LocalDateTime;
import java.util.List;

import hu.schonherz.homework.service.api.model.Note;

public class NoteUtil {
	private NoteUtil() {}
	
	
	public static List<Note> getNotes(List<Note> notes) {
		return notes;
	}
	
	public static List<Note> getNotesByName(List<Note> notes) {
		return null;
	}
	
	public static List<Note> getNotesByNameReverse(List<Note> notes) {
		return null;
	}

	public static List<Note> getNotesByTitle(List<Note> notes) {
		return null;
	}
	
	public static List<Note> getNotesByTitleReverse(List<Note> notes) {
		return null;
	}
	
	public static List<Note> getNotesByDate(List<Note> notes) {
		return null;
	}
	
	public static List<Note> getNotesByDateReverse(List<Note> notes) {
		return null;
	}
	
	
	
	public static List<Note> getNotesBeforeDate(List<Note> notes, LocalDateTime dateTime) {
		return null;
	}
	
	public static List<Note> getNotesAfterDate(List<Note> notes, LocalDateTime dateTime) {
		return null;
	}
	
	public static Note getLastNote(List<Note> notes) {
		return null;
	}
	
	
}
