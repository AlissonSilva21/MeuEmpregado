package com.edu.facear.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.edu.facear.dao.BeneficioDAO;
import com.edu.facear.dao.BeneficioLancamentoDAO;
import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioLancamento;
import com.edu.facear.model.BeneficioPadrao;

public class BeneficioLancamentoService {
	
	
	private BeneficioLancamentoDAO dao;
	
	
	public BeneficioLancamentoService() {
		dao = new BeneficioLancamentoDAO();
	}
	
	
	public boolean cadastrar (Integer id, Date data, ArrayList<BeneficioPadrao> beneficiosPadrao) {		
		
		BeneficioLancamento beneficioLancamento = new BeneficioLancamento(id, data, beneficiosPadrao);
				
		return dao.cadastrar(beneficioLancamento);
	}
	
	
	public boolean atualizar (Integer id, Date data, ArrayList<BeneficioPadrao> beneficiosPadrao) {		
		
		BeneficioLancamento beneficioLancamento = new BeneficioLancamento(id, data, beneficiosPadrao);
				
		return dao.atualizar(beneficioLancamento);
	}
	
	
	public List<BeneficioLancamento> listar () {
		
		return dao.listar();
	}
	
	
	public boolean deletar (Integer id) {
			
		return dao.deletar(id);
	}

}
