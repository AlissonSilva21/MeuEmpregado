package com.edu.facear.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioPadrao;
import com.edu.facear.model.BeneficioPeriodo;
import com.edu.facear.model.Empregado;
import com.edu.facear.service.BeneficioPadraoService;
import com.edu.facear.service.BeneficioPeriodoService;
import com.edu.facear.service.BeneficioService;

@ManagedBean(name = "beneficioPadraoManagedBean")
@SessionScoped
public class BeneficioPadraoManagedBean implements Serializable {

	private static final long serialVersionUID = 54654561557L;

	private BeneficioPadrao beneficioPadrao;
	
	private boolean dialogVisible = false;
	
	private String titleDialog = "Oloco bisho";

	private String textDialog = "Oloco bisho";

	private List<Beneficio> listaBeneficios;

	private BeneficioService beneficioService;

	private List<BeneficioPadrao> listaBeneficiosPadrao;

	private BeneficioPadraoService beneficioPadraoService;

	private List<BeneficioPeriodo> listaPeriodos;

	private BeneficioPeriodoService periodoService;

	private String valorAux = "0,00";

	private String valorDescAux = "0,00";

	private int tipoDesconto = 0; // Tipo R$

	private int idBeneficio, idPeriodo;
	
	private String valueButton = "Incluir";

	private Empregado empregado;
	
	private InicioBeneficioManagedBean inicio =new InicioBeneficioManagedBean();
	
	private int idEmpregado;

	

	public BeneficioPadraoManagedBean() {

		beneficioService = new BeneficioService();
		listaBeneficios = beneficioService.listar();
		
		periodoService = new BeneficioPeriodoService();

		listaPeriodos = periodoService.listar();

		beneficioPadrao = new BeneficioPadrao();

		beneficioPadraoService = new BeneficioPadraoService();
		//listaBeneficiosPadrao=beneficioPadraoService.listarPorEmpregado();
		listaBeneficiosPadrao = beneficioPadraoService.listar();
		
		idBeneficio = listaBeneficios.get(0).getId();
		setIdBeneficio(idBeneficio);
		
		idPeriodo = listaPeriodos.get(0).getId();
		setIdPeriodo(idPeriodo);

	}

	public void cadastrarBeneficioPadraoAction(Empregado empregadoQ) {
		setEmpregado(empregadoQ);
		
		
		if (valueButton.equals("Incluir")) {
			BeneficioPeriodo beneficioPeriodo=new BeneficioPeriodo(idPeriodo);
			Beneficio beneficio=new Beneficio(idBeneficio);
			empregado=new Empregado(empregadoQ.getId());
			System.out.println("Perido:"+idPeriodo+"Bene:"+idBeneficio+"EMpre:"+empregadoQ.getId());
			if(beneficioPadraoService.cadastrar(beneficioPadrao.getDescReal(), beneficioPadrao.getValorBeneficio(), beneficioPadrao.getDescPorCento(), beneficioPeriodo, beneficio,empregado)) {
				beneficioPadrao = new BeneficioPadrao();
				valorAux = "0,00";
				valorDescAux = "0,00";
				atualizarLista();
			}
		}
		else {
			if (beneficioPadraoService.atualizar(beneficioPadrao.getId(), beneficioPadrao.getDescReal(), beneficioPadrao.getValorBeneficio(), beneficioPadrao.getDescPorCento(), beneficioPadrao.getBeneficioPeriodo(), beneficioPadrao.getBeneficio(), beneficioPadrao.getEmpregado())) {
				beneficioPadrao = new BeneficioPadrao();
				valorAux = "0,00";
				valorDescAux = "0,00";
				atualizarLista();
				valueButton = "Incluir";
			}
			
		}

	}

	public void excluirBeneficioPadraoAction() {

		if (beneficioPadraoService.deletar(beneficioPadrao.getId())) {
			beneficioPadrao = new BeneficioPadrao(0,0,0,0,listaPeriodos.get(0),listaBeneficios.get(0), empregado);
			valorAux = "0,00";
			valorDescAux = "0,00";
			dialogVisible = false;
			atualizarLista();
		}

	}

	public void atualizarLista() {
		listaBeneficiosPadrao.clear();
		listaBeneficiosPadrao = beneficioPadraoService.listar();
	}

	public void setIdBeneficio() {
		beneficioPadrao.getBeneficio().setId(idBeneficio);
	}

	public void setIdPeriodo() {
		beneficioPadrao.getBeneficioPeriodo().setId(idPeriodo);
	}

	public List<Beneficio> getListaBeneficios() {
		return listaBeneficios;
	}

	public void setListaBeneficios(List<Beneficio> listaBeneficios) {
		this.listaBeneficios = listaBeneficios;
	}

	public List<BeneficioPadrao> getListaBeneficiosPadrao() {
		return listaBeneficiosPadrao;
	}

	public void setListaBeneficiosPadrao(List<BeneficioPadrao> listaBeneficiosPadrao) {
		this.listaBeneficiosPadrao = listaBeneficiosPadrao;
	}

	public BeneficioPadraoService getBeneficioPadraoService() {
		return beneficioPadraoService;
	}

	public void setBeneficioPadraoService(BeneficioPadraoService beneficioPadraoService) {
		this.beneficioPadraoService = beneficioPadraoService;
	}

	public List<BeneficioPeriodo> getListaPeriodos() {
		return listaPeriodos;
	}

	public void setListaPeriodos(List<BeneficioPeriodo> listaPeriodos) {
		this.listaPeriodos = listaPeriodos;
	}


	public String getValorAux() {
		return valorAux;
	}

	public void setValorAux(String valorAux) {
		this.valorAux = valorAux;
	}

	public String getValorDescAux() {
		return valorDescAux;
	}

	public void setValorDescAux(String valorDescAux) {
		this.valorDescAux = valorDescAux;
	}
	
	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	
	public void editandoBeneficioAction() {
		valueButton = "Atualizar";
		listaBeneficiosPadrao.remove(beneficioPadrao);
		valorAux = "0,00";
		valorDescAux = "0,00";
		
	}

	public void editarValor(Long escolha) {

		if (escolha == 1) {

			String palavra = valorDescAux;

			palavra = palavra.replaceAll("[^0-9]", "");

			if (palavra.length() > 7) {
				palavra = palavra.substring(0, 7);
			}

			if (palavra.length() > 9) {
				palavra = palavra.substring(0, 9);
			}
			if (palavra.length() == 0) {
				palavra = "0";
			}
			if (palavra.length() == 1) {
				palavra = "0" + palavra;
			}

			if (palavra.charAt(0) == '0' && palavra.length() > 2) {
				palavra = palavra.substring(1, palavra.length());
			}

			if (palavra.length() > 2) {
				palavra = palavra.substring(0, palavra.length() - 2) + "," + palavra.substring(palavra.length() - 2);

			} else if (palavra.length() == 2) {

				palavra = "0," + palavra.charAt(0) + palavra.charAt(1);

			}

			if (tipoDesconto == 0) {
				if (palavra.length() >= 7) {
					palavra = palavra.substring(0, palavra.length() - 6) + "."
							+ palavra.substring(palavra.length() - 6);
				}
			}

			if (tipoDesconto != 0) {
				palavra = palavra.replaceAll(",", ".");

				if (Float.parseFloat(palavra) > 100) {

					palavra = "100.00";

				}

				valorDescAux = palavra;
				beneficioPadrao.setDescPorCento(Float.parseFloat(palavra));
				beneficioPadrao.setDescReal(0);

			} else {
				valorDescAux = palavra;
				for (int i = 0; i < palavra.length(); i++) {
					if (palavra.charAt(i) == '.') {
						palavra = palavra.substring(0, i) + palavra.substring(i + 1);
					}
				}

				palavra = palavra.replaceAll(",", ".");

				beneficioPadrao.setDescReal(Float.parseFloat(palavra));
				beneficioPadrao.setDescPorCento(0);

			}

		} else {

			String palavra = valorAux;

			palavra = palavra.replaceAll("[^0-9]", "");

			if (palavra.length() > 7) {
				palavra = palavra.substring(0, 7);
			}

			if (palavra.length() > 9) {
				palavra = palavra.substring(0, 9);
			}
			if (palavra.length() == 0) {
				palavra = "0";
			}
			if (palavra.length() == 1) {
				palavra = "0" + palavra;
			}

			if (palavra.charAt(0) == '0' && palavra.length() > 2) {
				palavra = palavra.substring(1, palavra.length());
			}

			if (palavra.length() > 2) {
				palavra = palavra.substring(0, palavra.length() - 2) + "," + palavra.substring(palavra.length() - 2);

			} else if (palavra.length() == 2) {

				palavra = "0," + palavra.charAt(0) + palavra.charAt(1);

			}

			if (palavra.length() >= 7) {
				palavra = palavra.substring(0, palavra.length() - 6) + "." + palavra.substring(palavra.length() - 6);
			}

			valorAux = palavra;
			for (int i = 0; i < palavra.length(); i++) {
				if (palavra.charAt(i) == '.') {
					palavra = palavra.substring(0, i) + palavra.substring(i + 1);
				}
			}

			palavra = palavra.replaceAll(",", ".");

			beneficioPadrao.setValorBeneficio(Float.parseFloat(palavra));

		}

	}

	public BeneficioPadrao getBeneficioPadrao() {
		return beneficioPadrao;
	}

	public void setBeneficioPadrao(BeneficioPadrao beneficioPadrao) {
		this.beneficioPadrao = beneficioPadrao;
	}

	public int getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(int tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}
	
	public void showDialog() {
		dialogVisible = true;
	}

	public void hideDialog() {
		dialogVisible = false;
	}
	
	public boolean isDialogVisible() {
		return dialogVisible;
	}

	public void setDialogVisible(boolean dialogVisible) {
		this.dialogVisible = dialogVisible;
	}
	

	public int getIdBeneficio() {
		return idBeneficio;
	}

	public void setIdBeneficio(int idBeneficio) {
		this.idBeneficio = idBeneficio;
	}

	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
	
	public String getValueButton() {
		return valueButton;
	}

	public void setValueButton(String valueButton) {
		this.valueButton = valueButton;
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

}
