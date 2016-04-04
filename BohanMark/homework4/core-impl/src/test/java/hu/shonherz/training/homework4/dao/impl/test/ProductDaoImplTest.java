package hu.shonherz.training.homework4.dao.impl.test;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.schonherz.training.homework4.dao.ProductDao;
import hu.schonherz.training.homework4.dao.impl.ProductDaoImpl;
import hu.schonherz.training.homework4.dto.Product;

@SuppressWarnings("javadoc")
public class ProductDaoImplTest {

	
	ProductDao productDao;
	
	@Before
	public void setUp() throws Exception {
		productDao = new ProductDaoImpl();
	}

	@Test
	public void testCreateAndFindProduct(){
		Product product = new Product();
		product.setName("test" + new Random().nextInt());
		Integer price = Math.abs(new Random().nextInt());
		product.setPrice(price);
		productDao.createProduct(product);
		
		Product producttest = productDao.findProductByName(product.getName());
		Assert.assertEquals(product.getPrice(), producttest.getPrice());
		
		Product producttest2 = productDao.findProductById(producttest.getId()); 
		
		Assert.assertEquals(producttest.getPrice(), producttest2.getPrice());
	}
	
	
	
	@Test
	public void testCreateProductAndGetAllProducts() {
		

		Integer productssize = productDao.getAllProducts().size();
		
		Product product = new Product();
		product.setName("test" + new Random().nextInt());
		product.setPrice(Math.abs(new Random().nextInt()));
		
		productDao.createProduct(product);
		
		Assert.assertEquals(productssize+1, productDao.getAllProducts().size());
	}

}
