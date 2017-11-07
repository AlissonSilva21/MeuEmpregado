package com.edu.facear.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.edu.facear.util.ConnectDB;


public class GenericDAO {
	private static EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("TrabalhoArquitetura");
	
	private GenericDAO(){
		
	}

	public static EntityManagerFactory getInstance() {
		return emf;
	}
	
}
