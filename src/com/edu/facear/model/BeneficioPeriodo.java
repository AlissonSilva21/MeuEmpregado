package com.edu.facear.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BeneficioPeriodo", catalog="MeuEmpregado")
public class BeneficioPeriodo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	
	private Integer id;
	private String descricao;
		
	public BeneficioPeriodo(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	public BeneficioPeriodo(Integer id){
		this.id=id;
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
	

}
