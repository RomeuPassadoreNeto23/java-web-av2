package br.senai.sp.lojaquiosque.model;

public enum Genero {
MASCOLINO("HOMEN"),FEMININO("Feminino");
	String gen;

	private Genero(String gen) {
		this.gen = gen;
	}

	@Override
	public String toString() {
		return this.gen;
	}
}
