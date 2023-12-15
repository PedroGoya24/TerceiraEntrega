package com.adois.util;

public enum accesLevel {
	CLIENTE("CLIENTE"),
	ADMINISTRADOR("ADMINISTRADOR");
	
	private final String nome;

	private accesLevel(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	
}
