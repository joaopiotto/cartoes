package com.cartoes.api.security.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class JwtAuthenticationDto {

	private String cpf;
	private String senha;
	
	@NotEmpty(message = "CPF não pode ser vazio.")
	@Length(min = 11, max = 11,
	message = "CPF deve conter 11 caracteres.")
	@CPF( message = "CPF inválido.")
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@NotEmpty(message = "Senha não pode ser vazia.")
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "JwtAuthenticationRequestDto[cpf=" + cpf + ", senha=" + senha + "]";
	}
	
}
