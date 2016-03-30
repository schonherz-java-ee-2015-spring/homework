package hu.schonherz.homework.blog.core.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.homework.blog.core.entitiy.Order;
import hu.schonherz.homework.blog.core.repository.OrderDao;

@Repository
public class OrderJDBCTemplate implements OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Order> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderByUser_Id(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderByProduct_Id(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOrder(int userid, int productid) {
		String sql = "INSERT INTO public.\"Order\"( user_id, product_id) VALUES (?, ?);";
		jdbcTemplate.update(sql, userid, productid);
	}

	@Override
	public void deleteOrderByUser_Id(int userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrderByProduct_Id(int productid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserOrder(int user_Id, int newProductId) {
		// TODO Auto-generated method stub

	}

}
