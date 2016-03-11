/**
 * 
 */
package hu.schonherz.homework.service.impl.notecomp;

import java.util.Comparator;

import hu.schonherz.homework.service.api.model.Note;

/**
 * @author gabichelsea
 *
 */
public class NoteComparatorByName implements Comparator<Note> {

	@Override
	public int compare(Note o1, Note o2) {
		return o1.getAuthorName().compareToIgnoreCase(o2.getAuthorName());
	}

}
