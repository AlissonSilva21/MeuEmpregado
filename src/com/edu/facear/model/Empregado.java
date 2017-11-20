package com.edu.facear.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Empregado", catalog="MeuEmpregado")
public class Empregado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	private Integer id;
	
	private String data_nascimento;
	private String nome_completo;
	private String cpf;
	private String rg;
	private String telefone_fixo;
	private String telefone_celular;
	private String cep;
	private String endereco_rua;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String email;
	private String senha;
	private String uf;
	private Boolean sexo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_completo() {
		return nome_completo;
	}
	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone_fixo() {
		return telefone_fixo;
	}
	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone_fixo = telefone_fixo;
	}
	public String getTelefone_celular() {
		return telefone_celular;
	}
	public void setTelefone_celular(String telefone_celular) {
		this.telefone_celular = telefone_celular;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco_rua() {
		return endereco_rua;
	}
	public void setEndereco_rua(String endereco_rua) {
		this.endereco_rua = endereco_rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
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
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public Boolean getSexo() {
		return sexo;
	}
	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}
	public String getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	@Override
	public String toString() {
		return "Empregado [id=" + id + ", nome_completo=" + nome_completo + ", data_nascimento=" + data_nascimento
				+ ", cpf=" + cpf + ", rg=" + rg + ", telefone_fixo=" + telefone_fixo + ", telefone_celular="
				+ telefone_celular + ", cep=" + cep + ", endereco_rua=" + endereco_rua + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", email=" + email
				+ ", senha=" + senha + ", uf=" + uf + ", sexo=" + sexo + "\n";
	}
	
	public Empregado(String nome_completo, String data_nascimento, String cpf, String rg,
			String telefone_fixo, String telefone_celular, String cep, String endereco_rua, Integer numero,
			String complemento, String bairro, String cidade, String email, String senha, String uf, Boolean sexo) {
		this.nome_completo = nome_completo;
		this.data_nascimento = data_nascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone_fixo = telefone_fixo;
		this.telefone_celular = telefone_celular;
		this.cep = cep;
		this.endereco_rua = endereco_rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.email = email;
		this.senha = senha;
		this.uf = uf;
		this.sexo = sexo;
	}
	
	public Empregado(Integer id, String data_nascimento, String nome_completo, String cpf, String rg,
			String telefone_fixo, String telefone_celular, String cep, String endereco_rua, Integer numero,
			String complemento, String bairro, String cidade, String email, String senha, String uf, Boolean sexo) {
		super();
		this.id = id;
		this.data_nascimento = data_nascimento;
		this.nome_completo = nome_completo;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone_fixo = telefone_fixo;
		this.telefone_celular = telefone_celular;
		this.cep = cep;
		this.endereco_rua = endereco_rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.email = email;
		this.senha = senha;
		this.uf = uf;
		this.sexo = sexo;
	}
	public Empregado(Integer id){
		this.id=id;
	}
	
	public Empregado() {
		
	}
	
		
}
