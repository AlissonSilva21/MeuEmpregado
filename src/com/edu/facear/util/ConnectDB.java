package com.edu.facear.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class ConnectDB {
	
	private Connection con;
	private String driver, url, username,password;
	
	public ConnectDB(){
		driver = "com.mysql.jdbc.Driver";
		
		url = "jdbc:mysql://localhost:3306/MeuEmpregado";
		username = "root";
		password = "";
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		this.con = (Connection) DriverManager.getConnection(url,username,password);
		return this.con;	
	}
	

}
