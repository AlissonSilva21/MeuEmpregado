//SINGLETON e Implementação do FACADE

package com.edu.facear.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.edu.facear.dao.EmpregadoDAO;
import com.edu.facear.model.Empregado;
import com.edu.facear.util.EmpregadoFacade;

public class EmpregadoService {

	private EmpregadoFacade<Empregado> eDao;
	
	public EmpregadoService() {
		eDao = new EmpregadoDAO();
	}
	
	public void cadastrarEmpregado(Empregado e) throws HibernateException{
		if(e!=null) {
			eDao.cadastrar(e);
		}else {
			System.out.println("Erro ao cadastrar");
		}
	}
	public void alterarEmpregado(Empregado e) throws HibernateException{
		if(e!=null) {
			eDao.alterar(e);
		}else {
			System.out.println("Erro ao alterar");
		}
	}
	public List<Empregado> listarEmpregados() throws HibernateException{
		return eDao.listar();
	}
	public Empregado filtrarEmpregado(Integer id) throws HibernateException{
		return eDao.filtrarEmpregado(id);
	}
	public Empregado filtrarEmpregadoNome(String nome_completo) throws HibernateException{
		return eDao.filtrarEmpregadoNome(nome_completo);
	}
}
