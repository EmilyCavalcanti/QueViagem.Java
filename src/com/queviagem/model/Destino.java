package com.queviagem.model;

public class Destino {

	private int id;
	
	private String pais;
	
	private String cidade;
	
	private double valor;
	
	private boolean promocao;

	
	public Destino() {
		super();
	}
	
	
	
	public Destino(int id, String pais, String cidade, double valor, boolean promocao) {
		super();
		this.id = id;
		this.pais = pais;
		this.cidade = cidade;
		this.valor = valor;
		this.promocao = promocao;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}
	
	
	@Override
	public String toString() {
		return " | ID Destino: " + id + " | País:" + pais + " | Cidade:" + cidade
				+  " | Valor: "+ valor + " | Promoçao : " + promocao; 
				
	}
	
} 