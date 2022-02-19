package br.senai.sp.lojaquiosque.model;

public enum Genero {
MASCOLINO("HOMEN"),FEMININO("Feminino");
	String des;

	private Genero(String des) {
		this.des = des;
	}

	@Override
	public String toString() {
		return this.des;
	}
}
