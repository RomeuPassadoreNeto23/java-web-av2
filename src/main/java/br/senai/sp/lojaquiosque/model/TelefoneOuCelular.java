package br.senai.sp.lojaquiosque.model;

public enum TelefoneOuCelular {
	TELEFONE("telefone"),CELULAR("celular");
	String desc;

	private TelefoneOuCelular(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return this.desc;
	}

}
