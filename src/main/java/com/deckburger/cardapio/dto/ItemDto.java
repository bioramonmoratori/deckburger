package com.deckburger.cardapio.dto;

import com.deckburger.cardapio.enums.Classificacao;

public class ItemDto {
	
	private String titulo;
	private String preco;
	private String descricao;
	private Classificacao classificacao;
	
	//Getters e Setters
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Classificacao getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
	
	
	
}
