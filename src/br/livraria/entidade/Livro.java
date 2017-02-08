package br.livraria.entidade;

public class Livro {
	
	private int idLivro;
	private String nomeLivro;
	private int quantidadePaginas;
	private String temaLivro;
	
	
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public int getQuantidadePaginas() {
		return quantidadePaginas;
	}
	public void setQuantidadePaginas(int quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}
	public String getTemaLivro() {
		return temaLivro;
	}
	public void setTemaLivro(String temaLivro) {
		this.temaLivro = temaLivro;
	}
	
	
}
