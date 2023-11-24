package com.example.demo.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.PublicHolidayItem;
import com.example.demo.repositories.PublicHolidayRepo;


@Service
public class PublicHolidayItemService {
	
	@Autowired
	private PublicHolidayRepo publicHolidayRepo;
	
	// Get all public holidays from the database	
	public Iterable<PublicHolidayItem> getAll(){
		return publicHolidayRepo.findAll();
	}
	
	public Optional<PublicHolidayItem> getById(String uid){
		return publicHolidayRepo.findById(uid);
	}
	
	public Iterable<PublicHolidayItem> findAllHolidayFromStart(LocalDate dtstart){
		return publicHolidayRepo.findAllHolidayFromStart(dtstart);
	}
	
	public Iterable<PublicHolidayItem> findAllHolidayBeforeEnd(LocalDate dtend){
		return publicHolidayRepo.findAllHolidayBeforeEnd(dtend);
	}
	
	public Iterable<PublicHolidayItem> findAllHolidayBetweenStartEnd(LocalDate dtstart, LocalDate dtend){
		return publicHolidayRepo.findAllHolidayBetweenStartEnd(dtstart, dtend);
	}	
	

	// Insert that holiday item if not existing in the database
	public void save(PublicHolidayItem publicHolidayItem) {
		
		// check whether the holiday is existed				
		if(getById(publicHolidayItem.getUid()).isEmpty()) {
			
			publicHolidayRepo.save(publicHolidayItem);
		}
		//test		
		else {
			System.out.println("Already Be Inserted");
		}
		
	}
	
	// Delete the holiday item from the database
	public void delete(PublicHolidayItem publicHolidayItem) {
		
		publicHolidayRepo.delete(publicHolidayItem);
	}
	
	public void deleteAll() {
		publicHolidayRepo.deleteAll();
	}
	
}
