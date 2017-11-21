package com.edu.facear.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BeneficioLancamento", catalog="MeuEmpregado")
public class BeneficioLancamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	private Integer id;
	private String data;
	
	@OneToOne
	@JoinColumn(name="idEmpregado")
	private Empregado empregado;
	
	@OneToOne
	@JoinColumn(name="idEmpregador")
	private Empregador empregador;

	private boolean status;
	
	public BeneficioLancamento(){}
	
	public BeneficioLancamento(String data, boolean status, Empregado empregado,Empregador empregador) {
		this.data = data;
		this.status=status;
		this.empregado=empregado;
		this.empregador=empregador;
	}
	
	public BeneficioLancamento(Integer id, String data, boolean status, Empregado empregado,Empregador empregador) {
		this.id = id;
		this.data = data;
		this.status=status;
		this.empregado=empregado;
		this.empregador=empregador;
	}
	
	
	public boolean isStatus() {
		return status;
	}
	public BeneficioLancamento(Integer id){
		this.id=id;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	public Empregador getEmpregador() {
		return empregador;
	}

	public void setEmpregador(Empregador empregador) {
		this.empregador = empregador;
	}
}