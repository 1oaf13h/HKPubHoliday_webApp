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
	
	
	//unfinished
//	ver1
//    @Query("select a from publicHoliday_item p where p.dtstart between :dtstart and :dtend")
//    public Optional<PublicHolidayItem> findAllWithCreationDateTimeBefore(
//      @Param("dtstart") String date_from, @Param("dtend") String date_end);
	
//	ver2
	@Query(value = "SELECT * FROM publicHoliday_item p WHERE p.dtstart >= ?1 AND p.dtend <= ?2", nativeQuery = true)
	public Optional<PublicHolidayItem> findAllWithCreationDateTimeBefore(LocalDate dtstart, LocalDate dtend);
}
