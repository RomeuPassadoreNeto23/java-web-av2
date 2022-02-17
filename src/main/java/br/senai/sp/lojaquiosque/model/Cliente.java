package br.senai.sp.lojaquiosque.model;

public class Cliente {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String nome;
	private String telefoOuCelular;
	private String endereco;
	private int idade;
	private Genero genero;
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	private String email;
	private  TipoProduto tipoproduto;
	private FaixaEtaria faixetaria;
	
	public FaixaEtaria getFaixetaria() {
		return faixetaria;
	}
	public void setFaixetaria(FaixaEtaria faixetaria) {
		this.faixetaria = faixetaria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefoOuCelular() {
		return telefoOuCelular;
	}
	public void setTelefoOuCelular(String telefoOuCelular) {
		this.telefoOuCelular = telefoOuCelular;
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
	public TipoProduto getTipoproduto() {
		return tipoproduto;
	}
	public void setTipoproduto(TipoProduto tipoproduto) {
		this.tipoproduto = tipoproduto;
	}
	

}
