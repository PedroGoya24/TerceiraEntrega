
package com.adois.repositoryes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adois.models.Client;
import com.adois.util.accesLevel;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	@Query
	(value = "SELECT * FROM users WHERE acces_level='CLIENTE'", nativeQuery = true)
	public List<Client> findByAccesLevel(accesLevel accesLevel);
}
