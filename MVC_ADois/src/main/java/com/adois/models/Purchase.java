package com.adois.models;

import java.time.LocalDate;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "Purchase")
public class Purchase {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPurchase;
	
	@Column(nullable = false)
	private LocalDate backData;
	
	@Column(nullable = false)
	private LocalDate goData;		
	
	@ManyToOne
	@JoinColumn(name = "idUser", nullable = false)
	private User user;

	

	
	@ManyToOne
	@JoinColumn(name = "id_pac")
	private Package newPackage;
	
	
	
	
	public Purchase(Long idPurchase, LocalDate backData, LocalDate goData) {		
		this.idPurchase = idPurchase;
		this.backData = backData;
		this.goData = goData;
	}

	public Purchase() {
		
	}

	public Long getIdPurchase() {
		return idPurchase;
	}

	public void setIdPurchase(Long idPurchase) {
		this.idPurchase = idPurchase;
	}

	public LocalDate getBackData() {
		return backData;
	}

	public void setBackData(LocalDate backData) {
		this.backData = backData;
	}

	public LocalDate getGoData() {
		return goData;
	}

	public void setGoData(LocalDate goData) {
		this.goData = goData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Package getNewPackage() {
		return newPackage;
	}

	public void setNewPackage(Package newPackage) {
		this.newPackage = newPackage;
	}
	
	
	
}
