package com.edu.facear.service;

import java.util.List;

import com.edu.facear.dao.BeneficioDAO;
import com.edu.facear.dao.PeriodoDAO;
import com.edu.facear.model.Beneficio;
import com.edu.facear.model.Periodo;

public class PeriodoService {
	
	
	private PeriodoDAO dao;
	
	
	public PeriodoService() {
		dao = new PeriodoDAO();
	}
	

	public List<Periodo> listar () {
		
		return null;//dao.listar();
	}


}
