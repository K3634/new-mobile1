package com.codewithkrish.newmobile.dao;


import java.sql.*;
import java.util.*;

import com.codewithkrish.newmobile.model.Cart;
import com.codewithkrish.newmobile.model.Product;




public class ProductDao {
//	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
   
	
	public ProductDao() {
		super();
//		this.con = con;
	}
	
	
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection =connector.getConnection();
        List<Product> products = new ArrayList<Product>();
        try {

            query = "select * from products";
            pst = connection.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
            	Product row = new Product();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));

                products.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return products;
    }
	
	
	 public Product getSingleProduct(int id) throws ClassNotFoundException, SQLException {
		 DbConnector connector = new DbConnectorImplMySql();
		 Connection connection =connector.getConnection();
		 Product row = null;
	        try {
            query = "select * from products where id=? ";

	            pst =  connection.prepareStatement(query);
	            pst.setInt(1, id);
                rs = pst.executeQuery();

	            while (rs.next()) {
            	row = new Product();
	                row.setId(rs.getInt("id"));
	                row.setName(rs.getString("name"));
	                row.setCategory(rs.getString("category"));
	                row.setPrice(rs.getDouble("price"));
	                row.setImage(rs.getString("image"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
        }

	        return row;
	    }
	
	public double getTotalCartPrice(ArrayList<Cart> cartList) throws ClassNotFoundException, SQLException {
		 DbConnector connector = new DbConnectorImplMySql();
		 Connection connection =connector.getConnection();
		double sum = 0;
       try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select price from products where id=?";
                    pst = connection.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getDouble("price")*item.getQuantity();
                   }

               }
            }

        } catch (SQLException e) {
            e.printStackTrace();
           System.out.println(e.getMessage());
        }
        return sum;
    }

   
   public List<Cart> getCartProducts(ArrayList<Cart> cartList) throws ClassNotFoundException, SQLException {
	   DbConnector connector = new DbConnectorImplMySql();
		Connection connection =connector.getConnection();
	   List<Cart> products = new ArrayList<>();
       try {
           if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select * from products where id=?";
                    pst =connection.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                  while (rs.next()) {
                       Cart row = new Cart();
                       row.setId(rs.getInt("id"));
                       row.setName(rs.getString("name"));
                       row.setCategory(rs.getString("category"));
                       row.setPrice(rs.getDouble("price")*item.getQuantity());
                       row.setQuantity(item.getQuantity());
                       products .add(row);
                   }

               }
            }

       } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
      }
     return products ;
    }
   
   public static boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection =connector.getConnection();
		
		String query = "Insert into products (name,category,price,image) values (?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setString(2, product.getCategory());
		ps.setDouble(3, product.getPrice());
		ps.setString(4, product.getImage());
		
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	} 
   
	
}
