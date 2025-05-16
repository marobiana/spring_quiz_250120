package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
	// Spring Data JPA
	//public CompanyEntity save(엔티티객체);
	//public Optional<CompanyEntity> findById(id);
}
