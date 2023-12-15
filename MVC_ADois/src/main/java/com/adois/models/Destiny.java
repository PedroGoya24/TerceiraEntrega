package com.adois.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Destiny")
public class Destiny {
	
	private final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDest;
	
	@Column(nullable = false)
	private String nameDest;
	
	@Column(columnDefinition = "longblob")
	private byte[] imgDest;
	
	@OneToMany(mappedBy = "destiny")
	private List<Package> packAge;
	
	
	public Destiny() {
		
	}

	public Destiny(Long idDest, String nameDest, byte[] imgDest) {
		
		this.idDest = idDest;
		this.nameDest = nameDest;
		this.imgDest = imgDest;		
	}

	public Long getIdDest() {
		return idDest;
	}

	public void setIdDest(Long idDest) {
		this.idDest = idDest;
	}

	public String getNameDest() {
		return nameDest;
	}

	public void setNameDest(String nameDest) {
		this.nameDest = nameDest;
	}

	public byte[] getImgDest() {
		return imgDest;
	}

	public void setImgDest(byte[] imgDest) {
		this.imgDest = imgDest;
	}

	public long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	
}
