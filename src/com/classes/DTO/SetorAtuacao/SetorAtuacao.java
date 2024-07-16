package com.classes.DTO.SetorAtuacao;

public class SetorAtuacao {
	private String nomeSetor;

	public String getNomeSetor() {
		return nomeSetor;
	}
	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}
	@Override
	public String toString() {
		return "SetorAtuacao [nomeSetor=" + nomeSetor + "]";
	}
}
