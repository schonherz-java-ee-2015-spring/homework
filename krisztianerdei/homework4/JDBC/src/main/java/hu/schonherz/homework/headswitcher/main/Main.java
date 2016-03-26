package hu.schonherz.homework.headswitcher.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.headswitcher.batcher.Batch;
import hu.schonherz.homework.headswitcher.meta.Metadata;
import hu.schonherz.homework.headswitcher.order.OrderDao;
import hu.schonherz.homework.headswitcher.order.OrderDaoImpl;
import hu.schonherz.homework.headswitcher.product.ProductDao;
import hu.schonherz.homework.headswitcher.product.ProductDaoImpl;
import hu.schonherz.homework.headswitcher.product.ProductWuId;
import hu.schonherz.homework.headswitcher.user.UserDao;
import hu.schonherz.homework.headswitcher.user.UserDaoImpl;


public class Main {
	public static void main(String[] args) {
		UserDao usr = new UserDaoImpl();
		ProductDao pdc = new ProductDaoImpl();
		OrderDao ord = new OrderDaoImpl();
		List <String> tables = new ArrayList<String>();
		
		//Metaadatoklekérése
		try {
			tables = Metadata.getTablesMetadata();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (String string : tables) {
			System.out.println(string);
		}
		try {
			Metadata.getColumnsMetadata(tables);
		} catch (SQLException e) {
			e.printStackTrace();
		}
////////////////////
		
		
		usr.getUserById(1); //PreparedStatement
		usr.getAllUserByCall(); //CallableStatement
		pdc.getProductsByCall(); //CallableStatement
		System.out.println(ord.getAllProduct()); //Statement
		
		List <ProductWuId> insert= new ArrayList<>();
		insert.add(new ProductWuId("Teszt1", 500));
		insert.add(new ProductWuId("Teszt2", 600));
		insert.add(new ProductWuId("Teszt3", 700));
		insert.add(new ProductWuId("Teszt4", 800));
		insert.add(new ProductWuId("Teszt5", 200));
		insert.add(new ProductWuId("Teszt6", 300));
		insert.add(new ProductWuId("Teszt7", 400));
		
		
		Batch.BatchInsertProducts(insert, 8); // batch insert
		
		List<Integer> ids= new ArrayList<>();
		ids.add(10);
		ids.add(11);
		ids.add(12);
		ids.add(13);
		ids.add(554);
		ids.add(110);
		ids.add(240);
		ids.add(10);
		ids.add(30);
		
		Batch.BatchDeleteProducts(ids, 8); // batchdelete 
 	}
}
