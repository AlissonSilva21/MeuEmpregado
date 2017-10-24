package com.edu.facear.model;

public class Beneficio {
	private Integer id;
	private String descricao;
	
	
	
	
	public Beneficio(Integer id, String descricao) {
		this.id = id;
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
