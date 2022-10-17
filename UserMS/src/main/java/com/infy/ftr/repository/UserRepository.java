package com.infy.ftr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.ftr.entity.UserProfileEntity;

@Repository
public interface UserRepository extends JpaRepository<UserProfileEntity, Integer> {
	
	public Optional<UserProfileEntity> findByPassportNumber(String passportNumber);

}