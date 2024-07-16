package com.classes.main;

import com.classes.DTO.empresa.*;
import com.classes.DTO.RegiaoBrasil.*;
import com.classes.DTO.SetorAtuacao.*;
import com.classes.BO.*;

public class MainInsercao {

	public static void main(String[] args) {
		/* Exemplos de empresas para inserir

		Empresa empresa1 = new Empresa("teste", "28/10/1970", 79, new Nordeste(), new Industrial());
		Empresa empresa2 = new Empresa("teste2", "18/03/1936", 45, new Nordeste(), new Industrial());
		Empresa empresa3 = new Empresa("teste3", "03/10/1978", 67, new Norte(), new Varejo());
		Empresa empresa4 = new Empresa("teste4", "09/06/1969", 128, new Norte(), new Industrial());
		Empresa empresa5 = new Empresa("teste5", "24/09/1946", 32, new CentroOeste(), new Servicos());
		Empresa empresa6 = new Empresa("teste6", "19/10/2004", 89, new CentroOeste(), new Agricola());
		Empresa empresa7 = new Empresa("teste7", "03/04/2004", 92, new Sudeste(), new Industrial());
		Empresa empresa8 = new Empresa("teste8", "15/07/1989", 54, new Sudeste(), new Servicos());
		Empresa empresa9 = new Empresa("teste9", "12/05/1983", 26, new Sul(), new Varejo());
		Empresa empresa10 = new Empresa("teste10", "26/08/1982", 102, new Sul(), new Industrial());
		*/
		
		Empresa empresa = new Empresa("teste", "28/10/1970", 79, new Nordeste(), new Industrial());
		EmpresaBO empresaBO = new EmpresaBO();
		empresaBO.inserir(empresa);
	}

}
