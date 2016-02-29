package hu.schonherz.java.homework.reader;

import java.io.File;
import java.util.List;

@FunctionalInterface
public interface Reader<T> {

	List<T> read(File file);
}
