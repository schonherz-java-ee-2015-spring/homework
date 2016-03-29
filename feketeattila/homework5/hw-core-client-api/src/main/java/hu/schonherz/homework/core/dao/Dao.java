package hu.schonherz.homework.core.dao;

import java.util.List;

public interface Dao<T> {
	public void addElement(T t);

	public void updateElement(T t);

	public void deleteElement(T t);

	public List<T> getAllElements();

	public T getElementById(Long id);
}
