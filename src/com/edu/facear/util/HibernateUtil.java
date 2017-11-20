package com.edu.facear.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeuEmpregado");

	public static EntityManagerFactory getInstance() {
		return emf;
	}
	
}
