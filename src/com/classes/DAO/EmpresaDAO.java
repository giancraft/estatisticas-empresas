package com.classes.DAO;

import java.util.List;

import com.classes.DTO.Interfaces.IEmpresaDAO;
import com.classes.DTO.RegiaoBrasil.RegiaoBrasil;
import com.classes.DTO.SetorAtuacao.SetorAtuacao;
import com.classes.DTO.conexao.Conexao;
import com.classes.DTO.dataFormatter.DataFormatter;
import com.classes.DTO.empresa.Empresa;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

public class EmpresaDAO implements IEmpresaDAO{
	
    final String NOMEDATABELA = "empresa";


	@Override
	public boolean inserir(Empresa empresa) {
		try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (NOME_EMPRESA, DATA_FUNDACAO, NUMERO_FUNCIONARIOS, REGIAO_DO_BRASIL, "
            + "SETOR_DE_ATUACAO) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, empresa.getNomeEmpresa());
            ps.setDate(2, Date.valueOf(empresa.getDataFundacao()));
            ps.setInt(3, empresa.getNumeroFuncionarios());
            ps.setString(4, empresa.getRegiaoBrasil().getNomeRegiao());
            ps.setString(5, empresa.getSetorAtuacao().getNomeSetor());
            ps.executeUpdate();
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                empresa.setId(generatedKeys.getInt(1));
            }
            
            ps.close();
            conn.close();
			return true;
		} catch (Exception e) {
            e.printStackTrace();
            return false;
		}
	}


	@Override
	public boolean existe(Empresa empresa) {
		try {
			Connection conn = Conexao.conectar();
			String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE NOME_EMPRESA = ?;";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, empresa.getNomeEmpresa());
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	        	ps.close();
	        	rs.close();
		        conn.close();
		        return true;
	        }
		} catch (Exception e) {
            e.printStackTrace();
            return false;
		}
		return false;
	}


	@Override
	public boolean alterar(Empresa empresa) {
		try {
			Connection conn = Conexao.conectar();
			String sql = "UPDATE " + NOMEDATABELA + " SET NOME_EMPRESA = ?, DATA_FUNDACAO = ?, NUMERO_FUNCIONARIOS = ?, REGIAO_DO_BRASIL = ?, "
			+ "SETOR_DE_ATUACAO = ? WHERE ID_EMPRESA = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, empresa.getNomeEmpresa());
            ps.setDate(2, Date.valueOf(empresa.getDataFundacao()));
            ps.setInt(3, empresa.getNumeroFuncionarios());
            ps.setString(4, empresa.getRegiaoBrasil().getNomeRegiao());
            ps.setString(5, empresa.getSetorAtuacao().getNomeSetor());
            ps.setInt(6, empresa.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
			return true;
		} catch (Exception e) {
            e.printStackTrace();
            return false;
		}
	}


	@Override
	public boolean excluir(Empresa empresa) {
		try {
			Connection conn = Conexao.conectar();
			String sql = "DELETE FROM " + NOMEDATABELA + " WHERE ID_EMPRESA = ?;";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, empresa.getId());
			ps.executeUpdate();
	        ps.close();
	        conn.close();
	        return true;
		} catch (Exception e) {
            e.printStackTrace();
            return false;
		}
	}


	@Override
	public Empresa procurarPorId(int id) {
		try {
			Connection conn = Conexao.conectar();
			String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE ID_EMPRESA = ?;";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	        	Empresa obj = new Empresa();
	        	RegiaoBrasil regiao = new RegiaoBrasil();
	        	SetorAtuacao setor = new SetorAtuacao();
	        	obj.setId(rs.getInt(1));
	        	obj.setNomeEmpresa(rs.getString(2));
	        	obj.setDataFundacao(rs.getDate(3).toLocalDate().format(DataFormatter.formatarData()));
	        	obj.setNumeroFuncionarios(rs.getInt(4));
	        	regiao.setNomeRegiao(rs.getString(5));
	        	obj.setRegiaoBrasil(regiao);
	        	setor.setNomeSetor(rs.getString(6));
	        	obj.setSetorAtuacao(setor);
	        	ps.close();
	        	rs.close();
		        conn.close();
		        return obj;
	        } else {
	        	ps.close();
	        	rs.close();
		        conn.close();
		        return null;
	        }
		} catch (Exception e) {
            e.printStackTrace();
            return null;
		}
	}


	@Override
	public Empresa procurarPorNome(String nome) {
		try {
			Connection conn = Conexao.conectar();
			String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE NOME_EMPRESA = ?;";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, nome);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	        	Empresa obj = new Empresa();
	        	RegiaoBrasil regiao = new RegiaoBrasil();
	        	SetorAtuacao setor = new SetorAtuacao();
	        	obj.setId(rs.getInt(1));
	        	obj.setNomeEmpresa(rs.getString(2));
	        	obj.setDataFundacao(rs.getDate(3).toLocalDate().format(DataFormatter.formatarData()));
	        	obj.setNumeroFuncionarios(rs.getInt(4));
	        	regiao.setNomeRegiao(rs.getString(5));
	        	obj.setRegiaoBrasil(regiao);
	        	setor.setNomeSetor(rs.getString(6));
	        	obj.setSetorAtuacao(setor);
	        	ps.close();
	        	rs.close();
		        conn.close();
		        return obj;
	        } else {
	        	ps.close();
	        	rs.close();
		        conn.close();
		        return null;
	        }
		} catch (Exception e) {
            e.printStackTrace();
            return null;
		}
	}


	@Override
	public List<Empresa> pesquisarTodos() {
		try {
			Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Empresa> lista = montarLista(rs);
            return lista;
		} catch (Exception e) {
            e.printStackTrace();
            return null;
		}
	}
	
	public void pesquisaFormatada(List<Empresa> lista) {
		for (Empresa i : lista) {
        	System.out.println("ID: " + i.getId());
        	System.out.println("Nome da Empresa: " + i.getNomeEmpresa());
        	System.out.println("Data de Fundação: " + i.getDataFundacao().format(DataFormatter.formatarData()));
        	System.out.println("Número de Funcionários: " + i.getNumeroFuncionarios());
        	System.out.println("Região do Brasil: " + i.getRegiaoBrasil().getNomeRegiao());
        	System.out.println("Setor de Atuação: " + i.getSetorAtuacao().getNomeSetor() + "\n");
        }
	}


	@Override
	public List<Empresa> montarLista(ResultSet rs) {
		List<Empresa> lista = new ArrayList<>();
		try {
			while (rs.next()) {
				Empresa obj = new Empresa();
				RegiaoBrasil regiao = new RegiaoBrasil();
	        	SetorAtuacao setor = new SetorAtuacao();
	        	obj.setId(rs.getInt(1));
	        	obj.setNomeEmpresa(rs.getString(2));
	        	obj.setDataFundacao(rs.getDate(3).toLocalDate().format(DataFormatter.formatarData()));
	        	obj.setNumeroFuncionarios(rs.getInt(4));
	        	regiao.setNomeRegiao(rs.getString(5));
	        	obj.setRegiaoBrasil(regiao);
	        	setor.setNomeSetor(rs.getString(6));
	        	obj.setSetorAtuacao(setor);
				lista.add(obj);
			}
			return lista;
		} catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
}
