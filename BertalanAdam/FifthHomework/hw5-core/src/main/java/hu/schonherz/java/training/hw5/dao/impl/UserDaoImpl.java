package hu.schonherz.java.training.hw5.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.schonherz.java.training.hw5.dao.UserDao;
import hu.schonherz.java.training.hw5.dao.mapper.ProductMapper;
import hu.schonherz.java.training.hw5.dao.mapper.UserMapper;
import hu.schonherz.java.training.hw5.dto.Product;
import hu.schonherz.java.training.hw5.dto.User;

//Repository tells spring that this class is a DAO
@Repository
public class UserDaoImpl implements UserDao {
	
	// Autowired tells spring that this is a dependency for this class that should be injected.
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean addUser(User user) {
		return addUser(user.getName());
	}

	@Override
	public boolean addUser(int id, String name) {
		int res = jdbcTemplate.update("INSERT INTO public.\"User\" (id, name) VALUES (?,?);", id, name);
		return res == 0 ? false : true;
	}
	
	@Override
	public boolean addUser(String name) {
		int res = jdbcTemplate.update("INSERT INTO public.\"User\" (name) VALUES (?);", name);
		return res == 0 ? false : true;
	}

	/**
	 * Note: Uses PreparedStatement.
	 * */
	@Override
	public boolean updateUser(User user) {		
		int res = jdbcTemplate.update("UPDATE public.\"User\" SET name=? WHERE id=?;", user.getName(), user.getId());
		return res == 0 ? false : true;
	}
	
	@Override
	public boolean deleteUser(User user) {
		return deleteUser( user.getId(), user.getName());
	}
	
	@Override
	public boolean deleteUser(String name){
		return deleteUser( 0, name );
	}
	
	@Override
	public boolean deleteUser(int id, String name) {
		int res = jdbcTemplate.update("DELETE FROM public.\"User\" WHERE id=? OR name=?;", id, name );
		return res == 0 ? false : true;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = null;
		users = jdbcTemplate.query("SELECT id, name FROM public.\"User\";", new UserMapper() );
		return users;
	}
	
	@Override
	public User getUser(User user) {
		User user_loc = null;
		user_loc = getUser( user.getId(), user.getName());
		return user_loc;
	}

	/**
	 * Note: Uses PreparedStatement.
	 * */
	@Override
	public User getUser(int id, String name) {
		User user = null;
		user = jdbcTemplate.queryForObject("SELECT * FROM public.\"User\" WHERE id=? AND name=?;", new UserMapper() );
		return user;
	}
	
	@Override
	public List<Product> getOrdersOfUser(User user) {
		return getOrdersOfUser(user.getId(), user.getName());
	}

	/**
	 * Note: Uses PreparedStatement.
	 * */
	@Override
	public List<Product> getOrdersOfUser(int id, String name) {
		List<Product> products = null;
		
		String sql = "SELECT P.id, P.name FROM "
				+ "public.\"Product\" AS P INNER JOIN public.\"Order\" AS O ON "
				+ "P.id = O.product_id INNER JOIN public.\"User\" AS U ON "
				+ "O.user_id = U.id WHERE U.id=? AND U.name=?;";
		
		products = jdbcTemplate.query(sql, new ProductMapper(), id, name );

		return products;
	}
}
