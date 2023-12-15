package com.adois.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adois.models.User;

public interface UserRepository extends JpaRepository <User, Long>{

}
