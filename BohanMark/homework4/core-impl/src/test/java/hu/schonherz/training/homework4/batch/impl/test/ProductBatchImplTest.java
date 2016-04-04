package hu.schonherz.training.homework4.batch.impl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import hu.schonherz.training.homework4.batch.ProductBatch;
import hu.schonherz.training.homework4.batch.impl.ProductBatchImpl;
import hu.schonherz.training.homework4.dao.ProductDao;
import hu.schonherz.training.homework4.dao.impl.ProductDaoImpl;
import hu.schonherz.training.homework4.dto.Product;

@SuppressWarnings("javadoc")
public class ProductBatchImplTest {

	private ProductBatch productBatch;
	private List<Product> products;
	private ProductDao productDao;
	
	private static final int TESTSIZE = 10;
	
	public ProductBatchImplTest() {
		productBatch = new ProductBatchImpl();
		products = new ArrayList<Product>();
		productDao = new ProductDaoImpl();
	}
	
	
	public void generateProducts(){
		Random random = new Random();
		
		for(int i = 0; i < TESTSIZE; ++i){
			Product product = new Product();
			product.setName("test" + random.nextInt());
			Integer price = Math.abs(random.nextInt());
			product.setPrice(price);
			products.add(product);
		}
		
	}
	@Test
	public void testInsertAndDeleteProducts() {
		generateProducts();
		Integer oldsize = productDao.getAllProducts().size();
		productBatch.insertProducts(products);
		Assert.assertEquals(oldsize+TESTSIZE, productDao.getAllProducts().size());
		
		List<Integer> productIds = new ArrayList<Integer>();
		for(int i = 0; i < TESTSIZE; ++i) {
			productIds.add(productDao.findProductByName(products.get(i).getName()).getId());
		}
		
		productBatch.deleteProducts(productIds);
		
		Assert.assertEquals(oldsize, (Integer)productDao.getAllProducts().size());
		
		
	}

}
