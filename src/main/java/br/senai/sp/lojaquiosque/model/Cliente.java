package br.senai.sp.lojaquiosque.model;

import java.util.Calendar;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Cliente {
	private TelefoneOuCelular tptelefone;

	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Calendar validade;
	

	public Calendar getValidade() {
		return validade;
	}

	public void setValidade(Calendar validade) {
		this.validade = validade;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Calendar eatacadastro;

	public Calendar getEatacadastro() {
		return eatacadastro;
	}

	public void setEatacadastro(Calendar eatacadastro) {
		this.eatacadastro = eatacadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String nome;
	private int contato;
	private String endereco;
	private int idade;
	private Genero sex;

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	private String email;
	private TipoProduto tprodutos;
	private FaixaEtaria faixa_etaria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TelefoneOuCelular getTptelefone() {
		return tptelefone;
	}

	public void setTptelefone(TelefoneOuCelular tptelefone) {
		this.tptelefone = tptelefone;
	}

	public int getContato() {
		return contato;
	}

	public void setContato(int contato) {
		this.contato = contato;
	}

	public Genero getSex() {
		return sex;
	}

	public void setSex(Genero sex) {
		this.sex = sex;
	}

	public TipoProduto getTprodutos() {
		return tprodutos;
	}

	public void setTprodutos(TipoProduto tprodutos) {
		this.tprodutos = tprodutos;
	}

	public FaixaEtaria getFaixa_etaria() {
		return faixa_etaria;
	}

	public void setFaixa_etaria(FaixaEtaria faixa_etaria) {
		this.faixa_etaria = faixa_etaria;
	}

}
