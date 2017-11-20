//Implementando FACADE

package com.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.edu.facear.model.Empregado;
import com.edu.facear.util.HibernateUtil;
import com.edu.facear.util.EmpregadoFacade;

public class EmpregadoDAO implements EmpregadoFacade<Empregado>{

	EntityManagerFactory emf = HibernateUtil.getInstance();
	
	@Override
	public void cadastrar(Empregado t) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void alterar(Empregado t) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Empregado> listar() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("from Empregado");
		return q.getResultList();
	}

	@Override
	public Empregado filtrarEmpregado(Integer id) {
		Empregado empregado = new Empregado();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		empregado = em.find(Empregado.class, id);
		em.getTransaction().commit();
		em.close();
		return empregado;
	}
	
	@Override
	public Empregado filtrarEmpregadoNome(String nome_completo) {
		Empregado empregado = new Empregado();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		empregado = em.find(Empregado.class, nome_completo);
		em.getTransaction().commit();
		em.close();
		return empregado;
	}
}
