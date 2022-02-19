package br.senai.sp.lojaquiosque.model;

public enum FaixaEtaria {
	JOVEM("Jovem"),ADULTO("adulto"),IDOSO("idoso");
	String desc;

	private FaixaEtaria(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return this.desc;
	}


}
