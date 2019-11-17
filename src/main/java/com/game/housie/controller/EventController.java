package com.game.housie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.housie.entity.Event;
import com.game.housie.service.EventService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/Event")
public class EventController {

	@Autowired
	private EventService eventService;
	
	
	@PostMapping("/save")
	public String saveEvent(Event e) {
		return "";
	}
	
	@GetMapping("/getAll")
	public String getAll() {
		String strReturn="";
		 List<Event> lst= eventService.findAllEvents(); 
		 Gson gson = new Gson(); 
		 strReturn=gson.toJson(lst);
		 
		return strReturn ;
	}
	

}
