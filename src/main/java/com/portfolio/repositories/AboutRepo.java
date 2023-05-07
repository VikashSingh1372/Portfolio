package com.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.models.About;

public interface AboutRepo extends JpaRepository<About, Integer> {

}
