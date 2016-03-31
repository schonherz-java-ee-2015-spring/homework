package hu.schonherz.java.training.jdbc.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.java.training.jdbc.core.records.Order;
import hu.schonherz.java.training.jdbc.service.vo.OrderVo;

public class OrderMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public OrderMapper() {
		super();
	}

	public static OrderVo toVo(Order order) {
		return mapper.map(order, OrderVo.class);
	}

	public static Order toDto(OrderVo orderVo) {
		return mapper.map(orderVo, Order.class);
	}

	public static List<OrderVo> toVo(List<Order> orders) {
		List<OrderVo> orderVos = new ArrayList<>();
		for (Order order : orders) {
			orderVos.add(toVo(order));
		}
		return orderVos;
	}

	public static List<Order> toDto(List<OrderVo> orderVos) {
		List<Order> orders = new ArrayList<>();
		for (OrderVo orderVo : orderVos) {
			orders.add(toDto(orderVo));
		}
		return orders;
	}

}
