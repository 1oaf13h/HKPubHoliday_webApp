package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PublicHolidayItem;


@Repository
public interface PublicHolidayRepo extends JpaRepository <PublicHolidayItem, String>{
	
	
//	@Override
//	public Optional<PublicHolidayItem> findById(String uid);
	
//	public Optional<PublicHolidayItem> findByName(String uid);
	
}
