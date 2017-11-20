package com.edu.facear.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.edu.facear.model.Beneficio;


public class BeneficioDAO{
	EntityManagerFactory emf = Conexao.getInstance();
	
	public List<Beneficio> listar() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("from Beneficio");
		return q.getResultList();
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
	public int proxId(){
		int id;
		EntityManager em = Conexao.getInstance().createEntityManager();
		ArrayList<Beneficio> lista=new ArrayList<Beneficio>();
		lista.addAll(em.createQuery("FROM " + Beneficio.class.getName()).getResultList());
		id=lista.get(lista.size()-1).getId()+1;
		return id;
	}
	

}
