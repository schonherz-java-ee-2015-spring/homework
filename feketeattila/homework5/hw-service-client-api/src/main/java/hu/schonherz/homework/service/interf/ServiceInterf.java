package hu.schonherz.homework.service.interf;

import java.util.List;

public interface ServiceInterf<T> {
	public List<T> getAllVos();
	public void addVo(T t);
}
