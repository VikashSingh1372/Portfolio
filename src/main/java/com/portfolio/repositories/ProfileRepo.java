package com.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.models.profile;

public interface ProfileRepo extends JpaRepository<profile, Integer> {

}
