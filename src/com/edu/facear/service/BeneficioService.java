package com.edu.facear.service;

import java.util.List;

import com.edu.facear.dao.BeneficioDAO;
import com.edu.facear.dao.BeneficioLancamentoDAO;
import com.edu.facear.model.Beneficio;


public class BeneficioService {
	
	private BeneficioDAO dao;
	
	public BeneficioService() {
		dao = new BeneficioDAO();
	}
	
	public boolean cadastrar(Integer id, String descricao) {		
		
		Beneficio beneficio = new Beneficio(id,descricao);		
		return dao.cadastrar(beneficio);
	}
	
	public boolean atualizar (Integer id, String descricao) {	
		
		Beneficio beneficio=new Beneficio(id, descricao);
		return dao.atualizar(beneficio);
	}
	
	public List<Beneficio> listar () {
		
		return dao.listar();
	}
	public int proxId(){
		int id;
		id=dao.proxId();
		return id;
	}
	public boolean deletar (Integer id) {
			
		return dao.deletar(id);
	}

}
