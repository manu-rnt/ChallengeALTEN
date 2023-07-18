package com.zara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zara.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
	Brand findByName(String name);
}

