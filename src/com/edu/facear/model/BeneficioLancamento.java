package com.edu.facear.model;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BeneficioLancamento", catalog="MeuEmpregado")
public class BeneficioLancamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	private Integer id;
	private Date data;
	
	@ManyToOne
	private Empregado empregado;
	@Column
	@ElementCollection(targetClass=BeneficioPadrao.class)
	private ArrayList<BeneficioPadrao> beneficiosPadrao;
	
	
	private boolean status;
	
	public boolean isStatus() {
		return status;
	}
	public BeneficioLancamento(Integer id){
		this.id=id;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

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
