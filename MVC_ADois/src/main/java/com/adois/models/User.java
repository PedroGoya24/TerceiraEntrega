package com.adois.models;


import java.util.List;

import com.adois.util.accesLevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	@Column(nullable = false)	
	private String nameUser;
	
	@Column(nullable = false, length = 11)	
	private String cpfUser;
	
	@Column(length = 11)
	private String telephoneUser;
	
	@Column(nullable = false)
	private String emailUser;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private accesLevel accesLevel;

	
	@OneToMany(mappedBy = "user")
	private List<Purchase> purchase;
	
	
	public User(Long idUser, String nameUser, String cpfUser, String telephoneUser, String emailUser,
			com.adois.util.accesLevel accesLevel) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.cpfUser = cpfUser;
		this.telephoneUser = telephoneUser;
		this.emailUser = emailUser;
		this.accesLevel = accesLevel;
	}

	public User() {
		
	}
	
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getCpfUser() {
		return cpfUser;
	}

	public void setCpfUser(String cpfUser) {
		this.cpfUser = cpfUser;
	}

	public String getTelephoneUser() {
		return telephoneUser;
	}

	public void setTelephoneUser(String telephoneUser) {
		this.telephoneUser = telephoneUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public accesLevel getAccesLevel() {
		return accesLevel;
	}

	public void setAccesLevel(accesLevel accesLevel) {
		this.accesLevel = accesLevel;
	}


	
	
	
	
	
	
	
}
