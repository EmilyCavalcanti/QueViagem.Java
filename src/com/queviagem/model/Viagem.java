package com.queviagem.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Viagem {

	private int id;
	private LocalDateTime dataIda;
	private LocalDateTime dataVolta;
	private Cliente idCliente;
	private Destino idDestino;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public Viagem() {
		super();
	}
	
	
	public Viagem(int id, LocalDateTime dataIda, LocalDateTime dataVolta, Cliente idCliente, Destino idDestino) {
		super();
		this.id = id;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.idCliente = idCliente;
		this.idDestino = idDestino;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public LocalDateTime getDataIda() {
		return dataIda;
	}



	public void setDataIda(LocalDateTime dataIda) {
		this.dataIda = dataIda;
	}



	public LocalDateTime getDataVolta() {
		return dataVolta;
	}



	public void setDataVolta(LocalDateTime dataVolta) {
		this.dataVolta = dataVolta;
	}



	public Cliente getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}



	public Destino getIdDestino() {
		return idDestino;
	}



	public void setIdDestino(Destino idDestino) {
		this.idDestino = idDestino;
	}



	@Override
	public String toString() {
		return "ID Viagem: " + id + ", Data da ida:" + dataIda + ", Data da volta: " + dataVolta 
				+ ", Cliente:" + idCliente + ", Destino " + idDestino;
	}
	
	
}