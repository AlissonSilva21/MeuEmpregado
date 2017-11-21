package com.edu.facear.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioLancado;
import com.edu.facear.model.BeneficioLancamento;
import com.edu.facear.model.BeneficioPadrao;
import com.edu.facear.model.BeneficioPeriodo;
import com.edu.facear.model.Empregado;
import com.edu.facear.model.Empregador;
import com.edu.facear.service.BeneficioLancadoService;
import com.edu.facear.service.BeneficioLancamentoService;
import com.edu.facear.service.BeneficioPadraoService;
import com.edu.facear.service.BeneficioPeriodoService;
import com.edu.facear.service.BeneficioService;
import com.edu.facear.service.EmpregadoService;
import com.edu.facear.service.ListarEmpregadosService;
import com.edu.facear.service.LoginService;

@ManagedBean(name = "beneficioLancamentoManagedBean")
@SessionScoped
public class BeneficioLancamentoManagedBean implements Serializable{
	
	private static final long serialVersionUID = 3593594232158879927L;

	private BeneficioPadrao beneficioPadrao;

	private List<Beneficio> listaBeneficios;

	private BeneficioService beneficioService;

	private List<BeneficioPadrao> listaBeneficiosPadrao;

	private BeneficioPadraoService beneficioPadraoService;

	private List<BeneficioPeriodo> listaPeriodos;

	private BeneficioPeriodoService periodoService;

	private String valorAux = "0,00";

	private String valorDescAux = "0,00";

	private int tipoDesconto = 0; // Tipo R$

	private int idBeneficio;
	
	private int idPeriodo;
	private Empregado empregado;
	private int idEmpregado;
	private BeneficioLancado bendel;
	private int idAux;
	
	private int idLancamento;
	
	private BeneficioLancamento beneficioLancamento;
	private BeneficioLancamentoService beneficioLancamentoService;
	
	private List<BeneficioLancado> listaBeneficioLancado = new ArrayList<>();
	private BeneficioLancado beneficioLancado;
	private BeneficioLancadoService lancadoService;
	

	private BeneficioLancado beneficioLancadodel;

	public BeneficioLancamentoManagedBean() {

		beneficioService = new BeneficioService();
		periodoService = new BeneficioPeriodoService();
		listaBeneficios = beneficioService.listar();
		listaPeriodos = periodoService.listar();

		beneficioPadrao = new BeneficioPadrao();
		beneficioPadraoService = new BeneficioPadraoService();
		//listaBeneficiosPadrao=beneficioPadraoService.listarPorEmpregado();
		listaBeneficiosPadrao = beneficioPadraoService.listar();
		
		idBeneficio = listaBeneficios.get(0).getId();
		setIdBeneficio(idBeneficio);
		
		idPeriodo = listaPeriodos.get(0).getId();
		setIdPeriodo(idPeriodo);
		
		for(int i=0;i<listaBeneficiosPadrao.size();i++){
			beneficioLancado = new BeneficioLancado(listaBeneficiosPadrao.get(i).getValorBeneficio(), 
					listaBeneficiosPadrao.get(i).getDescReal(), listaBeneficiosPadrao.get(i).getDescPorCento(),
					listaBeneficiosPadrao.get(i).getBeneficio(), listaBeneficiosPadrao.get(i).getBeneficioPeriodo(), null);
			listaBeneficioLancado.add(beneficioLancado);
		}
		beneficioLancamentoService = new BeneficioLancamentoService();
		
	}
	
	public void cadastrarBeneficioAction(){
		
		Beneficio beneficio=new Beneficio();
		BeneficioPeriodo beneficioPeriodo=new BeneficioPeriodo();
		for(int i=0;i<listaBeneficios.size();i++){
			if(listaBeneficios.get(i).getId()==idBeneficio){
				beneficio=listaBeneficios.get(i);
			}
		}
		for(int i=0;i<listaPeriodos.size();i++){
			if(listaPeriodos.get(i).getId()==idPeriodo){
				beneficioPeriodo=listaPeriodos.get(i);
			}
		}
		beneficioLancado.setBeneficio(beneficio);
		beneficioLancado.setBeneficioPeriodo(beneficioPeriodo);
		atualizaLista();
		valorAux="0.0";
		valorDescAux="0.0";
		beneficioLancado = new BeneficioLancado();
	}
	public void atualizaLista(){
		listaBeneficioLancado.add(beneficioLancado);
	}
	public void deletarBeneficioAction(){
		for(int i=0;i<listaBeneficioLancado.size();i++){
			if(listaBeneficioLancado.get(i).equals(bendel)){
				listaBeneficioLancado.remove(i);
			}
		}
	}
	public void realizarLancamento(Empregado empregadoax){
		int id;
		SimpleDateFormat Format=new SimpleDateFormat("yyyy-MM-dd");
		Date data=new Date();
		LoginService service=new LoginService();
		Empregador empregador=new Empregador(service.getIdEmpregadorlogin());
		BeneficioLancamentoService lancamento=new BeneficioLancamentoService();
		lancamento.cadastrar("2017-11-21", true, empregadoax, empregador);
		id=lancamento.proxId();
		BeneficioLancadoService lanService=new BeneficioLancadoService();
		BeneficioLancamento beneficioLancamento=new BeneficioLancamento(id);
		for(int i=0;i<listaBeneficioLancado.size();i++){
			listaBeneficioLancado.get(i).setBeneficioLancamento(beneficioLancamento);
			lanService.cadastrar(listaBeneficioLancado.get(i).getValor(),listaBeneficioLancado.get(i).getDescontoReal(),
					listaBeneficioLancado.get(i).getDescontoPorCento(), listaBeneficioLancado.get(i).getBeneficio(),
					listaBeneficioLancado.get(i).getBeneficioPeriodo(), listaBeneficioLancado.get(i).getBeneficioLancamento());
		}
		
		listaBeneficioLancado.clear();
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
	
	public List<BeneficioLancado> getListaBeneficioLancado() {
		return listaBeneficioLancado;
	}

	public void setListaBeneficioLancado(List<BeneficioLancado> listaBeneficioLancado) {
		this.listaBeneficioLancado = listaBeneficioLancado;
	}

	public BeneficioLancado getBeneficioLancado() {
		return beneficioLancado;
	}

	public void setBeneficioLancado(BeneficioLancado beneficioLancado) {
		this.beneficioLancado = beneficioLancado;
	}

	public BeneficioLancadoService getLancadoService() {
		return lancadoService;
	}

	public void setLancadoService(BeneficioLancadoService lancadoService) {
		this.lancadoService = lancadoService;
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
				beneficioLancado.setDescontoPorCento(Float.parseFloat(palavra));
				beneficioLancado.setDescontoReal(0.0);

			} else {
				valorDescAux = palavra;
				for (int i = 0; i < palavra.length(); i++) {
					if (palavra.charAt(i) == '.') {
						palavra = palavra.substring(0, i) + palavra.substring(i + 1);
					}
				}

				palavra = palavra.replaceAll(",", ".");

				beneficioLancado.setDescontoReal(Double.valueOf(palavra));
				beneficioLancado.setDescontoPorCento(Float.valueOf(0));

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

			beneficioLancado.setValor(Double.valueOf(palavra));

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
	

	public int getIdBeneficio() {
		return idBeneficio;
	}

	public void setIdBeneficio(int idBeneficio) {
		this.idBeneficio = idBeneficio;
	}

	public int getIdAux() {
		return idAux;
	}

	public void setIdAux(int idAux) {
		this.idAux = idAux;
	}
	public int getIdLancamento() {
		return idLancamento;
	}

	public void setIdLancamento(int idLancamento) {
		this.idLancamento = idLancamento;
	}

	public BeneficioLancamento getBeneficioLancamento() {
		return beneficioLancamento;
	}

	public void setBeneficioLancamento(BeneficioLancamento beneficioLancamento) {
		this.beneficioLancamento = beneficioLancamento;
	}

	public BeneficioLancado getBeneficioLancadodel() {
		return beneficioLancadodel;
	}

	public void setBeneficioLancadodel(BeneficioLancado beneficioLancadodel) {
		this.beneficioLancadodel = beneficioLancadodel;
	}
	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public BeneficioLancado getBendel() {
		return bendel;
	}

	public void setBendel(BeneficioLancado bendel) {
		this.bendel = bendel;
	}

}
