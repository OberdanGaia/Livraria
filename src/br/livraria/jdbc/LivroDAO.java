package br.livraria.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.livraria.entidade.Livro;

public class LivroDAO {
	
	private Connection con = Conexao.getConnection();
	
	public void cadastrarLivro(Livro livro){
		
		String query = "INSERT INTO LIVRO (NOME_LIVRO, QUANTIDADE_PAGINAS, TEMA_LIVRO) VALUES (?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, livro.getNomeLivro());
			ps.setInt(2, livro.getQuantidadePaginas());
			ps.setString(3, livro.getTemaLivro());
			
			ps.execute();
			ps.close();
			
			System.out.println("Livro Cadastrado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Livro> listarTodos(){
		
		String query = "SELECT * FROM LIVRO";
		
		List<Livro> lista = new ArrayList<Livro>();
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet result = ps.executeQuery();
			
			while(result.next()){
				
				Livro livro = new Livro();
				
				livro.setIdLivro(result.getInt("id_livro"));
				livro.setNomeLivro(result.getString("nome_livro"));
				livro.setQuantidadePaginas(Integer.parseInt(result.getString("quantidade_paginas")));
				livro.setTemaLivro(result.getString("tema_livro"));
				
				
				lista.add(livro);
				
			}	
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
}
