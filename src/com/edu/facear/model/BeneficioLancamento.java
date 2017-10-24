package com.edu.facear.model;

import java.sql.Date;
import java.util.ArrayList;


public class BeneficioLancamento {
	private Integer id;
	private Date data;
	//private Funcionario funcionario;
	ArrayList<BeneficioPadrao> beneficiosPadrao = new ArrayList<BeneficioPadrao>();
	
	public BeneficioLancamento(Integer id, Date data, ArrayList<BeneficioPadrao> beneficiosPadrao) {
		this.id = id;
		this.data = data;
		this.beneficiosPadrao = beneficiosPadrao;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public ArrayList<BeneficioPadrao> getBeneficiosPadrao() {
		return beneficiosPadrao;
	}
	public void setBeneficios(ArrayList<BeneficioPadrao> beneficiosPadrao) {
		this.beneficiosPadrao = beneficiosPadrao;
	}
	
	
	

}
