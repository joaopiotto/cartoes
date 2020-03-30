package com.cartoes.api.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class SenhaDto {

	private String idUsuario;
	private String senhaAtual;
	private String novaSenha;
	
	@NotEmpty(message = "Id so usuário não pode ser vazio.")
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@NotEmpty(message = "Senha atual não pode ser vazio.")
	@Length(min = 8, max = 25,
	message = "Senha atual deve conter entre 8 e 25 caracteres.")
	public String getSenhaAtual() {
		return senhaAtual;
	}
	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}
	
	@NotEmpty(message = "Nova senha não pode ser vazio.")
	@Length(min = 8, max = 25,
	message = "Nome deve conter entre 8 e 25 caracteres.")
	public String getNovaSenha() {
		return novaSenha;
	}
	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}
	
	@Override
	public String toString() {
		return "SenhaDto[idUsuario=" + idUsuario + "," 
				+ "senhaAtual=" + senhaAtual + ","
				+ "novaSenha=" + novaSenha + "]";
	}
	
}
