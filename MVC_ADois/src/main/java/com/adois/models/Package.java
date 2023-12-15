package com.adois.models;

import java.util.List;

import com.adois.util.typePac;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Package")
public class Package {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPac;
	
	@Column(nullable = false)
	private Boolean promo;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private typePac typePac;
	
	@Column(nullable = false)
	private Double pricePac;
	
	@OneToMany(mappedBy = "newPackage")
	private List<Purchase> purchase;
	
	@ManyToOne
	@JoinColumn(name = "id_destiny")
	private Destiny destiny;
	
	
	public Package() {
		
	}

	public Package(Long idPac, Boolean promo, typePac typePac, Double pricePac, Purchase purchase) {		
		this.idPac = idPac;
		this.promo = promo;
		this.typePac = typePac;
		this.pricePac = pricePac;		
	}

	

	public Long getIdPac() {
		return idPac;
	}

	public void setIdPac(Long idPac) {
		this.idPac = idPac;
	}

	public Boolean getPromo() {
		return promo;
	}

	public void setPromo(Boolean promo) {
		this.promo = promo;
	}

	public typePac getTypePac() {
		return typePac;
	}

	public void setTypePac(typePac typePac) {
		this.typePac = typePac;
	}

	public Double getPricePac() {
		return pricePac;
	}

	public void setPricePac(Double pricePac) {
		this.pricePac = pricePac;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Destiny getDestiny() {
		return destiny;
	}

	public void setDestiny(Destiny destiny) {
		this.destiny = destiny;
	}
	
	
	 
}
