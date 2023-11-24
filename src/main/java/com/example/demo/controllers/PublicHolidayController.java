package com.example.demo.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.PublicHolidayItem;
import com.example.demo.services.PublicHolidayItemService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

@Controller
public class PublicHolidayController {
	
	@Autowired
	private PublicHolidayItemService publicHolidayItemService;

	
    /**
     * Method that will get the updated holidays from the url 
     */
	@GetMapping("/getData")
	public ModelAndView getUpdatedHolidayData() {
		
		try {
			
			// Get the updated holidays from the .json file retrieved from the url
			JsonNode root = new ObjectMapper().readTree(new URL("https://www.1823.gov.hk/common/ical/en.json"));
			
	
			// Insert all holidays into the database
			if(root.get("vcalendar").get(0).get("vevent") != null && root.get("vcalendar").get(0).get("vevent").isArray()) {
			
				final ArrayNode arrayNode = (ArrayNode) root.get("vcalendar").get(0).get("vevent");
				
				for (JsonNode node : arrayNode) {
		
					insertPublicHolidayItem(node.get("uid").asText(), 
							LocalDate.parse(node.get("dtstart").get(0).asText(), DateTimeFormatter.BASIC_ISO_DATE), 
							LocalDate.parse(node.get("dtstart").get(0).asText(), DateTimeFormatter.BASIC_ISO_DATE), 
							node.get("summary").asText());			
				}			
			}
				

		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// display the holidays in the table in the index page
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("publicHolidayItems", publicHolidayItemService.getAll());
		
		return modelAndView;
	}
	


	@GetMapping("/search")
	public ModelAndView serachRangeHoliday(Model model, @RequestParam(value="dtstart") String dtstart, @RequestParam(value="dtend")  String dtend) {
		
		// testing
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		// Given 2 dates:	"Start Date" and "End Date"
		if(!dtstart.isEmpty() && !dtend.isEmpty()) {
			LocalDate startDate = LocalDate.parse(dtstart, DateTimeFormatter.ISO_LOCAL_DATE);
			LocalDate endDate = LocalDate.parse(dtend, DateTimeFormatter.ISO_LOCAL_DATE);
			
			System.out.println(startDate);
			System.out.println(endDate);
			
			
			modelAndView.addObject("publicHolidayItems", publicHolidayItemService.findAllHolidayBetweenStartEnd(startDate, endDate));
			
		}else if(!dtstart.isEmpty() && dtend.isEmpty()) {	// Given only 1 date:	"Start Date"
			LocalDate startDate = LocalDate.parse(dtstart, DateTimeFormatter.ISO_LOCAL_DATE);
			
			modelAndView.addObject("publicHolidayItems", publicHolidayItemService.findAllHolidayFromStart(startDate));
			
		}else if(dtstart.isEmpty() && !dtend.isEmpty()){
			
			LocalDate endDate = LocalDate.parse(dtend, DateTimeFormatter.ISO_LOCAL_DATE);
			
			modelAndView.addObject("publicHolidayItems", publicHolidayItemService.findAllHolidayBeforeEnd(endDate));
		}
		
			
		return modelAndView;
	}	
	
	
	
	public void insertPublicHolidayItem(String uid, LocalDate dtstart, LocalDate dtend, String summary) {
		
		PublicHolidayItem item = new PublicHolidayItem();
		item.setUid(uid);
		item.setDtstart(dtstart);
		item.setDtend(dtend);
		item.setSummary(summary);
		
		
		publicHolidayItemService.save(item);
	}
	

}
