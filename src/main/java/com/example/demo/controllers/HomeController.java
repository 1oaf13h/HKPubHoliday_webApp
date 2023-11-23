package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.services.PublicHolidayItemService;


@Controller
public class HomeController {

	
	@Autowired
	private PublicHolidayItemService publicHolidayItemService;
	
	
	// Return index.html page, 
	// using ModelAndView can hold for both "Model" and "View" to return a single (combined) instance 
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		

		return modelAndView;
	}
	
	
	
}
