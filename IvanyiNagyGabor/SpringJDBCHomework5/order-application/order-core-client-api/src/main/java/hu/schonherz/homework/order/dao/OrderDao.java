package hu.schonherz.homework.order.dao;

import java.util.List;

import hu.schonherz.homework.order.dto.OrderDto;

public interface OrderDao {

	public void save(OrderDto dto) throws Exception;

	public void update(OrderDto oldDto, OrderDto newDto) throws Exception;

	public void delete(OrderDto dto) throws Exception;

	public List<OrderDto> find(Long userId) throws Exception;

	public List<OrderDto> findAll() throws Exception;

}
