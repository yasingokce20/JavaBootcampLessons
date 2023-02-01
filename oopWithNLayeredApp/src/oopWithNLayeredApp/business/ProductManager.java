package oopWithNLayeredApp.business;

import oopWithNLayeredApp.entities.Product;

import java.util.List;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.*;

public class ProductManager {
	
	private ProductDao productDao;
	private Logger[] loggers ;                                                        // Logger [] = List<Logger>  aynı şey 
	
	public ProductManager(ProductDao productDao , Logger[] loggers) {

		this.productDao = productDao;
		this.loggers = loggers;
	}



	public void add(Product product) throws Exception {                                 // iş kuralları    // şu an kötü kodlarla yazıldı
		
	
		
		if(product.getUnitPrice()<10) {
			throw new Exception("Ürün fiyatı 10 dan küçük olamaz");
		}
		
		
		
		// ProductDao productDao = new JdbcProductDao();
		productDao.add(product);
		
		for (Logger logger : loggers) { // [db.mail]
			logger.log(product.getName());
		}
		
	}
	
	
	
	
}
  