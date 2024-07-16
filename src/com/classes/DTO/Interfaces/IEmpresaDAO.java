package com.classes.DTO.Interfaces;

import java.sql.ResultSet;
import java.util.List;

import com.classes.DTO.empresa.Empresa;

public interface IEmpresaDAO {
	public boolean inserir(Empresa empresa);
	public boolean existe(Empresa empresa);
	public boolean alterar(Empresa empresa);
	public boolean excluir(Empresa empresa);
	public Empresa procurarPorId(int id);
	public Empresa procurarPorNome(String nome);
	public List<Empresa> pesquisarTodos();
	public List<Empresa> montarLista(ResultSet rs);
}
