package com.cartoes.api.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class CartaoDto {

	private String id;
	private String numero;
	private String dataValidade;
	private String bloqueado;
	private String clienteId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@NotEmpty(message = "Numero não pode ser vazio.")
	@Length(min = 16, max = 16,
	message = "Numero deve conter 16 caracteres.")
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@NotEmpty(message = "Data de validade não pode ser vazio.")
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	@NotEmpty(message = "Bloqueado de validade não pode ser vazio.")
	public String getBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(String bloqueado) {
		this.bloqueado = bloqueado;
	}
	
	@NotEmpty(message = "O ID do cliente não pode ser vazio.")
	public String getClienteId() {
		return clienteId;
	}
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
		
	@Override
	public String toString() {
		return "Cartao[" + "id=" + id + ","
				+ "numero=" + numero + ","
				+ "dataValidade=" + dataValidade + ","
				+ "bloqueado=" + bloqueado + ","
				+ "clienteId=" + clienteId + "]";
	}

	
}
