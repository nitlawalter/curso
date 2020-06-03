package com.walter.curso.domain.enums;

public enum TipoCliente {

	PESSOA_FISICA(1, "pessoa fisica"),
	PESSOA_JURIDICA(2, "pessoa juridica");
	
	private int cod;
	private String nome;
	
	private TipoCliente(int cod, String nome) {
		this.cod = cod;
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public String getNome() {
		return nome;
	}

	public static TipoCliente toEnum(Integer id) {
		
		if(id == null) {
			return null;
		}
		
		for(TipoCliente tp : TipoCliente.values()) {
			if(id.equals(tp.getCod())) {
				return tp;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + id);
	}
	
	
}
