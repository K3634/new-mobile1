package com.codewithkrish.newmobile.service;


import java.sql.SQLException;



import com.codewithkrish.newmobile.dao.OrderDao;
import com.codewithkrish.newmobile.model.Order;
import com.codewithkrish.newmobile.model.User;

public class OrderService {
public  boolean insertOrder(Order model) throws ClassNotFoundException, SQLException {
		
	return OrderDao.insertOrder(model);
	}
}