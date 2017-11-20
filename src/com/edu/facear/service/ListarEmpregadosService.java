package com.edu.facear.service;

import java.util.List;

import com.edu.facear.dao.ListarEmpregadosDAO;
import com.edu.facear.model.Empregado;


public class ListarEmpregadosService {
	LoginService serviceLogin = new LoginService();
	ListarEmpregadosDAO dao = new ListarEmpregadosDAO();
	
	public List<Empregado> listarEmpregados() {
		return dao.listarEmpregados();
	}
}