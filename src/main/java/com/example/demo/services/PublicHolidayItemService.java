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
	
	// Insert that holiday item if not existing in the database
//	public PublicHolidayItem importHoliday(PublicHolidayItem publicHolidayItem) {
//		if (publicHolidayItem.getUid() == null) {
//			
//		}
//	}
	
}
