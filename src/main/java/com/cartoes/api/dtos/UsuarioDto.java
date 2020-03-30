package com.cartoes.api.dtos;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class UsuarioDto {

	private String id;
	private String nome;
	private String cpf;
	private String ativo;
	private List<RegraDto> regras;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 5, max = 100,
	message = "Nome deve conter entre 5 e 100 caracteres.")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
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
	
	@NotEmpty(message = "Ativo não pode ser vazio.")
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	
	public List<RegraDto> getRegras() {
		return regras;
	}
	public void setRegras(List<RegraDto> regras) {
		this.regras = regras;
	}
	
	@Override
	public String toString() {
		return "Usuario[id=" + id + "," 
				+ "nome=" + nome + ","
				+ "cpf=" + cpf + ","
				+ "ativo=" + ativo + "]";
	}
	
	
}