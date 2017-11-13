package com.edu.facear.Teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioLancado;
import com.edu.facear.model.BeneficioLancamento;
import com.edu.facear.model.BeneficioPeriodo;
import com.edu.facear.service.BeneficioLancadoService;
import com.edu.facear.service.BeneficioLancamentoService;
import com.edu.facear.service.BeneficioService;

public class TesteBanco {
	@Test
	public void Teste() {
		// TODO Auto-generated method stub
		BeneficioService bene=new BeneficioService();
		System.out.println(bene.proxId());

	}
}
