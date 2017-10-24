package com.edu.facear.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.edu.facear.model.Beneficio;
import com.edu.facear.service.BeneficioService;


@ManagedBean(name = "beneficioManagedBean")
@SessionScoped
public class BeneficioManagedBean implements Serializable{
	
	private static final long serialVersionUID = 54654561556L;
	
	private List<Beneficio> listaBeneficios;	

	private BeneficioService beneficioService;
	
	private Beneficio beneficio;
	
	private boolean dialogVisible = false;
	
	private String titleDialog = "Oloco bisho";

	private String textDialog  = "Oloco bisho";
	
	private int id;
	
	
	public BeneficioManagedBean(){
		
		beneficioService = new BeneficioService();
		listaBeneficios = beneficioService.listar();
		refreshID();
		
	}
	
	
	public void excluirBeneficioAction() {
		if(beneficioService.deletar(beneficio.getId())) {
			titleDialog = "Benefício excluído com sucesso!";
			textDialog = "";
		}
		else {
			titleDialog = "Erro ao excluir benefício!";
			textDialog = "O benefício encontra-se em outros registros, exclua-os primeiro.";
		}
		
	}
	
	
	public void atualizarLista() {
		listaBeneficios.clear();
		listaBeneficios = beneficioService.listar();
	}
	
	public void refreshID() {
		id = beneficioService.ultimoID();
	}
	
	public void showDialog() {
		dialogVisible = true;
	}
	
	public void hideDialog() {

		dialogVisible = false;	
	}
	
	public List<Beneficio> getListaBeneficios() {
		return listaBeneficios;
	}

	public void setListaBeneficios(List<Beneficio> listaBeneficios) {
		this.listaBeneficios = listaBeneficios;
	}

	public BeneficioService getBeneficioService() {
		return beneficioService;
	}

	public void setBeneficioService(BeneficioService beneficioService) {
		this.beneficioService = beneficioService;
	}


	public Beneficio getBeneficio() {
		return beneficio;
	}


	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}
	
	public boolean isDialogVisible() {
		return dialogVisible;
	}


	public void setDialogVisible(boolean dialogVisible) {
		this.dialogVisible = dialogVisible;
	}


	public String getTitleDialog() {
		return titleDialog;
	}


	public void setTitleDialog(String titleDialog) {
		this.titleDialog = titleDialog;
	}


	public String getTextDialog() {
		return textDialog;
	}


	public void setTextDialog(String textDialog) {
		this.textDialog = textDialog;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	

	
}
