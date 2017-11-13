package com.edu.facear.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BeneficioLancado", catalog="MeuEmpregado")
public class BeneficioLancado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	private Integer id;
	private Double valor;
	private Double descontoReal;
	private Float descontoPorCento;
	
	@OneToOne
	@JoinColumn(name="idBeneficio")
	private Beneficio beneficio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idbeneficioPeriodo")
	private BeneficioPeriodo beneficioPeriodo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idbeneficioLancamento")
	private BeneficioLancamento beneficioLancamento;
	
	public BeneficioLancado(){}
	public BeneficioLancado(int id){
		this.id=id;
	}
	public BeneficioLancado(Double valor,Double descReal,Float descPorCent,Beneficio beneficio,BeneficioPeriodo beneficioPeriodo,BeneficioLancamento beneficioLancamento ){
		this.valor=valor;
		this.descontoReal=descReal;
		this.descontoPorCento=descPorCent;
		this.beneficio=beneficio;
		this.beneficioLancamento=beneficioLancamento;
		this.beneficioPeriodo=beneficioPeriodo;
	}
	
	public BeneficioLancado(Integer id,Double valor,Double descReal,Float descPorCent,Beneficio beneficio,BeneficioPeriodo beneficioPeriodo,BeneficioLancamento beneficioLancamento ){
		this.id=id;
		this.valor=valor;
		this.descontoReal=descReal;
		this.descontoPorCento=descPorCent;
		this.beneficio=beneficio;
		this.beneficioLancamento=beneficioLancamento;
		this.beneficioPeriodo=beneficioPeriodo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getDescontoReal() {
		return descontoReal;
	}
	public void setDescontoReal(Double descontoReal) {
		this.descontoReal = descontoReal;
	}
	public Float getDescontoPorCento() {
		return descontoPorCento;
	}
	public void setDescontoPorCento(Float descontoPorCento) {
		this.descontoPorCento = descontoPorCento;
	}
	public Beneficio getBeneficio() {
		return beneficio;
	}
	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}
	public BeneficioPeriodo getBeneficioPeriodo() {
		return beneficioPeriodo;
	}
	public void setBeneficioPeriodo(BeneficioPeriodo beneficioPeriodo) {
		this.beneficioPeriodo = beneficioPeriodo;
	}
	public BeneficioLancamento getBeneficioLancamento() {
		return beneficioLancamento;
	}
	public void setBeneficioLancamento(BeneficioLancamento beneficioLancamento) {
		this.beneficioLancamento = beneficioLancamento;
	}
}
