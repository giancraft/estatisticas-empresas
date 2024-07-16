package com.classes.main;

import java.util.List;
import com.classes.BO.*;
import com.classes.DTO.empresa.*;
import com.classes.DTO.conexao.*;

public class MainMetricas {
	public static void main(String[] args) {
		Conexao conexao = Conexao.getInstance(); // exemplo de como configurar a conexão com o banco
		conexao.usuario("root");
		conexao.senha("");
		conexao.caminho("localhost");
		conexao.porta(3306);
		conexao.banco("empresas");
		
		EmpresaBO empresaBO = new EmpresaBO();
		List<Empresa> lista = empresaBO.pesquisarTodos();
		
		MetricasEmpresa metricas = new MetricasEmpresa(lista); // aqui são apresentados os resultados das questões pedidas pelo teste
		metricas.maiorNumeroFuncionarios(); // Estes métodos só funcionarão se já tiver alguma empresa cadastrada no banco ou dentro da lista
		System.out.println();
		metricas.empresaMaisAntiga();
		System.out.println();
		metricas.maiorNumeroIndustrial();
		System.out.println();
		metricas.totalFuncionarios();
		System.out.println();
		metricas.numeroEmpresasPorSetor();
	}
}
