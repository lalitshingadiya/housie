package com.game.housie.controller;

import com.game.housie.dto.EventDTO;
import com.game.housie.entity.Event;
import com.game.housie.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//import com.google.gson.Gson;

@RestController
@RequestMapping("/Event")
public class EventController {

	@Autowired
	private EventService eventService;
	
	
	@PostMapping("/save")
	public String saveEvent(Event e) {
		return "";
	}
	
	@GetMapping(value = "/getAll",produces = "application/json")

	public List<EventDTO> getAll() {
//		String strReturn="";
//		 List<Event> lst= eventService.findAllEvents();
//		// Gson gson = new Gson();
//		// strReturn=gson.toJson(lst);
		 List<EventDTO> lst= eventService.findAllEvents();
		return lst;
	}
	

}
