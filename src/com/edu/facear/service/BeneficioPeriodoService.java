package com.edu.facear.service;

import java.util.List;

import com.edu.facear.dao.BeneficioDAO;
import com.edu.facear.dao.BeneficioPeriodoDAO;
import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioPeriodo;

public class BeneficioPeriodoService {
	
	
	private BeneficioPeriodoDAO dao;
	
	
	public BeneficioPeriodoService() {
		dao = new BeneficioPeriodoDAO();
	}
	
	
	public boolean cadastrar (Integer id, String descricao) {		
		
		BeneficioPeriodo beneficioPeriodo = new BeneficioPeriodo(id,descricao);
				
		return dao.cadastrar(beneficioPeriodo);
	}
	
	
	public boolean atualizar (Integer id, String descricao) {	
		
		BeneficioPeriodo beneficioPeriodo = new BeneficioPeriodo(id,descricao);
				
		return dao.atualizar(beneficioPeriodo);
	}
	
	
	public List<BeneficioPeriodo> listar () {
		
		return dao.listar();
	}
	
	
	public boolean deletar (Integer id) {
			
		return dao.deletar(id);
	}

}
