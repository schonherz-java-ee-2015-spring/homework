package hu.schonherz.homework.order.display.app;

import java.sql.SQLException;

import hu.schonherz.homework.order.metadata.MetaData;
import hu.schonherz.homework.order.service.ProductService;
import hu.schonherz.homework.order.service.impl.ProductServiceImpl;
import hu.schonherz.homework.order.vo.ProductVo;

public class Main {
	public static void main(String[] args) {
		
		ProductVo[] array = new ProductVo[] {
			new ProductVo(17, "ABCh", 200),
			new ProductVo(18, "DEFh", 200),
			new ProductVo(19, "GHIh", 200),
			new ProductVo(20, "JKLh", 200)
		};
	
		
		
		try {
			ProductService service = new ProductServiceImpl();
			MetaData.printMetaData();
////			service.addProductsWithBatchSize(3, array);
//			service.deleteProductsWithBatchSize(7, array);
//			service.getAllProduct().forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
