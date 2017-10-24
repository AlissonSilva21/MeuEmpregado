package com.edu.facear.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.edu.facear.util.ConnectDB;





public class GenericDAO {
	private ConnectDB db = new ConnectDB();
	protected Connection connect;
	
	public void openConnection() throws ClassNotFoundException, SQLException {
		connect = db.getConnection();
	}
	
	public void closeConnection() {
		if(connect!=null) {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
