package com.codewithkrish.newmobile.service;

import java.sql.SQLException;

import java.util.List;

import com.codewithkrish.newmobile.dao.SalesagentsDao;
import com.codewithkrish.newmobile.model.Salesagents;





public class SalesagentService {
	
   public  Salesagents getTheSalesagentsBysId(int sId) throws ClassNotFoundException, SQLException {
		
		return SalesagentsDao.getTheSalesagentsBysId(sId);
	}
	
    public List<Salesagents> getAllSalesagent() throws ClassNotFoundException, SQLException{
		
		return SalesagentsDao.getAllSalesagent();
	}
	
	public  boolean addSalesagent(Salesagents salesagent) throws ClassNotFoundException, SQLException {
		
		return SalesagentsDao.addSalesagent(salesagent);
	}
	
	public  boolean updateSalesagent(Salesagents salesagent) throws ClassNotFoundException, SQLException {
		
		return SalesagentsDao.updateSalesagent(salesagent);
	}
	
	public  boolean deleteSalesagent(int sId) throws ClassNotFoundException, SQLException {
		
		return SalesagentsDao.deleteSalesagent(sId);
	}
}
