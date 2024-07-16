package com.classes.DTO.empresa;

import java.time.LocalDate;

import com.classes.DTO.RegiaoBrasil.RegiaoBrasil;
import com.classes.DTO.SetorAtuacao.SetorAtuacao;
import com.classes.DTO.dataFormatter.DataFormatter;

public class Empresa {
	private int id;
	private String nomeEmpresa;
	private LocalDate dataFundacao;
	private int numeroFuncionarios;
	private RegiaoBrasil regiaoBrasil;
	private SetorAtuacao setorAtuacao;
	
	public Empresa() {
		
	}

	public Empresa(String nomeEmpresa, String dataFundacao, int numeroFuncionarios, RegiaoBrasil regiaoBrasil, SetorAtuacao setorAtuacao) {
		this.nomeEmpresa = nomeEmpresa;
		this.dataFundacao = LocalDate.parse(dataFundacao, DataFormatter.formatarData());
		this.numeroFuncionarios = numeroFuncionarios;
		this.regiaoBrasil = regiaoBrasil;
		this.setorAtuacao = setorAtuacao;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(String dataFundacao) {
		this.dataFundacao = LocalDate.parse(dataFundacao, DataFormatter.formatarData());
	}
	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}
	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}
	public RegiaoBrasil getRegiaoBrasil() {
		return regiaoBrasil;
	}
	public void setRegiaoBrasil(RegiaoBrasil regiaoBrasil) {
		this.regiaoBrasil = regiaoBrasil;
	}
	public SetorAtuacao getSetorAtuacao() {
		return setorAtuacao;
	}
	public void setSetorAtuacao(SetorAtuacao setorAtuacao) {
		this.setorAtuacao = setorAtuacao;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nomeEmpresa=" + nomeEmpresa + ", dataFundacao=" + dataFundacao
				+ ", numeroFuncionarios=" + numeroFuncionarios + ", regiaoBrasil=" + regiaoBrasil + ", setorAtuacao="
				+ setorAtuacao + "]";
	}
	
	
	
}
