package hu.schonherz.homework.webshop.service;

import hu.schonherz.homework.webshop.vo.ProductVo;
import hu.schonherz.homework.webshop.vo.UserVo;

public interface OrderService {

	void addOrder(UserVo user, ProductVo product);

	void addOrder(int userId, int productId);
}
