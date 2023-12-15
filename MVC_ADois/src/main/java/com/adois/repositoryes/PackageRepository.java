package com.adois.repositoryes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adois.models.Package;


@Repository
public interface PackageRepository extends JpaRepository<Package, Long>{
	@Query
	(value = "SELECT * FROM package WHERE id_destiny = :idDest", nativeQuery = true)
	public List<Package> findAllByIdDestiny(@Param("idDest") Long destiny);
}
