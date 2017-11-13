package com.edu.facear.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.edu.facear.model.BeneficioLancamento;
import com.edu.facear.service.BeneficioLancamentoService;
import com.edu.facear.service.BeneficioService;

@ManagedBean(name = "listaLancamentoManagedBean")
@SessionScoped
public class ListaLancamentoManagedBean implements Serializable{

	private static final long serialVersionUID = 5257086845768349115L;
	
	private ArrayList<BeneficioLancamento> listaLancamento;
	private BeneficioLancamentoService beneficioLancamento;
	
	
	public ListaLancamentoManagedBean() {
		
		beneficioLancamento = new BeneficioLancamentoService();
		listaLancamento.addAll(beneficioLancamento.listar());
		
	}
	
	public ArrayList<BeneficioLancamento> getListaLancamento() {
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


	
}
