package hu.schonherz.homework.order.dao;

import java.util.List;

public interface BaseDao<T> {

	public void save(T dto) throws Exception;

	public void update(T dto) throws Exception;

	public void delete(Long id) throws Exception;

	public T find(Long id) throws Exception;

	public List<T> findAll() throws Exception;
}
