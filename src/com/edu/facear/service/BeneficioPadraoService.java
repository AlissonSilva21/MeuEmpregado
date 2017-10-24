package com.edu.facear.service;

import java.util.List;

import com.edu.facear.dao.BeneficioDAO;
import com.edu.facear.dao.BeneficioPadraoDAO;
import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioPadrao;
import com.edu.facear.model.BeneficioPeriodo;

public class BeneficioPadraoService {
	
	
	private BeneficioPadraoDAO dao;
	
	
	public BeneficioPadraoService() {
		dao = new BeneficioPadraoDAO();
	}
	
	
	public boolean cadastrar (Beneficio beneficio, Integer id, double descReal, double valorBeneficio, float descPorCento, BeneficioPeriodo beneficioPeriodo) {		
		
		BeneficioPadrao beneficioPadrao = new BeneficioPadrao(beneficio, id, descReal, valorBeneficio,  descPorCento, beneficioPeriodo);
				
		return dao.cadastrar(beneficioPadrao);
	}
	
	public boolean atualizar (Beneficio beneficio, Integer id, double descReal, double valorBeneficio, float descPorCento, BeneficioPeriodo beneficioPeriodo) {		
		
		BeneficioPadrao beneficioPadrao = new BeneficioPadrao(beneficio, id, descReal, valorBeneficio,  descPorCento, beneficioPeriodo);
				
		return dao.atualizar(beneficioPadrao);
	}
	
	
	public List<BeneficioPadrao> listar () {
		
		return dao.listar();
	}
	
	
	public boolean deletar (Integer id) {
			
		return dao.deletar(id);
	}

}
