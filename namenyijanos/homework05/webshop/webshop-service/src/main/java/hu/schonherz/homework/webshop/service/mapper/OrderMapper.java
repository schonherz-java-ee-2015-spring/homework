package hu.schonherz.homework.webshop.service.mapper;

import hu.schonherz.homework.webshop.dto.Order;
import hu.schonherz.homework.webshop.vo.OrderVo;

public class OrderMapper {

	public static OrderVo toVo( Order order ){
		OrderVo vo = new OrderVo();
		vo.setUserId(order.getUserId());
		vo.setProductId(order.getProductId());
		return vo;
	}
	
	public static Order toDto( OrderVo vo ){
		Order order = new Order();
		order.setUserId(vo.getUserId());
		order.setProductId(vo.getProductId());
		return order;
	}
}
