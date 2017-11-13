package com.edu.facear.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioLancado;
import com.edu.facear.model.BeneficioLancamento;
import com.edu.facear.model.BeneficioPeriodo;


public class BeneficioLancadoDAO {
	EntityManagerFactory emf = Conexao.getInstance();
	public List<BeneficioLancado> listar() {
		EntityManager em = Conexao.getInstance().createEntityManager();
		return em.createQuery("FROM "+BeneficioLancado.class.getName()).getResultList();
		
		
	}
	public boolean deletar(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		BeneficioLancado ben=new BeneficioLancado(id);
		ben = em.find(BeneficioLancado.class,ben.getId());
		em.remove(ben);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public boolean cadastrar(BeneficioLancado beneficio) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(beneficio);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public boolean atualizar(BeneficioLancado beneficio) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        em.merge(beneficio);
        em.getTransaction().commit();
		 
		return true;
	}
	public int proxId(){
		int id;
		EntityManager em = Conexao.getInstance().createEntityManager();
		ArrayList<BeneficioLancado> lista=new ArrayList<BeneficioLancado>();
		lista.addAll(em.createQuery("FROM " + BeneficioLancado.class.getName()).getResultList());
		id=lista.get(lista.size()-1).getId()+1;
		return id;
	}

}
