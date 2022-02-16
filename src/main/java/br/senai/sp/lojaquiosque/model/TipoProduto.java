package br.senai.sp.lojaquiosque.model;

public enum TipoProduto {
 ELETRONICO("eletrônicos"),DOMESTICO("domésticos");
	
	String desc;

	private TipoProduto(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return this.desc;
	}

	
}
