package com.deckburger.cardapio.model;

import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.lang.NonNull;

import com.deckburger.cardapio.enums.Classificacao;

@Entity
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String titulo;
	
	@NonNull
	private String preco;

	private String descricao;
	
	@NonNull
	private Classificacao classificacao;
	
	@Lob
    private byte[] imagem;

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getImagem() {
		return Base64.getEncoder().encodeToString(imagem);
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
	
}
