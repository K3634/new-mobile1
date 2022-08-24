package com.codewithkrish.newmobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithkrish.newmobile.model.Salesagents;


public class SalesagentsDao {

  public static Salesagents getTheSalesagentsBysId(int sId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection =connector.getConnection();
		
		//String query ="Select * from users where userID = " + userID ;
		//Statement st = connection.createStatement();
		//ResultSet rs = st.executeQuery(query);
		
		String query ="Select * from salesAgents where sId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, sId);
		
		ResultSet rs = ps.executeQuery();
		
		Salesagents salesagent = new Salesagents();;
		if(rs.next()) {
			 
			salesagent.setsId(rs.getInt("sId"));
			salesagent.setsName(rs.getString("sName"));
			salesagent.setsAddress(rs.getString("sAddress"));
			salesagent.setMobileNo(rs.getString("mobileNo"));
			salesagent.setBranch(rs.getString("branch"));
					}
		
		ps.close();
		connection.close();
		return salesagent;
	}
	
	
	public static List<Salesagents> getAllSalesagent() throws ClassNotFoundException, SQLException {

		
		  DbConnector connector = new DbConnectorImplMySql(); 
		  Connection connection=connector.getConnection();
		
		 String query = "Select * from salesAgents"; 
		 Statement st =connection.createStatement(); ResultSet rs = st.executeQuery(query);
		  List<Salesagents> salesagents = new ArrayList();
		  while(rs.next()) 
		  { Salesagents salesagent = new Salesagents(rs.getInt("sId"),
		  rs.getString("sName"),rs.getString("sAddress"),rs.getString("mobileNo"),rs.
		  getString("branch")); salesagents.add(salesagent);
         }
		  
		  st.close(); 
		  connection.close(); 
		  return salesagents;
		
		
	}

	public static boolean addSalesagent(Salesagents salesagent) throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();

		String query = "Insert into salesAgents (sName,sAddress,mobileNo,branch) values (?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, salesagent.getsName());
		ps.setString(2, salesagent.getsAddress());
		ps.setString(3, salesagent.getMobileNo());
		ps.setString(4, salesagent.getBranch());

		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}

	public static boolean updateSalesagent(Salesagents salesagent) throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();

		String query = "Update salesAgents set sName=?, sAddress=?, mobileNo=?, branch=? where sId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, salesagent.getsName());
		ps.setString(2, salesagent.getsAddress());
		ps.setString(3, salesagent.getMobileNo());
		ps.setString(4, salesagent.getBranch());
		ps.setInt(5, salesagent.getsId());

		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}

	public static boolean deleteSalesagent(int sId) throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();

		String query = "Delete from salesAgents where sId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, sId);

		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
}
