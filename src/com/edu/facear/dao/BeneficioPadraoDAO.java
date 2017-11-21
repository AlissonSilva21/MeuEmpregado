package com.edu.facear.dao;

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
import com.edu.facear.service.LoginService;




public class BeneficioPadraoDAO{
	EntityManagerFactory emf = Conexao.getInstance();
	LoginService service = new LoginService();
	public List<BeneficioPadrao> listar() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("from BeneficioPadrao");
		return q.getResultList();
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
	public int proxId(){
		int id;
		EntityManager em = Conexao.getInstance().createEntityManager();
		ArrayList<BeneficioPadrao> lista=new ArrayList<BeneficioPadrao>();
		lista.addAll(em.createQuery("FROM " + BeneficioPadrao.class.getName()).getResultList());
		id=lista.get(lista.size()-1).getId()+1;
		return id;
	}
	public List<BeneficioPadrao> listarPorEmpregado(){
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("SELECT e FROM BeneficioPadrao m WHERE m.idEmpregado = ?");//select tb_empregado.*, tb_empregador.idEmpregador from tb_empregado inner join tb_mensagem on tb_empregado.id=tb_mensagem.idEmpregado inner join tb_empregador on tb_mensagem.idEmpregador=tb_empregador.idEmpregador where tb_empregador.idEmpregador = 2;
		q.setParameter(0, service.getIdEmpregadologin());
		
		em.getTransaction().commit();
		//em.close();
		
		return q.getResultList();
	}

}
