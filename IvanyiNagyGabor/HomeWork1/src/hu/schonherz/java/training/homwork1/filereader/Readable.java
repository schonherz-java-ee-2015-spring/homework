package hu.schonherz.java.training.homwork1.filereader;

import java.io.File;
import java.util.List;

@FunctionalInterface
public interface Readable {
	public abstract List<? extends Object> readFromFile(File file);
}
