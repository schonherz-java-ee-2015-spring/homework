package hu.schonherz.homework.order.service.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import hu.schonherz.homework.order.connection.ConnectionHandler;
import hu.schonherz.homework.order.dao.ProductDao;
import hu.schonherz.homework.order.dao.impl.ProductDaoImpl;
import hu.schonherz.homework.order.dto.Product;
import hu.schonherz.homework.order.service.ProductService;
import hu.schonherz.homework.order.service.mapper.ProductMapper;
import hu.schonherz.homework.order.vo.ProductVo;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	public ProductServiceImpl() throws SQLException {
		this.productDao = new ProductDaoImpl(ConnectionHandler.getConnection());
	}

	/**
	 * Return the all Product from the Product table
	 */
	@Override
	public List<ProductVo> getAllProduct() {
		List<Product> products = productDao.getAllProduct();
		return ProductMapper.toVo(products);
	}

	/**
	 * Insert Products into the Product table with batch size
	 */
	@Override
	public void addProductsWithBatchSize(Integer batchSize, ProductVo... products) {
		Product[] array = ProductMapper.toDto(Arrays.asList(products)).toArray(new Product[products.length]);
		productDao.addProductsWithBatchSize(batchSize, array);		
	}

	/**
	 * Delete Products from the Product table with batch size
	 */
	@Override
	public void deleteProductsWithBatchSize(Integer batchSize, ProductVo... products) {
		Product[] array = ProductMapper.toDto(Arrays.asList(products)).toArray(new Product[products.length]);
		productDao.deleteProductsWithBatchSize(batchSize, array);
	}

}
