package com.classes.main;

import java.util.List;
import java.util.ArrayList;
import com.classes.BO.*;
import com.classes.DTO.empresa.*;

public class MainPesquisarTodos {

	public static void main(String[] args) {
		EmpresaBO empresaBO = new EmpresaBO();
		empresaBO.pesquisaFormatada(); // pesquisaFormatada é um método que criei para pegar os valores do banco e apresentá-los de maneira mais organizada
	}
}
