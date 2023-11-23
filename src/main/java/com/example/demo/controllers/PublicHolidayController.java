package com.example.demo.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.PublicHolidayItem;
import com.example.demo.services.PublicHolidayItemService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PublicHolidayController {
	
	@Autowired
	private PublicHolidayItemService publicHolidayItemService;

	
	@GetMapping("/getData")
	public ModelAndView getUpdatedHolidayData() {
		
//		test
		try {
			JsonNode json = new ObjectMapper().readTree(new URL("https://www.1823.gov.hk/common/ical/en.json"));
			
//			print content test
			System.out.println(json.get("vcalendar").get("vevent"));
//			System.out.println("JSON Data:\t" + json);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ModelAndView modelAndView = new ModelAndView("index");
		

		return modelAndView;
		
		
		// example: parse a string to LocalDate
//		LocalDate date1 = LocalDate.parse("20220416", DateTimeFormatter.BASIC_ISO_DATE);
		
	}

	
	public void insertPublicHolidayItem(String uid, LocalDate dtstart, LocalDate dtend, String summary) {
		PublicHolidayItem item = new PublicHolidayItem();
		
		item.setUid("test");
		item.setDtstart(null);
		item.setDtend(null);
		item.setSummary(null);
		
		
		publicHolidayItemService.save(item);
	}
	
	
//	@GetMapping("/search")
	
}
