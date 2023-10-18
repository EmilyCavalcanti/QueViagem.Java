package com.queviagem.model;

public class Cliente {
	
	private int id;

	private String nome;

	private String cpf;

	private String email;

	private String senha;

	
	public Cliente() {
		super();
	}
	

	public Cliente(int id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id; 
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "Cliente [idCliente=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha="
				+ senha + "]";
	}
	
	
}
