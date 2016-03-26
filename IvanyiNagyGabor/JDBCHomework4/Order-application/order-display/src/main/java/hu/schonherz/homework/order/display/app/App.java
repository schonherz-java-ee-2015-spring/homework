package hu.schonherz.homework.order.display.app;

import java.sql.SQLException;
import java.util.List;

import hu.schonherz.homework.order.metadata.MetaData;
import hu.schonherz.homework.order.service.OrderService;
import hu.schonherz.homework.order.service.ProductService;
import hu.schonherz.homework.order.service.UserService;
import hu.schonherz.homework.order.service.impl.OrderServiceImpl;
import hu.schonherz.homework.order.service.impl.ProductServiceImpl;
import hu.schonherz.homework.order.service.impl.UserServiceImpl;
import hu.schonherz.homework.order.vo.OrderVo;
import hu.schonherz.homework.order.vo.ProductVo;

public class App {

	private static UserService userService = null;
	private static ProductService productService = null;
	private static OrderService orderService = null;

	static {
		try {
			userService = new UserServiceImpl();
			productService = new ProductServiceImpl();
			orderService = new OrderServiceImpl();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String[] productNames = { "Alma", "Banan", "Citrom", "Dinnye", "Elefant", "Roka", "Teknos" };
		ProductVo[] productArray = new ProductVo[productNames.length];

		// Init the productArray
		for (int i = 0; i < productNames.length; ++i) {
			productArray[i] = new ProductVo();
			productArray[i].setId(1000 + i);
			productArray[i].setName(productNames[i]);
			productArray[i].setPrice(i * 100 + 1);
		}

		try {
			// print Metadata
			System.out.println("Metadata information:\n");
			MetaData.printMetaData();
			System.out.println("\n\n");

			// first user's all order
			List<OrderVo> orders = orderService.getOrdersByUserId(1);
			System.out.println("\n\nFirst user's orders:");
			orders.forEach(System.out::println);
			System.out.println("\n\n");

			// Print all user
			System.out.println("All user:");
			userService.getAllUser().forEach(System.out::println);
			System.out.println("\n\n");
			
			// Print all product
			 System.out.println("All product:");
			 productService.getAllProduct().forEach(System.out::println);
			 System.out.println("\n\n");

			// Print all order
			System.out.println("All order:");
			orderService.getAllOrder().forEach(System.out::println);
			System.out.println("\n\n");

			// Add 7 products
			System.out.println("After adding 7 products...");
			productService.addProductsWithBatchSize(5, productArray);
			// Print the result:
			productService.getAllProduct().forEach(System.out::println);
			
			// Delete 7 products
			System.out.println("\n\nAfter deleting 7 products...");
			productService.deleteProductsWithBatchSize(5, productArray);
			// Print the result:
			productService.getAllProduct().forEach(System.out::println);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
