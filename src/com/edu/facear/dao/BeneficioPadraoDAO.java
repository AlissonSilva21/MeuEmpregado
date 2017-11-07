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
import com.edu.facear.model.BeneficioPadrao;
import com.edu.facear.model.BeneficioPeriodo;




public class BeneficioPadraoDAO{
	EntityManagerFactory emf = GenericDAO.getInstance();
	public List<BeneficioPadrao> listar() {
		EntityManager em = GenericDAO.getInstance().createEntityManager();
		return em.createQuery("FROM " + BeneficioPadrao.class.getName()).getResultList();
	}
	

	public boolean deletar(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		BeneficioPadrao ben=new BeneficioPadrao(id);
		ben = em.find(BeneficioPadrao.class,ben.getId());
		em.remove(ben);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public boolean cadastrar(BeneficioPadrao beneficioPadrao) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(beneficioPadrao);
		em.getTransaction().commit();
		
		em.close();
		return true;
	}

	public boolean atualizar(BeneficioPadrao beneficioPadrao) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        em.merge(beneficioPadrao);
        em.getTransaction().commit();
		return true;
	}

	

}
