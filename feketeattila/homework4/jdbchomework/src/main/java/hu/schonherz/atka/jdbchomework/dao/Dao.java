package hu.schonherz.atka.jdbchomework.dao;

public interface Dao<T> {
	public void addElement(T t);

	public void updateElement(T t);

	public void deleteElement(T t);
}
