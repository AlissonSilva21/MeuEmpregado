package com.edu.facear.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.edu.facear.model.Beneficio;
import com.edu.facear.model.DescontoBeneficio;
import com.edu.facear.model.Periodo;
import com.edu.facear.service.BeneficioPadraoService;
import com.edu.facear.service.BeneficioService;
import com.edu.facear.service.PeriodoService;

@ManagedBean(name = "beneficioPadraoManagedBean")
@SessionScoped
public class BeneficioPadraoManagedBean implements Serializable {

	private static final long serialVersionUID = 54654561557L;

	private Beneficio beneficio;

	private List<Beneficio> listaBeneficios;

	private BeneficioService beneficioService;

	private List<Beneficio> listaBeneficiosPadrao;

	private BeneficioPadraoService beneficioPadraoService;

	private List<Periodo> listaPeriodos;

	private PeriodoService periodoService;

	private Periodo periodo;

	private DescontoBeneficio descontoBeneficio = new DescontoBeneficio();

	private String valorAux = "0,00";

	private String valorDescAux = "0,00";

	public BeneficioPadraoManagedBean() {

		beneficioService = new BeneficioService();
		listaBeneficios = beneficioService.listar();

		beneficio = listaBeneficios.get(0);

		periodoService = new PeriodoService();

		listaPeriodos = periodoService.listar();

	}

	public List<Beneficio> getListaBeneficios() {
		return listaBeneficios;
	}

	public void setListaBeneficios(List<Beneficio> listaBeneficios) {
		this.listaBeneficios = listaBeneficios;
	}

	public List<Beneficio> getListaBeneficiosPadrao() {
		return listaBeneficiosPadrao;
	}

	public void setListaBeneficiosPadrao(List<Beneficio> listaBeneficiosPadrao) {
		this.listaBeneficiosPadrao = listaBeneficiosPadrao;
	}

	public BeneficioPadraoService getBeneficioPadraoService() {
		return beneficioPadraoService;
	}

	public void setBeneficioPadraoService(BeneficioPadraoService beneficioPadraoService) {
		this.beneficioPadraoService = beneficioPadraoService;
	}

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	public List<Periodo> getListaPeriodos() {
		return listaPeriodos;
	}

	public void setListaPeriodos(List<Periodo> listaPeriodos) {
		this.listaPeriodos = listaPeriodos;
	}

	public PeriodoService getPeriodoService() {
		return periodoService;
	}

	public void setPeriodoService(PeriodoService periodoService) {
		this.periodoService = periodoService;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public DescontoBeneficio getDescontoBeneficio() {
		return descontoBeneficio;
	}

	public void setDescontoBeneficio(DescontoBeneficio descontoBeneficio) {
		this.descontoBeneficio = descontoBeneficio;
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
			if (palavra.length() >= 7) {
				palavra = palavra.substring(0, palavra.length() - 6) + "." + palavra.substring(palavra.length() - 6);
			}
			
			

			if (descontoBeneficio.getId() != 0) {
				palavra = palavra.replaceAll(",", ".");

				if (Float.parseFloat(palavra) > 100) {

					palavra = "100.00";

				}

			}

			valorDescAux = palavra;

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

		}

	}

}
