package com.adois.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import com.adois.util.accesLevel;

@Entity
public class Client extends User {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "Login", length = 20, nullable = false)
	private String Login;
	
	@Column(name = "Password", length = 20, nullable = false)
	private String Password;

	public Client(Long idUser, String nameUser, String cpfUser, String telephoneUser, String emailUser,
			accesLevel accesLevel, String Login, String Password) {
		super(idUser, nameUser, cpfUser, telephoneUser, emailUser, accesLevel);
		this.Login = Login;
		this.Password = Password;
	}
	
	public Client() {
		
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String Login) {
		this.Login = Login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
