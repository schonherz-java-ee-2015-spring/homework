package hu.schonherz.homework.order.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.homework.order.dto.Order;
import hu.schonherz.homework.order.vo.OrderVo;

public class OrderMapper {
	private static Mapper mapper = new DozerBeanMapper();

	/**
	 * Convert Order to OrderVo
	 */
	public static OrderVo toVo(Order order) {
		return mapper.map(order, OrderVo.class);
	}

	/**
	 * Convert OrderVo to Order
	 */
	public static Order toDto(OrderVo orderVo) {
		return mapper.map(orderVo, Order.class);
	}

	/**
	 * Convert Order list to OrderVo list
	 */
	public static List<OrderVo> toVo(List<Order> orders) {
		List<OrderVo> orderVos = new ArrayList<OrderVo>();
		for (Order order : orders) {
			orderVos.add(toVo(order));
		}
		return orderVos;
	}

	/**
	 * Convert OrderVo list to Order list
	 */
	public static List<Order> toDto(List<OrderVo> orderVos) {
		List<Order> orders = new ArrayList<Order>();
		for (OrderVo orderVo : orderVos) {
			orders.add(toDto(orderVo));
		}
		return orders;
	}
}
