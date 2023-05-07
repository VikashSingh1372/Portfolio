package com.portfolio.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.portfolio.models.Details;

public interface detailRepo  extends JpaRepository<Details, Integer>{

	
	

	@Query("from Details as d where d.project.id=:Id")
	Set<Details> findDetailByproject(@Param("Id") int Id);
	
	
}
