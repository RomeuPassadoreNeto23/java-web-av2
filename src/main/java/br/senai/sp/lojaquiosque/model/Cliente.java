package br.senai.sp.lojaquiosque.model;

public class Cliente {
	private TelefoneOuCelular telefoneoucelular;
	public TelefoneOuCelular getTelefoneoucelular() {
		return telefoneoucelular;
	}
	public void setTelefoneoucelular(TelefoneOuCelular telefoneoucelular) {
		this.telefoneoucelular = telefoneoucelular;
	}
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private FaixaEtaria faixaEtaria;

	
	public FaixaEtaria getFaixaEtaria() {
		return faixaEtaria;
	}
	public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
	
	private String nome;
	private int telefone;
	private String endereco;
	private int idade;
	private Genero generox;
	
	
	
	public Genero getGenerox() {
		return generox;
	}
	public void setGenerox(Genero generox) {
		this.generox = generox;
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
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
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
