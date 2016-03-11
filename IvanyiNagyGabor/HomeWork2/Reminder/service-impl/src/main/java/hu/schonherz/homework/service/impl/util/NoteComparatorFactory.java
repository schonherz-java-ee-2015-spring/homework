/**
 * 
 */
package hu.schonherz.homework.service.impl.util;

import java.util.Comparator;

import hu.schonherz.homework.service.api.model.Note;
import hu.schonherz.homework.service.impl.notecomp.NoteComparatorByDate;
import hu.schonherz.homework.service.impl.notecomp.NoteComparatorByName;
import hu.schonherz.homework.service.impl.notecomp.NoteComparatorByTitle;

/**
 * @author gabichelsea
 *
 */

/**
 * 
 * @author gabichelsea The {@link NoteComparatorFactory} get the actually
 *         Comparator
 */
public class NoteComparatorFactory {
	public Comparator<Note> getNoteComparator(String noteComparatorType) {
		if (noteComparatorType == null) {
			return null;
		}

		if (noteComparatorType.equalsIgnoreCase("BYNAME")) {
			return new NoteComparatorByName();
		} else if (noteComparatorType.equalsIgnoreCase("BYTITLE")) {
			return new NoteComparatorByTitle();
		} else if (noteComparatorType.equalsIgnoreCase("BYDATE")) {
			return new NoteComparatorByDate();
		}

		return null;
	}
}
