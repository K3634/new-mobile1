package com.codewithkrish.newmobile.dao;

import java.sql.Connection;
import com.codewithkrish.newmobile.model.Order;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;





public class OrderDao {
	
 public static boolean insertOrder(Order model) throws ClassNotFoundException, SQLException {
    	DbConnector connector = new DbConnectorImplMySql();
		Connection connection =connector.getConnection();
		
		    String query = "insert into orders(p_id, o_quantity,o_date) values(?,?,?)";
		    PreparedStatement ps = connection.prepareStatement(query);
    		ps = connection.prepareStatement(query);
            ps.setInt(1, model.getId());
            ps.setInt(2, model.getQuantity());
            ps.setString(3, model.getDate());
    	    //ps.executeQuery();
    	    //result = true;
    	    
    	    boolean result = ps.executeUpdate() > 0;
    		ps.close();
    		connection.close();
    		return result;
            
    		
     }
}
