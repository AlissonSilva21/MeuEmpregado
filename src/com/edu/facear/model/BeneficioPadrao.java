package com.edu.facear.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="BeneficioPadrao", catalog="MeuEmpregado")
public class BeneficioPadrao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	
	private Integer id;
	private double descReal,valorBeneficio;
	private float descPorCento;
	//private Funcionario funcionario;
	
	@OneToOne
	private Beneficio beneficio;
	@OneToMany
	private BeneficioPeriodo beneficioPeriodo;
	
	public BeneficioPadrao(Integer id){
		this.id=id;
	}
	public BeneficioPadrao(Beneficio beneficio, Integer id, double descReal, double valorBeneficio, float descPorCento, BeneficioPeriodo beneficioPeriodo) {		
		this.beneficio = beneficio;
		this.id = id;
		this.descReal = descReal;
		this.valorBeneficio = valorBeneficio;
		this.descPorCento = descPorCento;
		this.beneficioPeriodo = beneficioPeriodo;
	}
	
	public Beneficio getBeneficio() {
		return beneficio;
	}
	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getDescReal() {
		return descReal;
	}
	public void setDescReal(double descReal) {
		this.descReal = descReal;
	}
	public double getValorBeneficio() {
		return valorBeneficio;
	}
	public void setValorBeneficio(double valorBeneficio) {
		this.valorBeneficio = valorBeneficio;
	}
	public float getDescPorCento() {
		return descPorCento;
	}
	public void setDescPorCento(float descPorCento) {
		this.descPorCento = descPorCento;
	}
	public BeneficioPeriodo getBeneficioPeriodo() {
		return beneficioPeriodo;
	}
	public void setBeneficioPeriodo(BeneficioPeriodo beneficioPeriodo) {
		this.beneficioPeriodo = beneficioPeriodo;
	}
	
	

}
