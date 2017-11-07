package com.edu.facear.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioLancamento;
import com.edu.facear.model.BeneficioPeriodo;

public class BeneficioPeriodoDAO{
	EntityManagerFactory emf = GenericDAO.getInstance();

	public List<BeneficioPeriodo> listar() {
		EntityManager em = GenericDAO.getInstance().createEntityManager();
		return em.createQuery("FROM " + BeneficioPeriodo.class.getName()).getResultList();
	}
	

	public boolean deletar(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		BeneficioPeriodo ben=new BeneficioPeriodo(id);
		ben = em.find(BeneficioPeriodo.class,ben.getId());
		em.remove(ben);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public boolean cadastrar(BeneficioPeriodo beneficioPeriodo) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(beneficioPeriodo);
		em.getTransaction().commit();
		
		em.close();
		return true;
	}

	public boolean atualizar(BeneficioPeriodo beneficioPeriodo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        em.merge(beneficioPeriodo);
        em.getTransaction().commit();
		return true;
	}

}
