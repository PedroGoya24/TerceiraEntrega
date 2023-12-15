package com.adois.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adois.models.Destiny;

@Repository
public interface DestinyRepository extends JpaRepository<Destiny, Long>{
	
	
}
