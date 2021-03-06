package com.dique.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dique.entities.PagesData;

@Repository
	public interface PagesDataRepository extends JpaRepository<PagesData, Long> {
		public Optional<PagesData> findById(Long id);
		public Iterable<PagesData> findAllByOrderByIdDesc();
	}
