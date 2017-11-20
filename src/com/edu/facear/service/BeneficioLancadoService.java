package com.edu.facear.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.edu.facear.dao.BeneficioLancadoDAO;
import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioLancado;
import com.edu.facear.model.BeneficioLancamento;
import com.edu.facear.model.BeneficioPeriodo;
import com.edu.facear.model.Empregado;

public class BeneficioLancadoService {
	private BeneficioLancadoDAO dao;
	
	
	public BeneficioLancadoService() {
		dao = new BeneficioLancadoDAO();
	}
	
	
	public boolean cadastrar(Double valor,Double descReal,Float descPorCent,Beneficio beneficio,BeneficioPeriodo beneficioPeriodo,BeneficioLancamento beneficioLancamento) {		
		
		BeneficioLancado beneficioLancado = new BeneficioLancado(valor,descReal,descPorCent,beneficio,beneficioPeriodo,beneficioLancamento);
				
		return dao.cadastrar(beneficioLancado);
	}
	
	
	public boolean atualizar(Integer id,Double valor,Double descReal,Float descPorCent,Beneficio beneficio,BeneficioPeriodo beneficioPeriodo,BeneficioLancamento beneficioLancamento) {		
		
		BeneficioLancado beneficioLancado = new BeneficioLancado(id,valor,descReal,descPorCent,beneficio,beneficioPeriodo,beneficioLancamento);
				
		return dao.atualizar(beneficioLancado);
	}
	
	public List<BeneficioLancado> listar () {
		
		return dao.listar();
	}
/*	public List<BeneficioLancado> listarPorEmpregado(Empregado empregado) {
		
		return dao.listarPorEmpregado(empregado);
	}
	*/
	public boolean deletar (Integer id) {
			
		return dao.deletar(id);
	}
	public int proxId(){
		int id;
		id=dao.proxId();
		return id;
	}
}
