package com.classes.main;

import com.classes.BO.EmpresaBO;
import com.classes.DTO.empresa.Empresa;

public class MainExclusao {
	public static void main(String[] args) {
		EmpresaBO empresaBO = new EmpresaBO();
		Empresa empresa = empresaBO.procurarPorId(10);
		empresaBO.excluir(empresa);
	}
}
