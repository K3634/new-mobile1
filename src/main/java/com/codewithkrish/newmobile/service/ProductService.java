package com.codewithkrish.newmobile.service;

import java.sql.SQLException;


import com.codewithkrish.newmobile.dao.ProductDao;
import com.codewithkrish.newmobile.model.Product;





public class ProductService {

	
	public  boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
		
		return ProductDao.addProduct(product);
	}
}
