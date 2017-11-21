package com.edu.facear.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.edu.facear.dao.BeneficioDAO;
import com.edu.facear.dao.BeneficioLancamentoDAO;
import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioLancamento;
import com.edu.facear.model.BeneficioPadrao;
import com.edu.facear.model.Empregado;
import com.edu.facear.model.Empregador;

public class BeneficioLancamentoService {
	
	
	private BeneficioLancamentoDAO dao;
	
	
	public BeneficioLancamentoService() {
		dao = new BeneficioLancamentoDAO();
	}
	
	
	public boolean cadastrar (String data,boolean status, Empregado empregado,Empregador empregador) {		
		
		BeneficioLancamento beneficioLancamento = new BeneficioLancamento(data,status,empregado,empregador);
				
		return dao.cadastrar(beneficioLancamento);
	}
	
	
	public boolean atualizar (Integer id, String data,boolean status, Empregado empregado,Empregador empregador) {		
		
		BeneficioLancamento beneficioLancamento = new BeneficioLancamento(id, data, status,empregado,empregador);
				
		return dao.atualizar(beneficioLancamento);
	}
	
	
	public List<BeneficioLancamento> listar () {
		
		return dao.listar();
	}
	
	public List<BeneficioLancamento> listaProEmpregador(){
		return dao.listarPorEmpregador();
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
