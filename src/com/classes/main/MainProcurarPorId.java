package com.classes.main;

import com.classes.BO.EmpresaBO;

public class MainProcurarPorId {
	public static void main(String[] args) {
		EmpresaBO empresaBO = new EmpresaBO();
		System.out.println(empresaBO.procurarPorId(1));
	}
}
