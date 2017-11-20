package com.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.edu.facear.model.Empregado;
import com.edu.facear.model.Empregador;


public class LoginDAO {
	EntityManagerFactory emf = Conexao.getInstance();
	
	public List<Empregado> loginEmpregado(String email, String senha){
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("select e from Empregado e where e.email = ? and e.senha = ?");
		q.setParameter(0, email);
		q.setParameter(1, senha);
		
		List<Empregado> listaEmpregado = q.getResultList();
		
		em.getTransaction().commit();
		return listaEmpregado;
	}
	
	public List<Empregador> loginEmpregador(String email, String senha){
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("select e from Empregador e where e.email = ? and e.senha = ?");
		q.setParameter(0, email);
		q.setParameter(1, senha);
		
		List<Empregador> listaEmpregador = q.getResultList();
		
		em.getTransaction().commit();
		return listaEmpregador;
	}
	
}
