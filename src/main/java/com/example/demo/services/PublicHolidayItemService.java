package com.example.demo.services;

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
	
//	public List<PublicHolidayItem> findAllByDateBetween(String dtstart, String dtend){
	
	
//	}
	
	
	// Insert that holiday item if not existing in the database
	public void save(PublicHolidayItem publicHolidayItem) {
		
		
		// check whether the holiday is existed		
		if(getById(publicHolidayItem.getUid()) == null) {
//		if (publicHolidayItem.getUid() == null) {
			
			publicHolidayRepo.save(publicHolidayItem);
		}
		
	}
	
	//remove
	public void delete(PublicHolidayItem publicHolidayItem) {
		
		publicHolidayRepo.delete(publicHolidayItem);
	}
	
}
