package com.codewithkrish.newmobile.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnector {
  
	public Connection getConnection() throws ClassNotFoundException , SQLException;
}
