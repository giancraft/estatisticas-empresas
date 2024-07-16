package com.classes.main;

import com.classes.DTO.empresa.*;
import com.classes.BO.*;

public class MainAlteracao {
	public static void main (String[] args) {
		EmpresaBO empresaBO = new EmpresaBO();
		Empresa empresa = empresaBO.procurarPorId(1);
		empresa.setNumeroFuncionarios(80);
		empresaBO.alterar(empresa);
	}
}
