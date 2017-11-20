package com.edu.facear.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.edu.facear.model.Beneficio;
import com.edu.facear.model.Empregador;
import com.edu.facear.service.BeneficioService;
import com.edu.facear.service.LoginService;

@ManagedBean(name = "beneficioManagedBean")
@SessionScoped
public class BeneficioManagedBean implements Serializable {

	private static final long serialVersionUID = 54654561556L;

	private List<Beneficio> listaBeneficios;

	private BeneficioService beneficioService;

	private Beneficio beneficio;
	

	private boolean dialogVisible = false;

	private String titleDialog = "Excluir";

	private String textDialog = "Excluir";
	
	private boolean buttonBlock = true;
	
	private int id;

	private String descricao = "";

	private String valueButton = "Incluir";
	private Empregador empregador;
	private LoginService login;
	
	public BeneficioManagedBean() {

		beneficioService = new BeneficioService();
		listaBeneficios = beneficioService.listar();
		//empregador = new Empregador(login.getIdEmpregadorlogin());
		empregador = new Empregador(1);
	}

	public void excluirBeneficioAction() {

		if (beneficioService.deletar(beneficio.getId())) {
			titleDialog = "Benefício excluído com sucesso!";
			textDialog = "";
			dialogVisible = false;
			atualizarLista();
		} else {
			titleDialog = "Erro ao excluir benefício!";
			textDialog = "O benefício encontra-se em outros registros, exclua-os primeiro.";
		}

	}

	public void incluirBeneficioAction() {

		System.out.println(empregador.getId());
		if (valueButton.equals("Incluir")) {
			if (beneficioService.cadastrar(descricao, empregador)) {
				descricao="";
				atualizarLista();

			} else {
				titleDialog = "Erro ao criar benefício";
				textDialog = "";
			}
		}
		else {

			System.out.println(empregador.getId());
			if (beneficioService.atualizar(beneficio.getId(), descricao,empregador)) {
				descricao="";
				atualizarLista();

			} else {
				titleDialog = "Erro ao atualizar benefício";
				textDialog = "";
			}
		}

	}

	public void atualizarLista() {
		listaBeneficios.clear();
		listaBeneficios = beneficioService.listar();
	}

	public void validaCampoAction() {
		if (descricao.length() > 4 && descricao.length() < 35) {
			buttonBlock = false;

		} else {
			buttonBlock = true;
		}
	}

	public void editandoBeneficioAction() {
		valueButton = "Atualizar";
		listaBeneficios.remove(beneficio);
		validaCampoAction();
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

	public boolean isButtonBlock() {
		return buttonBlock;
	}

	public void setButtonBlock(boolean buttonBlock) {
		this.buttonBlock = buttonBlock;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValueButton() {
		return valueButton;
	}

	public void setValueButton(String valueButton) {
		this.valueButton = valueButton;
	}

}
