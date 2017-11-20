package com.edu.facear.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.edu.facear.model.BeneficioLancado;
import com.edu.facear.model.BeneficioLancamento;
import com.edu.facear.model.Empregado;
import com.edu.facear.service.BeneficioLancadoService;
import com.edu.facear.service.BeneficioLancamentoService;
import com.edu.facear.service.BeneficioService;

@ManagedBean(name = "listaLancamentoManagedBean")
@SessionScoped
public class BeneficioListaLancamentoManagedBean implements Serializable{

	private static final long serialVersionUID = 5257086845768349115L;
	
	private List<BeneficioLancamento> listaLancamento;
	private BeneficioLancamentoService beneficioLancamento;
	private BeneficioLancadoService beneficioLancadoSevice;
	private List<BeneficioLancado> listaBeneficioLancado;
	private String nome, cpf;
	
	private String id;
	
	public BeneficioListaLancamentoManagedBean(){
		beneficioLancamento = new BeneficioLancamentoService();
		listaLancamento=beneficioLancamento.listar();
		beneficioLancadoSevice = new BeneficioLancadoService();
		listaBeneficioLancado=beneficioLancadoSevice.listar();
	}
	public void buscar(){
		System.out.println(nome+cpf);
		listaBeneficioLancado.remove(1);
	}
	
	
	public List<BeneficioLancamento> getListaLancamento() {
		return listaLancamento;
	}


	public void setListaLancamento(ArrayList<BeneficioLancamento> listaLancamento) {
		this.listaLancamento = listaLancamento;
	}


	public BeneficioLancamentoService getBeneficioLancamento() {
		return beneficioLancamento;
	}


	public void setBeneficioLancamento(BeneficioLancamentoService beneficioLancamento) {
		this.beneficioLancamento = beneficioLancamento;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<BeneficioLancado> getListaBeneficioLancado() {
		return listaBeneficioLancado;
	}
	public void setListaBeneficioLancado(List<BeneficioLancado> listaBeneficioLancado) {
		this.listaBeneficioLancado = listaBeneficioLancado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
