package com.classes.BO;

import java.util.List;
import com.classes.DAO.*;
import com.classes.DTO.empresa.Empresa;

public class EmpresaBO{

	public boolean inserir(Empresa empresa) {
		if (!existe(empresa)) {
			EmpresaDAO empresaDAO = new EmpresaDAO();
			return empresaDAO.inserir(empresa);
		}
		return false;
	}

	public boolean existe(Empresa empresa) {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		return empresaDAO.existe(empresa);
	}

	public boolean alterar(Empresa empresa) {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		return empresaDAO.alterar(empresa);
	}

	public boolean excluir(Empresa empresa) {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		return empresaDAO.excluir(empresa);
	}

	public Empresa procurarPorId(int id) {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		return empresaDAO.procurarPorId(id);
	}

	public Empresa procurarPorNome(String nome) {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		return empresaDAO.procurarPorNome(nome);
	}

	public List<Empresa> pesquisarTodos() {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		return empresaDAO.pesquisarTodos();
	}
	
	public void pesquisaFormatada() {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		empresaDAO.pesquisaFormatada(empresaDAO.pesquisarTodos());
	}

}
