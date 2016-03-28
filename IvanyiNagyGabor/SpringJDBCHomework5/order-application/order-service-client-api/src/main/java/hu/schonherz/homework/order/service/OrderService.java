package hu.schonherz.homework.order.service;

import java.util.List;

import hu.schonherz.homework.order.vo.OrderVo;

public interface OrderService {
	
	public List<OrderVo> getAllOrder() throws Exception;
	
	public void addOrder(OrderVo orderVo) throws Exception;	
	
	
}

