package com.edu.facear.dao;

import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioLancamento;
import com.edu.facear.model.BeneficioPadrao;
import com.edu.facear.model.BeneficioPeriodo;
import com.mysql.jdbc.Statement;




public class BeneficioLancamentoDAO{
	EntityManagerFactory emf = Conexao.getInstance();
	
	public List<BeneficioLancamento> listar() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("from BeneficioLancamento");
		return q.getResultList();
	}
	

	public boolean deletar(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		BeneficioLancamento ben=new BeneficioLancamento(id);
		ben = em.find(BeneficioLancamento.class,ben.getId());
		em.remove(ben);
		em.getTransaction().commit();
		em.close();
		return true;

	}

	public boolean cadastrar(BeneficioLancamento beneficioLancamento) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(beneficioLancamento);
		em.getTransaction().commit();
		
		em.close();
		return true;
	}

	public boolean atualizar(BeneficioLancamento beneficioLancamento) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        em.merge(beneficioLancamento);
        em.getTransaction().commit();
		return true;
	}
	public int proxId(){
		int id;
		EntityManager em = Conexao.getInstance().createEntityManager();
		ArrayList<BeneficioLancamento> lista=new ArrayList<BeneficioLancamento>();
		lista.addAll(em.createQuery("FROM " + BeneficioLancamento.class.getName()).getResultList());
		id=lista.get(lista.size()-1).getId()+1;
		return id;
	}
}
