package hu.schonherz.homework.service.api.writer;

/**
 * @author gabichelsea
 *
 */

@FunctionalInterface
public interface Writer {
	void write(String targetPath);
}
