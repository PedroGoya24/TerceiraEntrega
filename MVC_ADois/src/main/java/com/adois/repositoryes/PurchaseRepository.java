package com.adois.repositoryes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adois.models.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

	@Query
	(value = "SELECT * FROM purchase WHERE id_user = :idUser", nativeQuery = true)
	public List<Purchase> findAllByIdClient(@Param("idUser") Long client);
}
