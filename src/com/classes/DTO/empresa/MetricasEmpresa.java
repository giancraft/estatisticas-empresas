package com.classes.DTO.empresa;

import java.util.List;

import com.classes.DTO.dataFormatter.DataFormatter;
import com.classes.DTO.ordenacao.Ordenacao;

import java.time.LocalDate;
import java.util.ArrayList;

public class MetricasEmpresa {
	private List<Empresa> listaEmpresas = new ArrayList<>();
	
	public MetricasEmpresa(List<Empresa> lista) {
		listaEmpresas = lista;
	}
	
	public void maiorNumeroFuncionarios() {
		int maiorQuantidade = 0;
		String regiaoComMais = "";
		List<Matriz> regiaoNumeroFunc = new ArrayList<>();
		regiaoNumeroFunc.add(new Matriz("Norte", 0));
		regiaoNumeroFunc.add(new Matriz("Nordeste", 0));
		regiaoNumeroFunc.add(new Matriz("Centro-Oeste", 0));
		regiaoNumeroFunc.add(new Matriz("Sudeste", 0));
		regiaoNumeroFunc.add(new Matriz("Sul", 0));
		for (int i = 0; i < regiaoNumeroFunc.size(); i++) {
			for (int j = 0; j < listaEmpresas.size(); j++) {
				if (listaEmpresas.get(j).getRegiaoBrasil().getNomeRegiao().equals(regiaoNumeroFunc.get(i).getNome())) {
					regiaoNumeroFunc.get(i).setQuantidade(regiaoNumeroFunc.get(i).getQuantidade() + listaEmpresas.get(j).getNumeroFuncionarios());
				}
			}
		}
		for (int i = 0; i < regiaoNumeroFunc.size(); i++) {
			if (i == 0) {
				regiaoComMais = regiaoNumeroFunc.get(i).getNome();
				maiorQuantidade = regiaoNumeroFunc.get(i).getQuantidade();
			} else if (regiaoNumeroFunc.get(i).getQuantidade() > maiorQuantidade) {
				regiaoComMais = regiaoNumeroFunc.get(i).getNome();
				maiorQuantidade = regiaoNumeroFunc.get(i).getQuantidade();
			}
		}
		System.out.println("A região com maior número de funcionários é: " + regiaoComMais + " com " + maiorQuantidade + " funcionários");
	}
	
	public void maiorNumeroIndustrial() {
		int maiorQuantidade = 0;
		String regiaoComMais = "";
		List<Matriz> regiaoMaisSetorIndustrial = new ArrayList<>();
		regiaoMaisSetorIndustrial.add(new Matriz("Norte", 0));
		regiaoMaisSetorIndustrial.add(new Matriz("Nordeste", 0));
		regiaoMaisSetorIndustrial.add(new Matriz("Centro-Oeste", 0));
		regiaoMaisSetorIndustrial.add(new Matriz("Sudeste", 0));
		regiaoMaisSetorIndustrial.add(new Matriz("Sul", 0));
		for (int i = 0; i < regiaoMaisSetorIndustrial.size(); i++) {
			for (int j = 0; j < listaEmpresas.size(); j++) {
				if (listaEmpresas.get(j).getRegiaoBrasil().getNomeRegiao().equals(regiaoMaisSetorIndustrial.get(i).getNome()) 
					&& listaEmpresas.get(j).getSetorAtuacao().getNomeSetor().equals("Industrial")) {
					regiaoMaisSetorIndustrial.get(i).setQuantidade(regiaoMaisSetorIndustrial.get(i).getQuantidade() + 1);
				}
			}
		}
		for (int i = 0; i < regiaoMaisSetorIndustrial.size(); i++) {
			if (i == 0) {
				regiaoComMais = regiaoMaisSetorIndustrial.get(i).getNome();
				maiorQuantidade = regiaoMaisSetorIndustrial.get(i).getQuantidade();
			} else if (regiaoMaisSetorIndustrial.get(i).getQuantidade() > maiorQuantidade) {
				regiaoComMais = regiaoMaisSetorIndustrial.get(i).getNome();
				maiorQuantidade = regiaoMaisSetorIndustrial.get(i).getQuantidade();
			}
		}
		System.out.println("A região com maior número de empresas do setor industrial é: " + regiaoComMais + " com " + maiorQuantidade 
		+ " empresas deste setor");
	}
	
	public void numeroEmpresasPorSetor() {
		List<Matriz> porSetor = new ArrayList<>();
		porSetor.add(new Matriz("Industrial", 0));
		porSetor.add(new Matriz("Varejo", 0));
		porSetor.add(new Matriz("Servicos", 0));
		porSetor.add(new Matriz("Agrícola", 0));
		for (int i = 0; i < porSetor.size(); i++) {
			for (int j = 0; j < listaEmpresas.size(); j++) {
				if (listaEmpresas.get(j).getSetorAtuacao().getNomeSetor().equals(porSetor.get(i).getNome())) {
					porSetor.get(i).setQuantidade(porSetor.get(i).getQuantidade() + 1);
				}
			}
		}
		
		porSetor = Ordenacao.quickSort(porSetor, 0, porSetor.size() - 1);
		for (int i = porSetor.size() - 1; i >= 0; i--) {
			System.out.println("O número de empresas de " + porSetor.get(i).getNome() + " é: " + porSetor.get(i).getQuantidade());
		}
	}
	
	public void totalFuncionarios(){
		for (Empresa i : listaEmpresas) {
			System.out.println("A empresa " + i.getNomeEmpresa() + " possui " + i.getNumeroFuncionarios() + " funcionários");
		}
	}
	
	public void empresaMaisAntiga() {
		String empresaMaisAntiga = "";
		LocalDate maisAntiga = null;
		for (int i = 0; i < listaEmpresas.size(); i++) {
			if (i == 0) {
				empresaMaisAntiga = listaEmpresas.get(i).getNomeEmpresa();
				maisAntiga = listaEmpresas.get(i).getDataFundacao();
			} else if (listaEmpresas.get(i).getDataFundacao().isBefore(maisAntiga)) {
				empresaMaisAntiga = listaEmpresas.get(i).getNomeEmpresa();
				maisAntiga = listaEmpresas.get(i).getDataFundacao();
			}
		}
		System.out.println("A empresa mais antiga é " + empresaMaisAntiga + " com a data de fundação: " + maisAntiga.format(DataFormatter.formatarData()));
	}
}
