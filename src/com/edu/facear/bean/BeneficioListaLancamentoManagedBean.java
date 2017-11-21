package com.edu.facear.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
public class BeneficioListaLancamentoManagedBean implements Serializable {

	private static final long serialVersionUID = 5257086845768349115L;

	private List<BeneficioLancamento> listaLancamento;
	private BeneficioLancamentoService beneficioLancamento;
	private BeneficioLancadoService beneficioLancadoSevice;
	private List<BeneficioLancado> listaBeneficioLancado;
	private BeneficioLancamento lancamentoAux;
	private String nome="", cpf="",data="";

	private String id;
	
	private List<BeneficioLancamento>listaLancamentoAux = new ArrayList<>();

	public BeneficioListaLancamentoManagedBean() {
		beneficioLancamento = new BeneficioLancamentoService();
		//listaLancamento=beneficioLancamento.listaProEmpregador();
		listaLancamento = beneficioLancamento.listar();
		
	}

	public void atualizarListaLancamentos(){
		listaLancamentoAux = beneficioLancamento.listar();
	}
	public void buscar() {
		
		listaBeneficioLancado = new ArrayList<>();
		listaBeneficioLancado.clear();
		
		
		atualizarListaLancamentos();
		
		
		
		if(nome.isEmpty() && data.isEmpty() && cpf.isEmpty()) {
			listaLancamento.clear();
			listaLancamento = listaLancamentoAux;
		}
		else {
			
		listaLancamento.clear();
		
		for(int i=0;i<listaLancamentoAux.size();i++) {
			
			
			if((listaLancamentoAux.get(i).getEmpregado().getNome_completo().contains(nome) || nome.isEmpty())
					&& (listaLancamentoAux.get(i).getData().toString().contains(data) || data.isEmpty())
					&& (listaLancamentoAux.get(i).getEmpregado().getCpf().contains(cpf) || cpf.isEmpty())) {
				listaLancamento.add(listaLancamentoAux.get(i));
				
			}
		}

		listaLancamentoAux.clear();
		
		
		}
	
		
		
		
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

	public BeneficioLancamento getLancamentoAux() {
		return lancamentoAux;
	}

	public void setLancamentoAux(BeneficioLancamento lancamentoAux) {
		this.lancamentoAux = lancamentoAux;
	}

	public void listarBeneficiosLancados(Integer id) {
		
		listaBeneficioLancado = new ArrayList<>();
		listaBeneficioLancado.clear();
		beneficioLancadoSevice = new BeneficioLancadoService();
		
		listaBeneficioLancado = beneficioLancadoSevice.listarPorID(id);
		
		System.out.println(listaBeneficioLancado.get(0).getValor());
		
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
