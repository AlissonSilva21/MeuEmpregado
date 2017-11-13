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
	private Date data;
	
	@OneToOne
	@JoinColumn(name="idEmpregado")
	private Empregado empregado;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<BeneficioPadrao> beneficioPadrao=new ArrayList<BeneficioPadrao>();
	private boolean status;
	
	public BeneficioLancamento(){}
	
	public BeneficioLancamento(Date data, ArrayList<BeneficioPadrao> beneficiosPadrao, boolean status) {
		this.data = data;
		this.beneficioPadrao = beneficiosPadrao;
		this.status=status;
	}
	
	public BeneficioLancamento(Integer id, Date data, ArrayList<BeneficioPadrao> beneficiosPadrao, boolean status) {
		this.id = id;
		this.data = data;
		this.beneficioPadrao = beneficiosPadrao;
		this.status=status;
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<BeneficioPadrao> getBeneficiosPadrao() {
		return beneficioPadrao;
	}
	public void setBeneficios(ArrayList<BeneficioPadrao> beneficiosPadrao) {
		this.beneficioPadrao = beneficiosPadrao;
	}
}
