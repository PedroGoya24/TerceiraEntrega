package com.adois.repositoryes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adois.models.Admin;
import com.adois.util.accesLevel;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	@Query
	(value = "SELECT * FROM users WHERE acces_level='ADMINISTRADOR'", nativeQuery = true)
	public List<Admin> findByAccesLevel(accesLevel accesLevel);
}
