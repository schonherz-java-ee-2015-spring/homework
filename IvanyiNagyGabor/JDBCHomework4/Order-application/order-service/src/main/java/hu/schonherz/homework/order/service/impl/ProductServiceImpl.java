package hu.schonherz.homework.order.service.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import hu.schonherz.homework.order.connection.impl.PostgreSqlConnectionHandler;
import hu.schonherz.homework.order.dao.ProductDao;
import hu.schonherz.homework.order.dao.impl.ProductDaoImpl;
import hu.schonherz.homework.order.dto.Product;
import hu.schonherz.homework.order.service.ProductService;
import hu.schonherz.homework.order.service.mapper.ProductMapper;
import hu.schonherz.homework.order.vo.ProductVo;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	public ProductServiceImpl() throws SQLException {
		this.productDao = new ProductDaoImpl(PostgreSqlConnectionHandler.getInstance().getConnection());
	}

	@Override
	public List<ProductVo> getAllProduct() {
		List<Product> products = productDao.getAllProducts();
		return ProductMapper.toVo(products);
	}

	@Override
	public void addProductsWithBatchSize(Integer batchSize, ProductVo... products) {
		Product[] array = ProductMapper.toDto(Arrays.asList(products)).toArray(new Product[products.length]);
		productDao.addProductsWithBatchSize(batchSize, array);		
	}

	@Override
	public void deleteProductsWithBatchSize(Integer batchSize, ProductVo... products) {
		Product[] array = ProductMapper.toDto(Arrays.asList(products)).toArray(new Product[products.length]);
		productDao.deleteProductsWithBatchSize(batchSize, array);
	}

}
