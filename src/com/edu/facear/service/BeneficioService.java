package com.edu.facear.service;

import java.util.List;

import com.edu.facear.dao.BeneficioDAO;
import com.edu.facear.dao.BeneficioLancamentoDAO;
import com.edu.facear.model.Beneficio;
import com.edu.facear.model.Empregador;


public class BeneficioService {
	
	private BeneficioDAO dao;
	
	public BeneficioService() {
		dao = new BeneficioDAO();
	}
	
	public boolean cadastrar(String descricao,Empregador empregador) {		
		
		Beneficio beneficio = new Beneficio(descricao,empregador);		
		return dao.cadastrar(beneficio);
	}
	
	public boolean atualizar (Integer id, String descricao,Empregador empregador) {	
		
		Beneficio beneficio=new Beneficio(id, descricao,empregador);
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
