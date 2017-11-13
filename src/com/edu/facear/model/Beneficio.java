package com.edu.facear.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Beneficio", catalog="MeuEmpregado")
public class Beneficio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
	
	
	public Beneficio(Integer id){
		this.id=id;
	}
	public Beneficio(){}
	public Beneficio(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	public Beneficio(String descricao){
		this.descricao = descricao;
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
