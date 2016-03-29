package hu.schonherz.homework.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.homework.core.dto.OrderDto;
import hu.schonherz.homework.service.vo.OrderVo;

public class OrderMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static OrderVo toVo(OrderDto order) {
		return mapper.map(order, OrderVo.class);
	}

	public static OrderDto toDto(OrderVo orderVo) {
		return mapper.map(orderVo, OrderDto.class);
	}

	public static List<OrderVo> toVo(List<OrderDto> orders) {
		List<OrderVo> orderVos = new ArrayList<>();
		for (OrderDto order : orders) {
			orderVos.add(toVo(order));
		}
		return orderVos;
	}

	public static List<OrderDto> toDto(List<OrderVo> orderVos) {
		List<OrderDto> orders = new ArrayList<>();
		for (OrderVo orderVo : orderVos) {
			orders.add(toDto(orderVo));
		}
		return orders;
	}

}