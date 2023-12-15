package com.adois.util;

public enum typePac {
	BASIC("BASICO"),
	STANDARD("PADRAO"),
	MASTER("MASTER");
	
	private final String name;
	
	private typePac(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
}
