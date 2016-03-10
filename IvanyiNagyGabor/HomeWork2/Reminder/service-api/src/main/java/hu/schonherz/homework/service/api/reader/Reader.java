/**
 * 
 */
package hu.schonherz.homework.service.api.reader;

import java.util.List;

/**
 * @author gabichelsea
 *
 */

@FunctionalInterface
public interface Reader<T> {
	List<T> read(String sourcePath);
}
