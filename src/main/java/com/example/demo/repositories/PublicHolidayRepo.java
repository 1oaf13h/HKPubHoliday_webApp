package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PublicHolidayItem;



@Repository
public interface PublicHolidayRepo extends JpaRepository <PublicHolidayItem, String>{
	
	
//	@Override
//	public Optional<PublicHolidayItem> findById(String uid);
	
//	public Optional<PublicHolidayItem> findByName(String uid);
	
	
	@Query(value = "SELECT * FROM public_holiday_item p WHERE p.dtstart >= ?1", nativeQuery = true)
	public Iterable<PublicHolidayItem> findAllHolidayFromStart(LocalDate dtstart);
	
	
	@Query(value = "SELECT * FROM public_holiday_item p WHERE p.dtend <= ?1", nativeQuery = true)
	public Iterable<PublicHolidayItem> findAllHolidayBeforeEnd(LocalDate dtend);
	

	@Query(value = "SELECT * FROM public_holiday_item p WHERE p.dtstart >= ?1 AND p.dtend <= ?2", nativeQuery = true)
	public Iterable<PublicHolidayItem> findAllHolidayBetweenStartEnd(LocalDate dtstart, LocalDate dtend);

	
}


