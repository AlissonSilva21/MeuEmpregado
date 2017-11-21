package com.edu.facear.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.edu.facear.dao.BeneficioDAO;
import com.edu.facear.dao.BeneficioPadraoDAO;
import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioLancamento;
import com.edu.facear.model.BeneficioPadrao;
import com.edu.facear.model.BeneficioPeriodo;
import com.edu.facear.model.Empregado;

public class BeneficioPadraoService {
	
	
	private BeneficioPadraoDAO dao;
	
	
	public BeneficioPadraoService() {
		dao = new BeneficioPadraoDAO();
	}
	
	
	public boolean cadastrar (double descReal, double valorBeneficio, float descPorCento, BeneficioPeriodo beneficioPeriodo,Beneficio beneficio,Empregado empregado) {		
		BeneficioPadrao beneficioPadrao = new BeneficioPadrao(descReal, valorBeneficio,  descPorCento, beneficioPeriodo,beneficio,empregado);
				
		return dao.cadastrar(beneficioPadrao);
	}
	
	public boolean atualizar(int id,double descReal, double valorBeneficio, float descPorCento, BeneficioPeriodo beneficioPeriodo,Beneficio beneficio,Empregado empregado) {		
		
		BeneficioPadrao beneficioPadrao = new BeneficioPadrao(id,descReal, valorBeneficio,  descPorCento, beneficioPeriodo,beneficio,empregado);
				
		return dao.atualizar(beneficioPadrao);
	}
	
	
	public List<BeneficioPadrao> listar () {
		
		return dao.listar();
	}
	
	public List<BeneficioPadrao> listarPorEmpregado(){
		return dao.listarPorEmpregado();
	}
	
	
	public boolean deletar (Integer id) {
			
		return dao.deletar(id);
	}
	public int proxId(){
		int id;
		id=dao.proxId();
		return id;
	}

}
