package br.senai.sp.lojaquiosque.model;

public enum TipoProduto {
 ELETRONICO("eletr�nicos"),DOMESTICO("dom�sticos");
	
	String desc;

	private TipoProduto(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return this.desc;
	}

	
}
