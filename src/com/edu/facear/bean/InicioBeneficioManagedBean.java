package com.edu.facear.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.edu.facear.model.Beneficio;
import com.edu.facear.model.Empregado;
import com.edu.facear.service.BeneficioService;
import com.edu.facear.service.EmpregadoService;
import com.edu.facear.service.ListarEmpregadosService;

@ManagedBean(name = "inicioBeneficioManagedBean")
@SessionScoped
public class InicioBeneficioManagedBean implements Serializable {

	private static final long serialVersionUID = 58654561556L;

	private List<Empregado> listaEmpregados;
	
	private static Empregado empregadoAux;

	

	public InicioBeneficioManagedBean() {

		//ListarEmpregadosService empregadoService=new ListarEmpregadosService();
		EmpregadoService empregadoService=new EmpregadoService();
		listaEmpregados = empregadoService.listarEmpregados();
		System.out.println("find employee ...");
		
	}



	public List<Empregado> getListaEmpregados() {
		return listaEmpregados;
	}



	public void setListaEmpregados(List<Empregado> listaEmpregados) {
		this.listaEmpregados = listaEmpregados;
	}



	public Empregado getEmpregadoAux() {
		return empregadoAux;
	}



	public void setEmpregadoAux(Empregado empregadoAux) {
		this.empregadoAux = empregadoAux;
	}


}
