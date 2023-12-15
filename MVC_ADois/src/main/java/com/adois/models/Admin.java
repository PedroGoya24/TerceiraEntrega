package com.adois.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Admin extends User{
	
	@Column(name = "Login", length = 20, nullable = false)
	private String Login;
	@Column(name = "Password", length = 20, nullable = false)
	private String Password;
	
	public Admin(Long idUser, String nameUser, String cpfUser, String telephoneUser, String emailUser,
			com.adois.util.accesLevel accesLevel, String login, String password) {
		super(idUser, nameUser, cpfUser, telephoneUser, emailUser, accesLevel);
		Login = login;
		Password = password;
	}
	public Admin() {
		 
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	
}
