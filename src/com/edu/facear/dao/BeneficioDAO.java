package com.edu.facear.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.edu.facear.model.Beneficio;


public class BeneficioDAO{
	private PreparedStatement ps;
	EntityManagerFactory emf = GenericDAO.getInstance();
	
	public List<Beneficio> listar() {
		EntityManager em = GenericDAO.getInstance().createEntityManager();
		return em.createQuery("FROM " + Beneficio.class.getName()).getResultList();
	}
	public boolean deletar(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Beneficio ben=new Beneficio(id);
		ben = em.find(Beneficio.class,ben.getId());
		em.remove(ben);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public boolean cadastrar(Beneficio beneficio) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(beneficio);
		em.getTransaction().commit();
		
		em.close();
		return true; 
	}

	public boolean atualizar(Beneficio beneficio) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        em.merge(beneficio);
        em.getTransaction().commit();
		return true;
	}

}
