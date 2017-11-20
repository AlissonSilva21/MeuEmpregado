package com.edu.facear.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Beneficio", catalog="MeuEmpregado")
public class Beneficio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEmpregador")
	private Empregador empregador;
	
	public Beneficio(Integer id){
		this.id=id;
	}
	public Beneficio(){}
	public Beneficio(Integer id, String descricao,Empregador empregador) {
		this.id = id;
		this.descricao = descricao;
		this.empregador=empregador;
	}
	public Beneficio(String descricao,Empregador empregador){
		this.descricao = descricao;
		this.empregador=empregador;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Empregador getEmpregador() {
		return empregador;
	}
	public void setEmpregador(Empregador empregador) {
		this.empregador = empregador;
	}
}	
